package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ConstructorPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement makeAnOrderButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement saucesTab;

    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement fillingTab;

    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement bunsTab;

    @FindBy(how = How.XPATH,using = "//h2[text()='Булки']")
    private SelenideElement bunsHeader;

    @FindBy(how = How.XPATH,using = "//h2[text()='Соусы']")
    private SelenideElement saucesHeader;

    @FindBy(how = How.XPATH,using = "//h2[text()='Начинки']")
    private SelenideElement fillingHeader;

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

    public PersonalAccountPage openPersonalAccountPage(){
        personalAccountHeaderButton.click();
        return page(PersonalAccountPage.class);
    }

    public void scrollSaucesIntoView(){
        fillingHeader.is(Condition.visible);
    }

//    public void scrollFillingIntoView(){
//        fillingTab.click();
//        saucesHeader.
//    }
}
