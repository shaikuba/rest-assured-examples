package cn.shaikuba.mock.manage;

import com.google.common.collect.Maps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class PostRequestTest {

    @Test
    public void testPostPerson() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/api";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Bruce Lee\"}")
                .post("/person");

        response.body().prettyPrint();

    }

}
