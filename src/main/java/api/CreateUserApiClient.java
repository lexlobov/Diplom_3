package api;

import api.BaseHttpConfig;
import api.model.UserModel;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;

public class CreateUserApiClient extends BaseHttpConfig {

    private final String createUserUri = "/api/auth/register";

    public ValidatableResponse createUser(UserModel user){
        return given().spec(baseSpec())
                .body(user)
                .when()
                .post(createUserUri)
                .then();
    }
}