package cn.shaikuba.mock.manage;

import com.google.common.collect.Maps;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import lombok.Data;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ResponseDeserializationTest {

    @Test
    public void deserializationTest() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/api";

        Map pathParams = Maps.newHashMap();
        pathParams.put("cartId", 1);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .params(pathParams)
                .get("/cart/goods");

        response.prettyPrint();

        Cart cart = response.as(Cart.class);
        response.as(Cart.class, new ObjectMapper() {
            public Object deserialize(ObjectMapperDeserializationContext context) {
                return null;
            }

            public Object serialize(ObjectMapperSerializationContext context) {
                return null;
            }
        });

        System.out.printf(cart.toString());
    }

    @Data
    public static class Cart {
        private Integer cartId;
        private List<Goods> goodsList;

    }

    @Data
    public static class Goods {
        private String goodsName;
        private Double price;
        private Integer amount;
        private String description;

    }
}
