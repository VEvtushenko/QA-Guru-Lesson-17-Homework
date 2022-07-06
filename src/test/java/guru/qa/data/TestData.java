package guru.qa.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.api.models.User;

import java.io.File;
import java.io.IOException;

public class TestData {

    public static ObjectMapper jacksonMapper = new ObjectMapper();

    public static User jannetWeaver, czhuBajie;

    static {
        try {
            jannetWeaver = jacksonMapper.readValue(new File("src/test/resources/request_data/janet_weaver.json"), User.class);
            czhuBajie = jacksonMapper.readValue(new File("src/test/resources/request_data/czhu_bajie.json"), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String updateUserJson = "{\n" +
            "    \"name\": \"Chzu Bajie\",\n" +
            "    \"job\": \"Heavenly Tumbleweed\",\n" +
            "    \"type\": \"Human-pig\",\n" +
            "    \"Buddhist_name\": \"Zhu Wuneng\"" +
            "}";

    public static String createUserJson = "{\\n\" +\n" +
            "                        \"    \\\"name\\\": \\\"Chzu Bajie\\\",\\n\" +\n" +
            "                        \"    \\\"job\\\": \\\"looser\\\",\\n\" +\n" +
            "                        \"    \\\"type\\\": \\\"Human-pig\\\"\" +\n" +
            "                        \"}";

    public static String registerUserJson = "{\n" +
            "    \"email\": \"czhu.bajie@reqres.in\",\n" +
            "    \"password\": \"pistol\"\n" +
            "}";

    public static String userJanetWeaver = "";

    public TestData() throws IOException {
    }
}
