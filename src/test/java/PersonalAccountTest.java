import api.model.UserModel;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageObject.BasePage;

import pageObject.LoginPage;
import pageObject.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Переходы со страници личного кабинета")
public class PersonalAccountTest {

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
    @DisplayName("Переход из конструктора на страницу личного кабинета")
    public void goToPersonalAccountPageTest(){
        LoginPage loginPage = open(basePage.getMainPageUrl()+"login", LoginPage.class);
        PersonalAccountPage personalAccountPage = loginPage.authorize(email, password).openPersonalAccountPage();
        personalAccountPage.checkIfPersonalAccountPageOpen();
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    @DisplayName("Переход со страницы личного кабинета на конструктор по нажатию на лого")
    public void goToConstructorPageViaHeaderLogoTest(){
        LoginPage loginPage = open(basePage.getMainPageUrl()+"login", LoginPage.class);
        PersonalAccountPage personalAccountPage = loginPage.authorize(email, password).openPersonalAccountPage();
        personalAccountPage.openConstructorPageViaLogo();
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    @DisplayName("Переход со страницы личного кабинета на конструктор через кнопку в хэдере")
    public void goToConstructorPageViaConstructorHeaderButtonTest(){
        LoginPage loginPage = open(basePage.getMainPageUrl()+"login", LoginPage.class);
        PersonalAccountPage personalAccountPage = loginPage.authorize(email, password).openPersonalAccountPage();
        personalAccountPage.openConstructorPageViaConstructorHeaderButton();
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void logOutTest(){
        LoginPage loginPage = open(basePage.getMainPageUrl()+"login", LoginPage.class);
        PersonalAccountPage personalAccountPage = loginPage.authorize(email, password).openPersonalAccountPage();
        personalAccountPage.logOut();
        closeWebDriver();
        steps.deleteUser();
    }
}
