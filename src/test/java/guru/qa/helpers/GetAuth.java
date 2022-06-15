package guru.qa.helpers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static guru.qa.data.TestData.*;
import static io.restassured.RestAssured.given;

public class GetAuth {

    public static Cookie getAuthCookie(String authCookieName) {
        String authCookieValue = given()
//                .log().all()
                .when()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", login)
                .formParam("Password", password)
                .formParam("RememberMe", "true")
                .post(
                        "/login")
                .then()
//                .log().all()
                .statusCode(302)
                .extract().cookie(authCookieName);
        Cookie authCookie = new org.openqa.selenium.Cookie(authCookieName, authCookieValue);
        return authCookie;
    }

    public static void getAuth(Cookie authCookie) {
        WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
    }
}
