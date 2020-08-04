package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage
{
    //private SelenideElement username = $x("//input[@placeholder='Имя пользователя']");
    //private SelenideElement password = $x("//input[@placeholder='Пароль']");
    //private SelenideElement loginButton = $x("//span[normalize-space(text())='Вход']");
    @Step("Ввести логин {login}")
    public LoginPage enterUsername(String login)
    {
        $x("//input[@placeholder='Имя пользователя']").setValue(login);
        return page(LoginPage.class);
    }

    @Step("Ввести пароль {pass}")
    public LoginPage enterPassword(String pass)
    {
        $x("//input[@placeholder='Пароль']").setValue(pass);
        return page(LoginPage.class);
    }

    @Step("Нажать кнопку \"Войти\"")
    public BasePage pressSubmitButton()
    {
        $x("//span[text()='Вход']").click();
        return page(BasePage.class);
    }

}
