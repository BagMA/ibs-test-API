package ibs;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import io.qameta.allure.Step;

import java.sql.SQLException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CheckAPI {

    @Step("Получение списка с продуктами")
    public static void getElemTest() {

        Specifications.installSpecification(Specifications.requestSpecification(),
                Specifications.responseSpecification(200));
        given()
               .contentType(ContentType.JSON)
               .when()
               .log().all()
               .get("/api/food")
               .then()
               .log().all()
               .and()
               .assertThat()
               .statusCode(200)
                .body("name[0]", equalTo("Апельсин"))
                .body("name[1]", equalTo("Капуста"))
                .body("name[2]", equalTo("Помидор"))
                .body("name[3]", equalTo("Яблоко"))
               .extract().asString();
    }

    @Step("Добавление элемента в список")
    static void postElemTest(PojoFood food) throws SQLException {
        given()
                .body(food.postBody())
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("/api/food")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

        List<String> s = ConnectDB.sqlReq();
        Assertions.assertTrue(s.contains(food.getName()), "Список не содержит " + food.getName());
    }

    @Step("Метод для очистки списка")
    static void dataReset() throws SQLException {
        given()
                .when()
                .post("/api/data/reset");
        List<String> s = ConnectDB.sqlReq();
        Assertions.assertTrue(s.size()==4, "Размер списка не равен 4");
    }

}
