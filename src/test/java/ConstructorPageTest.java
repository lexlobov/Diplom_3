import org.junit.Test;
import pageObject.BasePage;
import pageObject.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorPageTest {


    BasePage basePage = new BasePage();
    ConstructorPage constructorPage = open(basePage.getMainPageUrl(), ConstructorPage.class);


    @Test
    public void selectIngredientsTest(){
        constructorPage.selectSauces();
        constructorPage.selectFillings();
        constructorPage.selectBuns();
    }
}
