package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ConstructorPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement makeAnOrderButton;

    @FindBy(how = How.CSS, using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(2n)")
    private SelenideElement saucesTab;

    @FindBy(how = How.CSS, using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(3n)")
    private SelenideElement fillingTab;

    @FindBy(how = How.CSS, using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(1n)")
    private SelenideElement bunsTab;

    @FindBy(how = How.XPATH,using = "//h2[text()='Булки']")
    private SelenideElement bunsHeader;

    @FindBy(how = How.XPATH,using = "//h2[text()='Соусы']")
    private SelenideElement saucesHeader;

    @FindBy(how = How.XPATH,using = "//h2[text()='Начинки']")
    private SelenideElement fillingHeader;

    @Step("Открытие страницы авторизации через кнопку в хэдере")
    public LoginPage openLoginPageHeaderButton(){
        personalAccountHeaderButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkH2HeaderVisible();
        return loginPage;
    }

    @Step("Открытие страницы авторизации через кнопку авторизации")
    public LoginPage openLoginAuthorizeButtonButton(){
        submitButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkH2HeaderVisible();
        return loginPage;
    }

    @Step("проверка, что кнопка Подтвредить видна")
    public void checkSubmitButtonText(){
        makeAnOrderButton.shouldBe(Condition.visible);
    }

    @Step("Открытие страницы личного кабинета")
    public PersonalAccountPage openPersonalAccountPage(){
        personalAccountHeaderButton.click();
        return page(PersonalAccountPage.class);
    }

    @Step("Выбор вкладки Соусы")
    public void selectSauces(){
        saucesTab.click();
        saucesTab.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Выбор вкладки Начинки")
    public void selectFillings(){
        fillingTab.click();
        fillingTab.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Выбор вкладки Булочки")
    public void selectBuns(){
        bunsTab.click();
        bunsTab.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }
}
