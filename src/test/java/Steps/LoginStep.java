package Steps;

import Pages.BasePage;
import Pages.LoginPage;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.impl.SelenidePageFactory;

import static com.codeborne.selenide.Selenide.page;

public class LoginStep {
    LoginPage loginPage;

    public LoginStep() {
        loginPage = page(LoginPage.class);
    }

    public BasePage login(String username, String password) {
        return loginPage
                .enterUsername(username)
                .enterPassword(password)
                .pressSubmitButton();
    }
}
