package tests;

import base.BaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Sample05Dummy_DeleteAnEmployee extends BaseDummy {

    Response response;

    int employeeId = testDataDummy.deleteEmployeeId;

    @Test
    void deleteAnEmployee() {

        // Expected Data
        JSONObject expectedData = testDataDummy.deleteEmployeeExpectedData();

        // Response
        specDummy.pathParams("pp1", "delete", "pp2", employeeId);

        response = given().spec(specDummy).when().delete("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath responseJson = response.jsonPath();

        // Assertions
        assertEquals(testDataDummy.statusCodeSuccess, response.getStatusCode());
        assertEquals(expectedData.get("status"), responseJson.get("status"));
        assertEquals(expectedData.get("data"), responseJson.get("data"));
        assertEquals(expectedData.get("message"), responseJson.get("message"));
    }
}