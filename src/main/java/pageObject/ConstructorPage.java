package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement makeAnOrderButton;

    public LoginPage openLoginPageHeaderButton(){
        personalAccountHeaderButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkH2HeaderVisible();
        return loginPage;
    }

    public LoginPage openLoginAuthorizeButtonButton(){
        submitButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkH2HeaderVisible();
        return loginPage;
    }

    public void checkSubmitButtonText(){
        makeAnOrderButton.shouldBe(Condition.visible);
    }
}
