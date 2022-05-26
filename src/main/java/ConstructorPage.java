import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.Factory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.nio.channels.SelectableChannel;

import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ConstructorPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement makeAnOrderButton;

    public LoginPage openLoginPage(){
        personalAccountHeaderButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkH2HeaderVisible();
        return loginPage;
    }

    public void checkSubmitButtonText(){
        makeAnOrderButton.shouldBe(Condition.visible);
    }
}
