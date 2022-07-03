package guru.qa.config;

import org.aeonbits.owner.ConfigFactory;

public class TestConfig {
    public static Configuration config = ConfigFactory.create(Configuration.class, System.getProperties());
}
