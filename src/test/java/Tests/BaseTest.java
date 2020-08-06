package Tests;

import Utils.CustomTestListener;
import org.testng.annotations.Listeners;


@Listeners({CustomTestListener.class})
public class BaseTest
{
    String baseUrl = "https://hldna.inlinegroup-c.ru/hldna/f?p=210:";

   // StopWatch watch = new StopWatch();

//    @BeforeTest
//    public void beforeTest()
//    {
//
//      //  Configuration.remote = "http://localhost:4444/wd/hub";
//       // Configuration.browser = "firefox";
//        //Configuration.headless = false;
//        //Configuration.proxyEnabled = false;
//        watch.start();
//    }
//
//    @AfterTest
//    public void afterTest()
//    {
//        watch.stop();
//        //Configuration.remote = null;
//        System.out.println("Время выполнения теста " + watch.getTime(TimeUnit.SECONDS));
//    }



}

