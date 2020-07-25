package Tests;

import static com.codeborne.selenide.Selenide.*;
import static Tests.UtilsCSV.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tests extends BaseTest
{

    @BeforeTest
    public void beforeTest()
    {
        watch.start();
    }

    @AfterTest
    public void afterTest()
    {
        watch.stop();
        System.out.println("Время выполнения теста " + watch.getTime(TimeUnit.SECONDS));
    }

    @Test
    public void manyPagesTest() throws IOException
    {
        CSVWriter writer = writeCSV(csvWritePath2);
        open(url);
        String sessionId = getSessionId(url());
        login(testLogin, testPassword);
        String[] res;
        for (int i = 1; i < 201; i++)
        {
            String page = Integer.toString(i);
            open(url + page + ":" + sessionId);
            res = (page + "," + checkPage()).split(",");
            writer.writeNext(res, false);
        }

        for (int i = 103; i < 201; i++)
        {
            String page = Integer.toString(i);
            open(url + page + ":" + sessionId);
            res = (page + "," + checkPage()).split(",");
            writer.writeNext(res, false);
        }
        writer.close();
    }

    @Test
    public void pagesTest() throws IOException, CsvValidationException
    {
        CSVReader reader = readCSV(csvReadPath);
        CSVWriter writer = writeCSV(csvWritePath1);
        String[] csvCell;
        open(url);
        String sessionId = getSessionId(url());
        login(testLogin, testPassword);

        while ((csvCell = reader.readNext())!= null)
        {
            String[] res;
            if (!csvCell[0].equals("2886"))
            {
                open(url + csvCell[0] + ":" + sessionId);
                res = (csvCell[0] + "," + checkPage()).split(",");
            }
            else
            {
                open(url + csvCell[0] + ":" + sessionId + "::NO::P2886_TYPE:" + csvCell[1]);
                res = (csvCell[0] + " " + csvCell[1] + "," + checkPage()).split(",");
            }
            writer.writeNext(res, false);
        }
        reader.close();
        writer.close();
    }
}
