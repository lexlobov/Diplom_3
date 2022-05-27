package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PersonalAccountPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    private SelenideElement profileTab;

    @FindBy(how = How.XPATH, using = "//a[text()='История заказов']")
    private SelenideElement ordersHistoryTab;

    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement logOutButton;

    public void checkIfPersonalAccountPageOpen(){
        profileTab.shouldBe(Condition.visible);
        ordersHistoryTab.shouldBe(Condition.visible);
        logOutButton.shouldBe(Condition.visible);
    }

    public ConstructorPage openConstructorPageViaLogo(){
        headerLogo.click();
        ConstructorPage constructorPage = page(ConstructorPage.class);
        constructorPage.checkSubmitButtonText();
        return constructorPage;
    }
    public ConstructorPage openConstructorPageViaConstructorHeaderButton(){
        constructorHeaderButton.click();
        ConstructorPage constructorPage = page(ConstructorPage.class);
        constructorPage.checkSubmitButtonText();
        return constructorPage;
    }

    public LoginPage logOut(){
        logOutButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkH2HeaderVisible();
        return loginPage;
    }
}
