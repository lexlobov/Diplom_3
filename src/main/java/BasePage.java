
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class BasePage {

    @FindBy(how = How.XPATH, using = "//p[text() = 'Конструктор']")
    protected SelenideElement constructorHeaderButton;

    @FindBy(how = How.XPATH, using = "//p[text() = 'Лента заказов']")
    protected  SelenideElement orderListHeaderButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    protected SelenideElement headerLogo;

    @FindBy(how = How.XPATH, using = "//p[text() = 'Личный кабинет']")
    protected  SelenideElement personalAccountHeaderButton;
}
