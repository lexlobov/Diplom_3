import api.model.UserModel;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pageObject.BasePage;
import pageObject.ConstructorPage;
import pageObject.LoginPage;


import static com.codeborne.selenide.Selenide.*;

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

    @Test
    public void userAuthorizationPositiveTest() {
        LoginPage loginPage = open(basePage.getMainPageUrl() + "login", LoginPage.class);
        ConstructorPage constructorPage = loginPage.authorize(email, password);
        constructorPage.checkSubmitButtonText();
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    public void userAuthorizationPersonalAccountPositiveTest() {
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginPageHeaderButton();
        loginPage.authorize(email, password);
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    public void userAuthorizationAuthorizeButtonPositiveTest() {
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginAuthorizeButtonButton();
        loginPage.authorize(email, password);
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    public void userAuthorizationAUthLinkOnRegistrationPagePositiveTest() {
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginAuthorizeButtonButton();
        loginPage.openRegistrationPage().openLoginPageAuthLink();
        loginPage.authorize(email, password);
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    public void userAuthorizationAuthLinkOnForgotPasswordPagePositiveTest() {
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginAuthorizeButtonButton();
        sleep(2000);
        loginPage.openForgotPasswordPage().openLoginPage();
        loginPage.authorize(email, password);
        closeWebDriver();
        steps.deleteUser();
    }
}