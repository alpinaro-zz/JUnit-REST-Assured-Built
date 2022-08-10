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
public class Sample03Dummy_PostAnEmployee extends BaseDummy {

    Response response;

    @Test
    void postAnEmployee() {

        // Expected Data
        JSONObject expectedData = testDataDummy.postEmployeeExpectedData();

        // Request Body
        JSONObject requestBody = testDataDummy.postEmployeeRequestBody();

        // Response
        specDummy.pathParam("pp1", "create");

        response = given().spec(specDummy).contentType(ContentType.JSON).when().body(requestBody.toString()).post("/{pp1}");

        response.prettyPrint();

        JsonPath responseJson = response.jsonPath();

        // Assertions
        assertEquals(testDataDummy.statusCodeSuccess, response.getStatusCode());
        assertEquals(expectedData.get("status"), responseJson.get("status"));
        assertEquals(expectedData.getJSONObject("data").get("name"), responseJson.get("data.name"));
        assertEquals(expectedData.getJSONObject("data").get("salary"), responseJson.get("data.salary"));
        assertEquals(expectedData.getJSONObject("data").get("age"), responseJson.get("data.age"));
        assertEquals(expectedData.get("message"), responseJson.get("message"));
    }
}