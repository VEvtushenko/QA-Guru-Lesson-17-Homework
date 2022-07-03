package guru.qa.tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static guru.qa.data.TestData.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

@Owner("Vladimir Evtushenko")
@Feature("DemoQA")
@Link(value = "QA Guru, Lesson 18, Lombok&Groovy Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-17-Homework")
public class APITest extends TestBase {
    @Test
    @Description("Test get user information about Janet Weaver")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test get user")
    void singleUserTest() {
        when()
                .get("api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", is(2),
                        "data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name", equalTo("Janet"),
                        "data.last_name", equalTo("Weaver"),
                        "data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"),
                        "support.url", equalTo("https://reqres.in/#support-heading"),
                        "support.text", hasToString("To keep ReqRes free, contributions towards server costs are appreciated!")
                );
    }

    @Test
    @Description("Create user")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test get user")
    void createUserTest() {
        given().log().uri()
                .log().body()
                .when()
                .contentType(JSON)
                .body(createUserJson)
                .post("/api/users")
                .then().log().all()
                .statusCode(201)
                .body("name", equalTo("Chzu Bajie"),
                        "type", equalTo("Human-pig")
                );
    }


    @Test
    @Description("Update user")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test get user")
    void updateUserTest() {
        given().log().all()
                .contentType(JSON)
                .body(updateUserJson)
                .when()
                .put("api/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("Chzu Bajie"),
                        "Buddhist_name", equalTo("Zhu Wuneng")
                );
    }


    @Test
    @Description("List of users test")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test get user")
    void listUserTest() {
        given().log().uri()
                .log().body()
                .when()
                .contentType(JSON)
                .get("/api/users?page=2")
                .then()
                .log().all()
                .body("data.id", hasItems(7, 8, 9, 10, 12));
    }

    @Test
    @Description("Registration with error ")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test get user")
    void registrationWithErrorTest() {
        given().log().all()
                .when()
                .contentType(JSON)
                .body(registerUserJson)
                .post("/api/register")
                .then()
                .log().all()
                .statusCode(400)
                .body("error", equalTo("Note: Only defined users succeed registration"));
    }
}