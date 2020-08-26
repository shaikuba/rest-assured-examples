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

        Map queryParams = Maps.newHashMap();
        queryParams.put("cartId", 1);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .params(queryParams)
                .get("/cart/goods");

        //response.prettyPrint();
        System.out.println(response.<Integer>path("cartId"));
        System.out.println(response.jsonPath().getInt("cartId"));

        System.out.println(response.jsonPath().getString("goodsList[0].goodsName"));

        System.out.println(response.jsonPath().getString("goodsList.find{ field -> field.goodsName == 'XiaoMi'}"));
        System.out.println(response.jsonPath().getString("goodsList.'*'.find{ field -> field.goodsName == 'XiaoMi'}"));
        System.out.println(response.jsonPath().getString("goodsList.findAll{ field -> field.goodsName == 'XiaoMi'}"));

        System.out.println(response.jsonPath().getString("goodsList.size()"));

        System.out.println(response.jsonPath().getString("goodsList.findAll {field -> field.size() > 1}"));
    }

}
