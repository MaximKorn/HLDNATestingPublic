package Steps;

import Pages.BasePage;
import Pages.LoginPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginStep {
    private LoginPage loginPage;

    public LoginStep(LoginPage loginPage1) {
        loginPage = loginPage1;
    }

    public BasePage login(String username, String password) {
        return loginPage
                .enterUsername(username)
                .enterPassword(password)
                .pressSubmitButton();
    }
}
