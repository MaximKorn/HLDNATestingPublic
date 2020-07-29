package Steps;

import Pages.BasePage;
import Pages.LoginPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginStep {
    LoginPage loginPage;

    public LoginStep() {
        loginPage = page(LoginPage.class);
    }

    public BasePage login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        return loginPage.pressSubmitButton();
    }
}
