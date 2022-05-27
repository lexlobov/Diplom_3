package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//a[text() = 'Зарегистрироваться']")
    private SelenideElement registrationLink;
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement h2HeaderText;

    @FindBy(how = How.XPATH, using = ".//form/fieldset/div[1]/div/input")
    protected SelenideElement emailInputField;

    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement forgotPasswordLink;


    public RegistrationPage openRegistrationPage(){
        registrationLink.click();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.checkH2HeaderVisible();
        return registrationPage;
    }

    public void checkH2HeaderVisible(){
        h2HeaderText.shouldBe(Condition.visible);
    }

    public ConstructorPage authorize(String email, String password){
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
        submitButton.click();
        ConstructorPage constructorPage = page(ConstructorPage.class);
        return constructorPage;
    }

    public ForgotPasswordPage openForgotPasswordPage(){
        forgotPasswordLink.click();
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.checkH2HeaderTextVisible();
        return forgotPasswordPage;
    }
}
