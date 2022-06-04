import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page_object.BasePage;
import page_object.ConstructorPage;
import page_object.LoginPage;
import page_object.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;



@DisplayName("Различные сценарии регистрации")
public class RegistrationTest {

    BasePage basePage = new BasePage();
    UserSteps steps = new UserSteps();

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = name + "@" + faker.name().lastName() + ".ru";
    String password = faker.lorem().characters(10, true);

    @Test
    @DisplayName("Регистрация нового пользователя, позитивный сценарий")
    public void registerNewUserPositiveTest(){
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginPageHeaderButton();
        RegistrationPage registrationPage = loginPage.openRegistrationPage();
        registrationPage.registerNewUser(name, email, password);
        steps.loginUserPositive(email,password);
        steps.deleteUser();
        closeWebDriver();
    }

    @Test
    @DisplayName("Регистрация нового пользователя, негативный сценарий с некорректным паролем менее 6 символов")
    public void registerNewUserIncorrectPasswordNegativeTest(){
        String shortPassword = faker.lorem().characters(5, true);
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginPageHeaderButton();
        RegistrationPage registrationPage = loginPage.openRegistrationPage();
        registrationPage.registerNewUserWithIncorrectPassword(name, email, shortPassword);
        closeWebDriver();
    }
}
