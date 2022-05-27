package api;

import api.model.UserModel;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class LoginUserClient extends BaseHttpConfig{
    private final String loginUri = "/api/auth/login";

    public ValidatableResponse loginUser(UserModel user){
        return given().spec(baseSpec())
                .body(user)
                .when()
                .post(loginUri)
                .then();
    }
}
