package pageObject;

import static com.codeborne.selenide.Selenide.page;

public class OrdersListPage extends BasePage{



    public LoginPage openLoginPage(){
        personalAccountHeaderButton.click();
        LoginPage loginPage = page(LoginPage.class);
        return loginPage;
    }
}
