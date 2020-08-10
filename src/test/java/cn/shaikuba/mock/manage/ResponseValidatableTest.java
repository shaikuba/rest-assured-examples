package cn.shaikuba.mock.manage;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ResponseValidatableTest {

    @Test
    public void testGetMockObj() {

        RestAssured.given()
                .baseUri("http://localhost:8080/")
                .basePath("/mock/manage")
                .contentType("application/json")
                .when()
                .get("/2")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Connection", "keep-alive")
                .and()
                .rootPath("data")
                .body("statusCode", Matchers.equalTo(200));
    }
}
