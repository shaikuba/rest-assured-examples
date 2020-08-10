package cn.shaikuba.mock.manage;

import com.google.common.collect.Maps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

public class GetRequestTest {

    @Test
    public void testGetMockObj() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/api";

        Map pathParams = Maps.newHashMap();
        pathParams.put("id", 1);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .get("/cart/goods/{id}", pathParams);
        response.body().prettyPrint();

    }

    @Test
    public void testGetQueryStringMockObj() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/api";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("goodsId", 1)
                .get("/cart/goods");
        response.body().prettyPrint();

    }

}
