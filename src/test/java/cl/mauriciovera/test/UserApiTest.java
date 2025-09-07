package cl.mauriciovera.test;

import org.testng.annotations.BeforeClass; // usando TestNG
import org.testng.annotations.Test;

import io.restassured.RestAssured; // RestAssured
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*; // Hamcrest para aserciones legibles.  equalTo, lessThan

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

  @Test
  public void obtenerUsuario_DebeResponderEnMenosDe2Segundos() {
    given()
        .log().all() // Log de la petición
        .when()
        .get("/users/1")
        .then()
        .time(lessThan(2000L)) // Tiempo en ms
        .log().all() // Log de la respuesta, es útil para debugging. 
        // Puedes usar  `.log().ifValidationFails()` para logs solo en fallo.
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", equalTo(1));
  }
}
