package tests;

import base.BaseDummy;
import io.restassured.http.ContentType;
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
public class Sample04Dummy_PutAnEmployee extends BaseDummy {

    Response response;

    int employeeId = testDataDummy.putEmployeeId;

    @Test
    void putAnEmployee() {

        // Expected Data
        JSONObject expectedData = testDataDummy.putEmployeeExpectedData();

        // Request Body
        JSONObject requestBody = testDataDummy.putEmployeeRequestBody();

        // Response
        specDummy.pathParams("pp1", "update", "pp2", employeeId);

        response = given().spec(specDummy).contentType(ContentType.JSON).when().body(requestBody.toString()).put("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath responseJson = response.jsonPath();

        // Assertions
        assertEquals(testDataDummy.statusCodeSuccess, response.getStatusCode());
        assertEquals(expectedData.get("status"), responseJson.get("status"));
        assertEquals(expectedData.getJSONObject("data").get("id"), responseJson.get("data.id"));
        assertEquals(expectedData.getJSONObject("data").get("name"), responseJson.get("data.name"));
        assertEquals(expectedData.getJSONObject("data").get("salary"), responseJson.get("data.salary"));
        assertEquals(expectedData.getJSONObject("data").get("age"), responseJson.get("data.age"));
        assertEquals(expectedData.get("message"), responseJson.get("message"));
    }
}