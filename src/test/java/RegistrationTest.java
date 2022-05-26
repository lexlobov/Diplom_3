import com.github.javafaker.Faker;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    BasePage basePage = new BasePage();

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = name + "@" + faker.name().lastName() + ".ru";
    String password = faker.lorem().characters(10, true);

    @Test
    public void registerNewUserPositiveTest(){
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginPage();
        RegistrationPage registrationPage = loginPage.openRegistrationPage();
        registrationPage.registerNewUser(name, email, password);
    }

    @Test
    public void registerNewUserIncorrectPasswordNegativeTest(){
        String shortPassword = faker.lorem().characters(5, true);
        ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);
        LoginPage loginPage = constructorPage.openLoginPage();
        RegistrationPage registrationPage = loginPage.openRegistrationPage();
        registrationPage.registerNewUserWithIncorrectPassword(name, email, shortPassword);
    }
}
