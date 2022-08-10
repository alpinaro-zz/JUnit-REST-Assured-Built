package tests;

import base.BaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Sample02Dummy_GetAnEmployee extends BaseDummy {

    Response response;
    int employeeId = testDataDummy.getEmployeeId;

    @Test
    void getAnEmployeeWithJSON() {

        // Expected Data
        JSONObject expectedData = testDataDummy.getEmployeeExpectedDataJSON();

        // Response
        specDummy.pathParams("pp1", "employee", "pp2", employeeId);

        response = given().spec(specDummy).when().get("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath responseJson = response.jsonPath();

        // Assertions
        assertEquals(testDataDummy.statusCodeSuccess, response.getStatusCode());
        assertEquals(expectedData.get("status"), responseJson.get("status"));
        assertEquals(expectedData.getJSONObject("data").get("id"), responseJson.get("data.id"));
        assertEquals(expectedData.getJSONObject("data").get("employee_name"), responseJson.get("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").get("employee_salary"), responseJson.get("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").get("employee_age"), responseJson.get("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").get("profile_image"), responseJson.get("data.profile_image"));
        assertEquals(expectedData.get("message"), responseJson.get("message"));
    }

    @Test
    void getAnEmployeeWithMap() {

        // Expected Data
        HashMap<String, Object> expectedData = testDataDummy.getEmployeeExpectedDataMap();

        // Response
        specDummy.pathParams("pp1", "employee", "pp2", employeeId);

        response = given().spec(specDummy).when().get("/{pp1}/{pp2}");

        response.prettyPrint();

        HashMap<String, Object> responseMap = response.as(HashMap.class);

        // Assertions
        assertEquals(testDataDummy.statusCodeSuccess, response.getStatusCode());
        assertEquals(expectedData.get("status"), responseMap.get("status"));
        assertEquals(((Map)expectedData.get("data")).get("id"), ((Map)responseMap.get("data")).get("id"));
        assertEquals(((Map)expectedData.get("data")).get("employee_name"), ((Map)responseMap.get("data")).get("employee_name"));
        assertEquals(((Map)expectedData.get("data")).get("employee_salary"), ((Map)responseMap.get("data")).get("employee_salary"));
        assertEquals(((Map)expectedData.get("data")).get("employee_age"), ((Map)responseMap.get("data")).get("employee_age"));
        assertEquals(((Map)expectedData.get("data")).get("profile_image"), ((Map)responseMap.get("data")).get("profile_image"));
        assertEquals(expectedData.get("message"), responseMap.get("message"));
    }
}