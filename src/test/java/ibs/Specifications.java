package ibs;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;




public class Specifications {

    private static Cookies cookies = getCookies();

    private static Cookies getCookies() {
        return RestAssured.given()
                .when()
                .get("/api/food")
                .getDetailedCookies();
    }

    public static RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfProperties.getProperty("url"))
                .setContentType("application/json")
                .addCookies(cookies)
                .build();
    }

    public static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void installSpecification(RequestSpecification requestSpecification,
                                            ResponseSpecification responseSpecification) {
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

}
