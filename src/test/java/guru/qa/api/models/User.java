package guru.qa.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Calendar;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
        private Long id;
        private String email;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        private File avatar;
        private String job;
        private String type;
        @JsonProperty("Buddhist_name")
        private String buddhistName;
        private String password;
        private Calendar createdAt;
}
