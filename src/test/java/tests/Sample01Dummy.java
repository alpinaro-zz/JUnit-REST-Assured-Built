package tests;

import base.BaseDummy;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Sample01Dummy extends BaseDummy {

    Response response;

    @Test
    void GetEmployees() {

        specDummy.pathParam("pp1", "employees");

        response = given().spec(specDummy).when().get("/{pp1}");

        response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61, 30, 40));
    }
}
