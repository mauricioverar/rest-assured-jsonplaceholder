package cl.mauriciovera.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTest {
  @BeforeClass
  public void setup() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
  }

  @Test
  public void obtenerUsuario_DebeRetornarUsuarioConId1YNombreJohnDoe() {
    given()
        .when()
        .get("/users/1")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", equalTo(1))
        .body("name", equalTo("Leanne Graham"));
  }

  @Test
  public void obtenerUsuario_DebeResponderEnMenosDe2Segundos() {
    given()
        .log().all()
        .when()
        .get("/users/1")
        .then()
        .time(lessThan(2000L))
        .log().all() // Log de la respuesta, es útil para debugging. 
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", equalTo(1));
  }
}
