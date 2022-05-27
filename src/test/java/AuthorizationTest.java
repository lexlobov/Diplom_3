import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Credentials;
import com.github.javafaker.Faker;
import org.junit.Test;
import pageObject.BasePage;
import pageObject.ConstructorPage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AuthorizationTest {

    BasePage basePage = new BasePage();
    Faker faker = new Faker();

    String name = faker.name().firstName();
    String email = name + "@" + faker.name().lastName() + ".ru";
    String password = faker.lorem().characters(10, true);

    @Test
    public void userAuthorizationPositiveTest(){
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginPage();
        RegistrationPage registrationPage = loginPage.openRegistrationPage();
        registrationPage.registerNewUser(name, email, password);
        loginPage.authorize(email, password);
        constructorPage.checkSubmitButtonText();
    }

    @Test
    public void dkfdfkdf(){
        ConstructorPage constructorPage =  new ConstructorPage();
        open(basePage.getMainPageUrl(), AuthenticationType.BASIC, new Credentials(email, password));
        constructorPage.checkSubmitButtonText();
        sleep(4000);
    }
}
