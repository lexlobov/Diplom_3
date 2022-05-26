import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends BasePage{

    @FindBy(how = How.XPATH, using = ".//form/fieldset/div[1]/div/input")
    private SelenideElement nameInputField;

    @FindBy(how = How.XPATH, using = ".//form/fieldset[2]/div[1]/div/input")
    private SelenideElement emailInputField;

    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement passwordInputField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement submitButton;

    @FindBy(how = How.XPATH, using = "//h2[text()='Регистрация']")
    private SelenideElement h2HeaderText;


    public LoginPage registerNewUser(String name, String email, String password){
        nameInputField.setValue(name);
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
        submitButton.click();
        LoginPage loginPage2 = page(LoginPage.class);
        loginPage2.checkH2HeaderVisible();
        return loginPage2;
    }

    public void checkH2HeaderVisible(){
        h2HeaderText.shouldBe(Condition.visible);
    }
}
