import api.model.UserModel;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page_object.BasePage;
import page_object.ConstructorPage;
import page_object.LoginPage;


import static com.codeborne.selenide.Selenide.*;

@DisplayName("Различные сценарии авторизации")
public class AuthorizationTest {

    BasePage basePage = new BasePage();
    UserSteps steps = new UserSteps();
    Faker faker = new Faker();

    String name = faker.name().firstName();
    String email = name + "@" + faker.name().lastName() + ".ru";
    String password = faker.lorem().characters(10, true);

    @Before
    public void setUp() {
        UserModel user = new UserModel(email, password, name);
        steps.createNewUser(user);
    }

    @After
    public void tearDown(){
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    @DisplayName("Авторизация, позитивный сценарий")
    public void userAuthorizationPositiveTest() {
        LoginPage loginPage = open(basePage.getMainPageUrl() + "login", LoginPage.class);
        ConstructorPage constructorPage = loginPage.authorize(email, password);
        constructorPage.checkSubmitButtonText();
    }

    @Test
    @DisplayName("Авторизация, позитивный сценарий через кнопку в хэдере")
    public void userAuthorizationPersonalAccountPositiveTest() {
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginPageHeaderButton();
        loginPage.authorize(email, password);
    }

    @Test
    @DisplayName("Авторизация, позитивный сценарий через кнопку авторизации в конструкторе")
    public void userAuthorizationAuthorizeButtonPositiveTest() {
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginAuthorizeButtonButton();
        loginPage.authorize(email, password);
    }

    @Test
    @DisplayName("Авторизация, позитивный сценарий через ссылку на странице регистрации")
    public void userAuthorizationAUthLinkOnRegistrationPagePositiveTest() {
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginAuthorizeButtonButton();
        loginPage.openRegistrationPage().openLoginPageAuthLink();
        loginPage.authorize(email, password);
    }

    @Test
    @DisplayName("Авторизация позитивный сценарий через ссылку на экране восстановления пароля")
    public void userAuthorizationAuthLinkOnForgotPasswordPagePositiveTest() {
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginAuthorizeButtonButton();
        loginPage.openForgotPasswordPage().openLoginPage();
        loginPage.authorize(email, password);
    }
}