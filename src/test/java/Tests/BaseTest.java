package Tests;



import org.apache.commons.lang3.time.StopWatch;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.codeborne.selenide.Configuration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BaseTest
{
    String baseUrl = "https://hldna.inlinegroup-c.ru/hldna/f?p=210:";
    String testLogin = "SELENIUM", testPassword = "$eleN1Um";

    StopWatch watch = new StopWatch();

    @BeforeTest
    public void beforeTest()
    {

      //  Configuration.remote = "http://localhost:4444/wd/hub";
       // Configuration.browser = "firefox";
        //Configuration.headless = false;
        //Configuration.proxyEnabled = false;
//        Configuration.browserCapabilities.setCapability("nativeEvents", false);
//        Configuration.browserCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
//        Configuration.browserCapabilities.setCapability("ignoreProtectedModeSettings", true);
//        Configuration.browserCapabilities.setCapability("disable-popup-blocking", true);
//        Configuration.browserCapabilities.setCapability("enablePersistentHover", true);
//        Configuration.browserCapabilities.setCapability("ignoreZoomSetting", true);
        watch.start();
    }

    @AfterTest
    public void afterTest()
    {
        watch.stop();
        Configuration.remote = null;
        System.out.println("Время выполнения теста " + watch.getTime(TimeUnit.SECONDS));
    }

    public void loginPages(String login, String password)
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

