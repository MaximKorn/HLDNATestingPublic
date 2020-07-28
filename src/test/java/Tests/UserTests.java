package Tests;

import static Utils.UtilsCSV.*;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static Utils.UtilsCSV.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserTests extends BaseTest
{

    CSVReader reader;
    String[] data;

    @BeforeMethod
    public void beforeMethod() throws IOException
    {
        reader = readCSV(csvUserData);
        Configuration.timeout = 8000;
    }

    public String requestCreation()
    {
        $x("//select[@id='card-item-0001']/option[@value='360024640042']").click();
        $x("//input[@id='card-item-0002']").setValue("Тестовое Мероприятие");
        $x("//input[@id='card-item-0003']").setValue("Тестовая Тема");
        $x("//select[@id='card-item-0004']/option[@value='386627491142']").click();
        $x("//div[@class='card-col-item']/div/input[@type='text']").setValue("ООО \"Медведь Абакан\"").pressEnter();
        switchTo().frame($(By.tagName("iframe")));
        $x("//span[text()='Выбрать']").click();
        switchTo().parentFrame();
        $x("//input[@id='card-item-0006']").setValue("Иванов Андрей Петрович");
        $x("//select[@id='card-item-0007']/option[@value='388053031142']").click();

        SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DATE,3);
        $x("//input[@id='card-item-0010']").setValue(dateFormat.format(calendar.getTime()));
        calendar.add(calendar.DATE,2);
        $x("//input[@id='card-item-0008']").setValue(dateFormat.format(calendar.getTime()));
        calendar.add(calendar.DATE,5);
        $x("//input[@id='card-item-0009']").setValue(dateFormat.format(calendar.getTime()));

        $x("//textarea[@id='card-item-0011']").setValue("Тестовая программа мероприятия");

        $x("//input[@id='card-item-0012']").setValue("Россия");
        $x("//input[@id='card-item-0013']").setValue("Воронеж");
        $x("//input[@id='card-item-0014']").setValue("Московский проспект, 1");
        $x("//button[@value='Сохранить']").click();

        String requestNumber = $x("//div[@data-id='170811142']/div[@class='card-col-item']").getText();

        $x("//div[@data-md-name='EXPENSES_CONFIRMATION']/div/input[@type='checkbox']").click();
        $x("//button[@value='Отправить на согласование']").click();
        switchTo().frame($(By.tagName("iframe")));
        $x("//textarea[@id='P3434_COMMENT']").setValue("Тестовый комментарий");
        $x("//button[@title='Отправить']").click();
        //switchTo().parentFrame();

        $x("//a[text()='Согласование']").click();
        $x("//tr[@title='Выполненный шаг']/td[@class='td RESULT_NAME']").shouldHave(Condition.text("Отправить на согласование"));

        return requestNumber;
    }

    public void requestApproval(String requestNumber, int coordinatorNumber)
    {
        $x("//select[@title='Представления']/optgroup/option[@value='40328786030593856']").click();
        $x("//input[@title='Поиск в представлении']").setValue(requestNumber).pressEnter();
        $x("//td[@headers='C40317615269586202']/a").click();
        $x("//button[@value='Одобрить']").click();
        switchTo().frame($(By.tagName("iframe")));
        $x("//textarea[@id='P3434_COMMENT']").setValue("Одобрительный тестовый комментарий");
        $x("//button[@title='Отправить']").click();
        switchTo().parentFrame();

        $x("//a[text()='Согласование']").click();
        $$x("//tr[@title='Выполненный шаг']/td[@class='td RESULT_NAME']").get(coordinatorNumber).shouldHave(Condition.text("Одобрить"));
    }

    @Test
    public void requestCreationAndApproval() throws IOException, CsvValidationException {

        //Первый пользователь
        open(baseUrl);
        data = reader.readNext();
        login(data[0],data[1]);
        $x("//button[text()='Compliance']").click();
        $x("//span/a[text()='Заявки']").click();
        $x("//button[@value='Добавить']").click();
        $x("//a[text()='Приглашение на мероприятие']").click();
        String requestNumber = requestCreation();
        $x("//a[@title='Выход из приложения']").click();

        //Второй пользователь
        data = reader.readNext();
        login(data[0],data[1]);

        $x("//button[text()='Compliance']").click();
        $x("//span/a[text()='Заявки']").click();
        requestApproval(requestNumber, 1);
        $x("//a[@title='Выход из приложения']").click();

        //Третий пользователь
        data = reader.readNext();
        login(data[0],data[1]);

        requestApproval(requestNumber, 2);
        $$x("//tr[@title='Выполненный шаг']/td[@class='td STATUS_NAME']").get(2).shouldHave(Condition.text("Согласована"));
    }

}
