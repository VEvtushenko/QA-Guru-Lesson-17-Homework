package guru.qa.helpers;

import com.codeborne.selenide.Configuration;
import guru.qa.config.TestConfig;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {
    public static void driverConfig() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.baseUrl = TestConfig.config.baseTestedURL();
        RestAssured.baseURI = TestConfig.config.baseTestedURI();
        if (!TestConfig.config.remoteHub().equals("")) {
            Configuration.remote = TestConfig.config.remoteHub();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
