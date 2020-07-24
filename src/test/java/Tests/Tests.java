package Tests;

import static com.codeborne.selenide.Selenide.*;
import static Tests.UtilsCSV.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.codeborne.selenide.Configuration;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;

import org.apache.commons.lang3.time.StopWatch;
import java.io.IOException;

public class Tests extends BaseTest
{
//    @Test
//    public void testTest()
//    {
//        open(url+"2880");
//        login(testLogin, testPassword);
//         int ch = $$x("//div[@role='menubar']/ul/li").size();
//        //menu.exists();
//      //int check = menu.$$(By.tagName("li")).size();
//        System.out.println(ch);
//    }

    @Test
    public void pagesTest() throws IOException, CsvValidationException {

        CSVReader reader = readCSV();
        CSVWriter writer = writeCSV();
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
