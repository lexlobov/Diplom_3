package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class BasePage {

    private final String mainPageUrl = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = "//p[text() = 'Конструктор']")
    protected SelenideElement constructorHeaderButton;

    @FindBy(how = How.XPATH, using = "//p[text() = 'Лента заказов']")
    protected  SelenideElement orderListHeaderButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    protected SelenideElement headerLogo;

    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    protected  SelenideElement personalAccountHeaderButton;

    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    protected SelenideElement passwordInputField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    protected SelenideElement submitButton;

    public String getMainPageUrl() {
        return mainPageUrl;
    }
}
