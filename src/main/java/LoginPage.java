import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//a[text() = 'Зарегистрироваться']")
    private SelenideElement registrationLink;

    public RegistrationPage openRegistrationPage(){
        registrationLink.click();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        return registrationPage;
    }
}
