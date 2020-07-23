package Tests;

import static com.codeborne.selenide.Selenide.*;
import static Tests.UtilsCSV.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;
import java.io.IOException;

public class Tests extends BaseTest
{

    @Test
    public void pagesTest() throws IOException, CsvValidationException {
        CSVReader reader = readCSV();
        CSVWriter writer = writeCSV();
        String[] csvCell;

        while ((csvCell = reader.readNext())!= null)
        {
            open(url + csvCell[0]);
            login(testLogin, testPassword);
            String[] res = (csvCell[0] + "," + checkPage()).split(",");
            writer.writeNext(res, false);
            closeWindow();
        }
        reader.close();
        writer.close();
    }
}
