package cn.shaikuba.mock.manage;

import com.google.common.collect.Maps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class JsonPathTest {

    @Test
    public void testGetMockObj() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/api";

        Map pathParams = Maps.newHashMap();
        pathParams.put("id", 1);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .get("/cart/goods/{id}", pathParams);

        response.prettyPrint();
        System.out.println(response.<Integer>path("amount"));
        System.out.println(response.jsonPath()
                .getInt("amount"));

    }

}
