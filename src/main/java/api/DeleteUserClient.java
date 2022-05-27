package api;

import api.BaseHttpConfig;
import io.restassured.response.ValidatableResponse;
import api.model.UserModel;

import static io.restassured.RestAssured.given;

public class DeleteUserClient extends BaseHttpConfig {

    private final String deleteUserUri = "/api/auth/user";

    public ValidatableResponse deleteUser(String authToken) {
        return given().spec(baseSpec())
                .header("authorization", authToken)
                .when()
                .delete(deleteUserUri)
                .then();
    }
}