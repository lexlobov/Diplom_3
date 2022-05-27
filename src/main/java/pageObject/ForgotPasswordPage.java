package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage extends BasePage{

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement loginLink;

    @FindBy(how = How.XPATH, using = "//h2[text()='Восстановление пароля']")
    private SelenideElement h2HeaderText;

    public LoginPage openLoginPage(){
        loginLink.click();
        return page(LoginPage.class);
    }

    public void checkH2HeaderTextVisible(){
        h2HeaderText.shouldBe(Condition.visible);
    }
}
