package Tests;

import static com.codeborne.selenide.Selenide.$x;

public class BaseTest
{
    String url = "https://hldna.inlinegroup-c.ru/hldna/f?p=210:";
    String testLogin = "SELENIUM", testPassword = "$eleN1Um";

    public void login(String login, String password)
    {
        $x("//input[@placeholder='Имя пользователя']").setValue(login);
        $x("//input[@placeholder='Пароль']").setValue(password);
        $x("//span[normalize-space(text())='Вход']").click();
    }

    public String checkPage()
    {
        boolean correct = $x("//div[@class='a-IRR']").exists();
        boolean error1 = $x("//h1[contains(text(),'Sorry, this page')]").exists();
        boolean error2 = $x("//pre[contains(text(),'failed to parse SQL query')]").exists();
        boolean error3 = $x("//b[contains(text(),'S_BASE-003')]").exists();
        return correct ? "0" : error1 ? "1" : error2 ? "2" : error3 ? "3" : "-1";
    }

}

