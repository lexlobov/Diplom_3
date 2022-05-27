import api.model.UserModel;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import pageObject.BasePage;

import pageObject.LoginPage;
import pageObject.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.*;

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
    public void goToPersonalAccountPageTest(){
        LoginPage loginPage = open(basePage.getMainPageUrl()+"login", LoginPage.class);
        PersonalAccountPage personalAccountPage = loginPage.authorize(email, password).openPersonalAccountPage();
        personalAccountPage.checkIfPersonalAccountPageOpen();
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    public void goToConstructorPageViaHeaderLogo(){
        LoginPage loginPage = open(basePage.getMainPageUrl()+"login", LoginPage.class);
        PersonalAccountPage personalAccountPage = loginPage.authorize(email, password).openPersonalAccountPage();
        personalAccountPage.openConstructorPageViaLogo();
        closeWebDriver();
        steps.deleteUser();
    }

    @Test
    public void goToConstructorPageViaConstructorHeaderButton(){
        LoginPage loginPage = open(basePage.getMainPageUrl()+"login", LoginPage.class);
        PersonalAccountPage personalAccountPage = loginPage.authorize(email, password).openPersonalAccountPage();
        personalAccountPage.openConstructorPageViaConstructorHeaderButton();
        closeWebDriver();
        steps.deleteUser();
    }
}
