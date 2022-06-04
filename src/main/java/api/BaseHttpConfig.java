package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseHttpConfig {
    protected RequestSpecification baseSpec() {
        return new RequestSpecBuilder().setContentType(JSON).setBaseUri(baseUrl).build();
    }

    private final String JSON = "application/json";
    protected final String baseUrl = "https://stellarburgers.nomoreparties.site";
}
