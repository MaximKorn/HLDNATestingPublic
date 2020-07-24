package Tests;



import static com.codeborne.selenide.Selenide.$$x;
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
        boolean correct = $$x("//div[@role='menubar']/ul/li").size() > 0;
        boolean error1 = $x("//h1[contains(text(),'Sorry, this page')]").exists();
        boolean error2 = $x("//pre[contains(text(),'failed to parse SQL query')]").exists();
        boolean error3 = $x("//b[contains(text(),'S_BASE-003')]").exists();
        return error1 ? "Unavailable page" : error2 ? "Failed to parse SQL query" :
                error3 ? "Error on start" : correct ? "Correct page" : "Other";
    }

    public String getSessionId(String url)
    {
        String[] id = url.substring(51,67).split(":");
        return id[0];
    }
}

