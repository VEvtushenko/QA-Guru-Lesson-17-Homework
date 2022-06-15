package guru.qa.tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static guru.qa.data.TestData.authCookieName;
import static guru.qa.helpers.GetAuth.getAuth;
import static guru.qa.helpers.GetAuth.getAuthCookie;

public class LoginTest extends TestBase {

    @Test
    @Description("Registration with error ")
    void loginTestApiAuth() {
        open("/favicon.ico");
        getAuth(getAuthCookie(authCookieName));
        open("/");
    }
}