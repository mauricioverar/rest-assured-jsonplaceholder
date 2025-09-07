package cl.mauriciovera.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiParametrizadoTest {
  @BeforeClass
  public void setup() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
  }

  @DataProvider(name = "userIds")
  public Object[][] userIds() {
    return new Object[][] {
        { 1 }, { 2 }, { 3 }, { 4 }, { 5 }
    };
  }

  @Test(dataProvider = "userIds")
  public void obtenerUsuario_PorId_DebeCoincidirIdEnRespuesta(int userId) {
    given()
        .when()
        .get("/users/" + userId)
        .then()
        .statusCode(200)
        .body("id", equalTo(userId));
  }
}
