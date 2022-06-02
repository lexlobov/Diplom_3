import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.BasePage;
import pageObject.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Переходы на разные начинки на странице конструктора")
public class ConstructorPageTest {


    BasePage basePage = new BasePage();
    ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);


    @Test
    @DisplayName("Переходы на разные начинки")
    public void selectIngredientsTest(){
        constructorPage.selectSauces();
        constructorPage.selectFillings();
        constructorPage.selectBuns();
    }
}
