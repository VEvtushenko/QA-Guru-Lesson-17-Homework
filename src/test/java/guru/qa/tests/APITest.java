package guru.qa.tests;

import guru.qa.api.models.User;
import guru.qa.api.models.UserData;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

import static guru.qa.api.Specifications.requestSpec;
import static guru.qa.api.Specifications.responseSpecGet;
import static guru.qa.data.TestData.*;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Vladimir Evtushenko")
@Feature("DemoQA")
@Link(value = "QA Guru, Lesson 18, Lombok&Groovy Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-17-Homework")
public class APITest extends TestBase {

    @Test
    @Description("Test get user information about Janet Weaver")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test get the user")
    void singleUserTest() {
        UserData userData =
                given()
                    .spec(requestSpec)
                .when()
                    .get("/users/2")
                .then()
                    .spec(responseSpecGet)
                    .extract().as(UserData.class);

        assertEquals(userData.getUser(), jannetWeaver);
    }

    @Test
    @Description("Create user")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test create")
    void createUserTest() throws java.io.IOException {
        User newUser =
                given()
                    .spec(requestSpec)
                .when()
                    .body(czhuBajie)
                    .post("/users")
                .then()
                    .statusCode(201)
                    .extract().as(User.class);

//        User assertUser = jacksonMapper.readValue(new File("src/test/resources/request_data/czhu_bajie.json"), User.class);
//        assertUser.setId(newUser.getId());
//        assertEquals(newUser, assertUser);
        System.out.println(newUser.getCreatedAt());
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