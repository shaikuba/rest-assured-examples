package cn.shaikuba.mock.manage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class HttpMockManagementTest {

    @Test
    public void testGetMockObj() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/manage";

        Response response = RestAssured.given()
                .get("/2");
        response.body().prettyPrint();

        RestAssured.given()
                .get("/2")
                .then()
                .body("data.id", Matchers.equalTo(2));
    }
}
