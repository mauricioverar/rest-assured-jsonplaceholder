package cl.mauriciovera.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo; // Hamcrest para aserciones legibles.  

public class UserApiTest {
  @BeforeClass
  public void setup() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; // Configura `baseURI` una vez en `@BeforeClass`.
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
        .body("name", equalTo("Leanne Graham")); // Nota: en typicode, el nombre real es este
  }
}
