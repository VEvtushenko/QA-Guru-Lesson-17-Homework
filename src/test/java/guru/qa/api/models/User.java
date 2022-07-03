package guru.qa.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.File;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
        private Long id;
        private String email;
        private String first_name;
        private String last_name;
        private File avatar;
        private String job;
        private String type;
        private String Buddhist_name;
        private String password;
}
