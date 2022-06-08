import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase  {
    @BeforeAll
    static void setupAPITest() {
        RestAssured.baseURI = "https://reqres.in";
    }
}
