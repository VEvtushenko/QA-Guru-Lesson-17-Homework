package guru.qa.helpers;

import guru.qa.config.TestConfig;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class DriverUtils {
    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public static URL getVideoUrl(String sessionId) {
        if (!TestConfig.config.videoURL().equals("")) {
            String videoUrl = TestConfig.config.videoURL() + sessionId + ".mp4";
            try {
                return new URL(videoUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
