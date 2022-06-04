package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends BasePage{

    @FindBy(how = How.XPATH, using = ".//form/fieldset/div[1]/div/input")
    private SelenideElement nameInputField;

    @FindBy(how = How.XPATH, using = ".//form/fieldset[2]/div[1]/div/input")
    protected SelenideElement emailInputField;

    @FindBy(how = How.XPATH, using = "//h2[text()='Регистрация']")
    private SelenideElement h2HeaderText;

    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement passwordValidationError;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement authLink;


    @Step("Регистрация нового пользователя")
    public LoginPage registerNewUser(String name, String email, String password){
        nameInputField.setValue(name);
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
        submitButton.click();
        LoginPage loginPage2 = page(LoginPage.class);
        loginPage2.checkH2HeaderVisible();
        return loginPage2;
    }

    @Step("Регистрация нового пользователя с некорректным паролем")
    public void registerNewUserWithIncorrectPassword(String name, String email, String password){
        nameInputField.setValue(name);
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
        submitButton.click();
        passwordValidationError.shouldBe(Condition.visible);
    }

    @Step("Открытие страницы авторизации")
    public LoginPage openLoginPageAuthLink(){
        authLink.click();
        return page(LoginPage.class);
    }

    @Step("Проверка, что заголовок присутствует и соответствует странице")
    public void checkH2HeaderVisible(){
        h2HeaderText.shouldBe(Condition.visible);
    }
}
