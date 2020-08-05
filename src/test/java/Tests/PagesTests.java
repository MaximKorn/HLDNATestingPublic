package Tests;

import static com.codeborne.selenide.Selenide.*;
import static Utils.UtilsCSV.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;


public class PagesTests extends BaseTest
{
    @Description("Проверка страниц 1-200 на ошибки")
    @Test(enabled = false)
    public void manyPagesTest() throws IOException
    {
        CSVWriter writer = writeCSV(csvWritePages2);
        open(baseUrl);
        String sessionId = getSessionId(url());
        loginPages(testLogin, testPassword);
        String[] res;
        for (int i = 1; i < 101; i++)
        {
            String page = Integer.toString(i);
            open(baseUrl + page + ":" + sessionId);
            res = (page + "," + checkPage()).split(",");
            writer.writeNext(res, false);
        }

        for (int i = 103; i < 201; i++)
        {
            String page = Integer.toString(i);
            open(baseUrl + page + ":" + sessionId);
            res = (page + "," + checkPage()).split(",");
            writer.writeNext(res, false);
        }
        writer.close();
    }

    @Description("Проверка необходимых страниц на ошибки")
    @Test(enabled = false)
    public void pagesTest() throws IOException, CsvValidationException
    {
        CSVReader reader = readCSV(csvReadPages);
        CSVWriter writer = writeCSV(csvWritePages1);
        String[] csvCell;
        open(baseUrl);
        String sessionId = getSessionId(url());
        loginPages(testLogin, testPassword);

        while ((csvCell = reader.readNext())!= null)
        {
            String[] res;
            if (!csvCell[0].equals("2886"))
            {
                open(baseUrl + csvCell[0] + ":" + sessionId);
                res = (csvCell[0] + "," + checkPage()).split(",");
            }
            else
            {
                open(baseUrl + csvCell[0] + ":" + sessionId + "::NO::P2886_TYPE:" + csvCell[1]);
                res = (csvCell[0] + " " + csvCell[1] + "," + checkPage()).split(",");
            }
            writer.writeNext(res, false);
        }
        reader.close();
        writer.close();
    }
}
