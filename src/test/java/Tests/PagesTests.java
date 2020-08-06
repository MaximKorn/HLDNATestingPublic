package Tests;

import static com.codeborne.selenide.Selenide.*;
import static Utils.UtilsCSV.*;
import static com.codeborne.selenide.WebDriverRunner.url;

import Models.User;
import Steps.ErrorStep;
import Steps.LoginStep;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class PagesTests extends BaseTest {

    public String getSessionId(String url) {
        String[] id = url.substring(51, 67).split(":");
        return id[0];
    }

    public LoginStep loginStep;
    public ErrorStep errorStep;
    User testUser;

    @BeforeMethod(description = "Открытие браузера")
    public void beforeMethod() {
        open(baseUrl);
        loginStep = new LoginStep();
        errorStep = new ErrorStep();
        testUser = new User("SELENIUM", "$eleN1Um");
    }

    @Description("Проверка страниц 1-200 на ошибки")
    @Test(enabled = false)
    public void manyPagesTest() throws IOException {
        CSVWriter writer = writeCSV(csvWritePages2);
        String sessionId = getSessionId(url());
        loginStep.login(testUser);
        String[] res;
        for (int i = 1; i < 101; i++) {
            String page = Integer.toString(i);
            open(baseUrl + page + ":" + sessionId);
            res = (page + "," + errorStep.checkPageForErrors()).split(",");
            writer.writeNext(res, false);
        }

        for (int i = 103; i < 201; i++) {
            String page = Integer.toString(i);
            open(baseUrl + page + ":" + sessionId);
            res = (page + "," + errorStep.checkPageForErrors()).split(",");
            writer.writeNext(res, false);
        }
        writer.close();
    }

    @Description("Проверка необходимых страниц на ошибки")
    @Test(enabled = false)
    public void pagesTest() throws IOException, CsvValidationException {
        CSVReader reader = readCSV(csvReadPages);
        CSVWriter writer = writeCSV(csvWritePages1);
        String[] csvCell;
        String sessionId = getSessionId(url());
        loginStep.login(testUser);

        while ((csvCell = reader.readNext()) != null) {
            String[] res;
            if (!csvCell[0].equals("2886")) {
                open(baseUrl + csvCell[0] + ":" + sessionId);
                res = (csvCell[0] + "," + errorStep.checkPageForErrors()).split(",");
            } else {
                open(baseUrl + csvCell[0] + ":" + sessionId + "::NO::P2886_TYPE:" + csvCell[1]);
                res = (csvCell[0] + " " + csvCell[1] + "," + errorStep.checkPageForErrors()).split(",");
            }
            writer.writeNext(res, false);
        }
        reader.close();
        writer.close();
    }

    @AfterMethod(description = "Прикрепление файлов с результатами")
    public void afterMethod(ITestResult result) throws IOException {
        if(result.getName()=="pagesTest")
        {
            addPagesResults();
        }
        else if(result.getName()=="manyPagesTest")
        {
            addManyPagesResults();
        }
        else
        {
            return;
        }
    }

    @Attachment(value = "ResultsCSV", fileExtension = "csv")
    private byte[] addPagesResults() throws IOException {
        File file = new File(csvWritePages1);
        return FileUtils.readFileToByteArray(file);
    }

    @Attachment(value = "ResultsCSV", fileExtension = "csv")
    private byte[] addManyPagesResults() throws IOException {
        File file = new File(csvWritePages2);
        return FileUtils.readFileToByteArray(file);
    }

}
