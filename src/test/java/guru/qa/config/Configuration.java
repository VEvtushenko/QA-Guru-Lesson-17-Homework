package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"system:properties", "classpath:config/local.properties"})
public interface Configuration extends Config {
    String login();
    String password();
    String remoteHub();
    String baseTestedURI();
    String baseTestedURL();
    String videoURL();
}
