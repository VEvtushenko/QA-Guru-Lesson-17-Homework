package guru.qa.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.attachments.Attachments;
import guru.qa.config.TestConfig;
import guru.qa.helpers.DriverSettings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;

public class TestBase  {
    @BeforeAll
    static void setupAPITest() {
        DriverSettings.driverConfig();
    }

    @BeforeEach
    void allureListeners() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
    }

    @BeforeEach
    void addAttachments() {
        Attachments.addPageSource();
        Attachments.addScreenshotAs("Final screenshot");
        Attachments.addBrowserLogs();
        if (!TestConfig.config.videoURL().equals("")) {
            Attachments.addVideo();
        }
        Selenide.closeWebDriver();
    }

}
