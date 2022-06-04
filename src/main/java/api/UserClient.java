package api;

import api.model.UserModel;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseHttpConfig {

    private final String deleteUserUri = "/api/auth/user";
    private final String loginUri = "/api/auth/login";
    private final String createUserUri = "/api/auth/register";

    public ValidatableResponse deleteUser(String authToken) {
        return given().spec(baseSpec())
                .header("authorization", authToken)
                .when()
                .delete(deleteUserUri)
                .then();
    }

    public ValidatableResponse loginUser(UserModel user){
        return given().spec(baseSpec())
                .body(user)
                .when()
                .post(loginUri)
                .then();
    }

    public ValidatableResponse createUser(UserModel user){
        return given().spec(baseSpec())
                .body(user)
                .when()
                .post(createUserUri)
                .then();
    }
}