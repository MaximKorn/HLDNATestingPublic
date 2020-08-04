package Steps;

import Models.User;
import Pages.BasePage;
import Pages.LoginPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class LoginStep {
    private LoginPage loginPage;

    public LoginStep() {
        loginPage = page(LoginPage.class);
    }

    @Step("Войти как пользователь {user.username} с паролем {user.password}")
    public BasePage login(User user) {
        return loginPage
                .enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .pressSubmitButton();
    }
}
