package data;

import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {

    public int statusCodeSuccess = 200;
    public static int getEmployeeId = 1;
    public static int putEmployeeId = 40;

    // Request Bodies
    public JSONObject postEmployeeRequestBody() {

        JSONObject body = new JSONObject();
        body.put("name", "Ece Çınaroğlu");
        body.put("salary", 180000);
        body.put("age", 32);

        return body;
    }

    public JSONObject putEmployeeRequestBody() {

        JSONObject body = new JSONObject();
        body.put("id", putEmployeeId);
        body.put("name", "Alper Çınaroğlu");
        body.put("salary", 180000);
        body.put("age", 40);

        return body;
    }

    // Expected Data
    public JSONObject getEmployeeExpectedDataJSON() {

        JSONObject data = new JSONObject();
        data.put("id", getEmployeeId);
        data.put("employee_name", "Tiger Nixon");
        data.put("employee_salary", 320800);
        data.put("employee_age", 61);
        data.put("profile_image", "");

        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data", data);
        expectedData.put("message", "Successfully! Record has been fetched.");

        return expectedData;
    }

    public HashMap<String, Object> getEmployeeExpectedDataMap() {

        HashMap<String, Object> data = new HashMap<>();
        data.put("id", (double) getEmployeeId); // Response map returns numbers in decimal.
        data.put("employee_name", "Tiger Nixon");
        data.put("employee_salary", 320800.0); // Response map returns numbers in decimal.
        data.put("employee_age", 61.0); // Response map returns numbers in decimal.
        data.put("profile_image", "");

        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("status", "success");
        expectedData.put("data", data);
        expectedData.put("message", "Successfully! Record has been fetched.");

        return expectedData;
    }

    public JSONObject postEmployeeExpectedData() {

        JSONObject data = new JSONObject();
        data.put("name", "Ece Çınaroğlu");
        data.put("salary", 180000);
        data.put("age", 32);

        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data", data);
        expectedData.put("message", "Successfully! Record has been added.");

        return expectedData;
    }

    public JSONObject putEmployeeExpectedData() {

        JSONObject data = new JSONObject();
        data.put("id", putEmployeeId);
        data.put("name", "Alper Çınaroğlu");
        data.put("salary", 180000);
        data.put("age", 40);

        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data", data);
        expectedData.put("message", "Successfully! Record has been updated.");

        return expectedData;
    }
}