import static com.codeborne.selenide.Selenide.page;

public class ConstructorPage extends BasePage{


    public LoginPage openLoginPage(){
        personalAccountHeaderButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkH2HeaderVisible();
        return loginPage;
    }
}
