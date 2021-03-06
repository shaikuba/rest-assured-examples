package cn.shaikuba.mock.manage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PutRequestTest {

    @Test
    public void testPostPerson() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/api";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .pathParam("id", 1)
                .put("/person/{id}");

        response.body().prettyPrint();

    }

}
