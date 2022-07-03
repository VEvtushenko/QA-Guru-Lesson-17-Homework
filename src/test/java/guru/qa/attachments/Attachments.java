package guru.qa.attachments;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static guru.qa.helpers.DriverUtils.getSessionId;
import static guru.qa.helpers.DriverUtils.getVideoUrl;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attachments {
    @Attachment(value = "Browser logs", type = "text/plain")
    public static void addBrowserLogs() {
        String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] addScreenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html")
    public static byte[] addPageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl(getSessionId())
                + "' type='video/mp4'></video></body></html>";
    }
}
