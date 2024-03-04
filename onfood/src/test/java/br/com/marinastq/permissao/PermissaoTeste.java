package br.com.marinastq.permissao;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(PermissaoResource.class) 
public class PermissaoTeste {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/permissoes")
          .then()
             .statusCode(201)
             //.body(is("Hello RESTEasy"))
             ;
    }
}
