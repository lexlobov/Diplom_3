
import api.UserClient;
import api.model.UserModel;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class UserSteps {

    UserClient userClient = new UserClient();

    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Step("Создание пользователя")
    public void createNewUser(UserModel user) {
        ValidatableResponse response = userClient.createUser(user);
        setAuthToken(response.extract().path("accessToken"));
    }

    @Step("Авторизация пользователя")
    public void loginUserPositive(String email, String password){
        UserModel user = new UserModel(email, password);
        ValidatableResponse response = userClient.loginUser(user);
        String accessToken = response.extract().path("accessToken");
        setAuthToken(accessToken);
    }

    @Step("Удаление пользователя")
    public void deleteUser(){
        ValidatableResponse response = userClient.deleteUser(authToken);
    }
}
