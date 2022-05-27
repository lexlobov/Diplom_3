import api.CreateUserApiClient;
import api.DeleteUserClient;
import api.LoginUserClient;
import api.model.UserModel;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class UserSteps {

    CreateUserApiClient createUserApiClient = new CreateUserApiClient();
    DeleteUserClient deleteUserClient = new DeleteUserClient();
    LoginUserClient loginUserClient = new LoginUserClient();

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

    @Step("Авторизация пользователя")
    public void loginUserPositive(String email, String password){
        UserModel user = new UserModel(email, password);
        ValidatableResponse response = loginUserClient.loginUser(user);
        String accessToken = response.extract().path("accessToken");
        setAuthToken(accessToken);
    }

    @Step("Удаление пользователя")
    public void deleteUser(){
        ValidatableResponse response = deleteUserClient.deleteUser(authToken);
    }
}
