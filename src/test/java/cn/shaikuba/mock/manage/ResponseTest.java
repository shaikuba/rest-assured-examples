package cn.shaikuba.mock.manage;

import com.google.common.collect.Maps;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class ResponseTest {

    @Test
    public void testGetMockObj() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/api";

        Map pathParams = Maps.newHashMap();
        pathParams.put("id", 1);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .get("/cart/goods/{id}", pathParams);

//        response.print();
//        response.prettyPrint();
//
//        response.peek();
//        response.prettyPeek();

//        Map<String,String> bodyAsMap = response.as(new TypeRef<Map>() {
//        });
//        System.out.println(bodyAsMap.get("goodsName"));

        System.out.println(response.asString());
    }

}
