package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")
public interface Configuration extends Config {
    String baseTestedURI();
    String baseTestedURL();
}
