package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage
{
    //private SelenideElement username = $x("//input[@placeholder='Имя пользователя']");
    //private SelenideElement password = $x("//input[@placeholder='Пароль']");
    //private SelenideElement loginButton = $x("//span[normalize-space(text())='Вход']");

    public LoginPage enterUsername(String login)
    {
        $x("//input[@placeholder='Имя пользователя']").setValue(login);
        return this;
    }

    public LoginPage enterPassword(String pass)
    {
        $x("//input[@placeholder='Пароль']").setValue(pass);
        return this;
    }

    public BasePage pressSubmitButton()
    {
        $x("//span[text()='Вход']").click();
        return page(BasePage.class);
    }

//     public RequestsListPage pressSubmitButton()
//    {
//        $x("//span[text()='Вход']").click();
//        return page(RequestsListPage.class);
//    }
}
