package pageObject;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class OrdersListPage extends BasePage{



    @Step("Открытие страницы авторизации")
    public LoginPage openLoginPage(){
        personalAccountHeaderButton.click();
        LoginPage loginPage = page(LoginPage.class);
        return loginPage;
    }
}
