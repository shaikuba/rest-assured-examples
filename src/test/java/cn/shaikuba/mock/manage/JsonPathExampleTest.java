package cn.shaikuba.mock.manage;

import com.alibaba.fastjson.JSONObject;
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

public class JsonPathExampleTest {

    @Test
    public void deserializeTest() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "/mock/api";

        Map queryParams = Maps.newHashMap();
        queryParams.put("cartId", 1);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .params(queryParams)
                .get("/cart/goods");


        System.out.println(response.jsonPath().getInt("cartId"));

        System.out.println(response.jsonPath().getList("goodsList", Goods.class));

        System.out.println(response.jsonPath().getObject("goodsList[1]", Goods.class));

        System.out.println(response.jsonPath().getObject("goodsList.find {field -> field.goodsName == 'XiaoMi'}", Goods.class));

        System.out.println(response.jsonPath().getList("goodsList.findAll {field -> field.amount > 3}", Goods.class));
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
