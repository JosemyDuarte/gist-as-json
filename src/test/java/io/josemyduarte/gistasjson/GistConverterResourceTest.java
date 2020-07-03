package io.josemyduarte.gistasjson;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class GistConverterResourceTest {

    @Test
    public void testAsJsonEndpoint() {
        given()
                .when().get("/asJson?url=https://gist.githubusercontent.com/JosemyDuarte/7e05cad1dadfec4eb2af44e9a66f8f39/raw/d64c278204414faa9b0f3873e1b2dc66a0bd5931/resume.json")
                .then()
                .statusCode(200)
                .body(is(not(nullValue())));
    }

    @Test
    public void testAsJsonEndpointWithInvalidJson() {
        given()
                .when().get("/asJson?url=https://gist.githubusercontent.com/JosemyDuarte/7892331a75bf3412af78f0df1b82bf07/raw/169c97bfca829013d8076ba574bcaef18ada37b5/search.py")
                .then()
                .statusCode(200)
                .body("message", is(not(nullValue())));
    }

}