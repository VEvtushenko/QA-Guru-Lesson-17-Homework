package guru.qa.api;

import guru.qa.config.TestConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static guru.qa.api.ApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;

public class Specifications {
    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(TestConfig.config.baseTestedURI())
            .basePath("/api")
            .contentType(ContentType.JSON)
            .log().all();

    public static ResponseSpecification responseSpecGet = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .build();
}
