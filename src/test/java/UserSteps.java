import api.CreateUserApiClient;
import api.model.DeleteUserClient;
import api.model.UserModel;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;


public class UserSteps {

    CreateUserApiClient createUserApiClient = new CreateUserApiClient();
    DeleteUserClient deleteUserClient = new DeleteUserClient();

    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Step("Создание пользователя")
    public void createNewUser(UserModel user) {
        ValidatableResponse response = createUserApiClient.createUser(user);
        setAuthToken(response.extract().path("accessToken"));
    }

    @Step("Удаление пользователя")
    public void deleteUser(){
        ValidatableResponse response = deleteUserClient.deleteUser(authToken);
    }
}
