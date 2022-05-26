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

    public RegistrationPage openRegistrationPage(){
        registrationLink.click();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.checkH2HeaderVisible();
        return registrationPage;
    }

    public void checkH2HeaderVisible(){
        h2HeaderText.shouldBe(Condition.visible);
    }
}
