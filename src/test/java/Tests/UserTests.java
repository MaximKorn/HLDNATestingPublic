package Tests;

import static Utils.UtilsCSV.*;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserTests extends BaseTest
{

    CSVReader reader;
    String[] data;
    SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");

    @BeforeMethod
    public void beforeMethod() throws IOException
    {
        reader = readCSV(csvUserData);
        Configuration.timeout = 8000;
    }

    public void creat() throws InterruptedException {
        $x("//div[@data-md-name='AUTHOR_ID']/div/select/option[@value='360024640042']").click();
        $x("//div[@data-md-name='NAME']/div[@class='card-col-item']/input").setValue("Тестовое Мероприятие");
        $x("//div[@data-md-name='EVENT_REASON']/div[@class='card-col-item']/input[@type='text']").setValue("Тестовая Тема");
        $x("//div[@data-md-name='ORG_TYPE_ID']/div[@class='card-col-item']/select/option[@value='386627491142']").click();
        $x("//div[@data-md-name='SENDER_ORG_ID']/div[@class='card-col-item']/div/input[@type='text']").setValue("ООО \"Медведь Абакан\"").pressEnter();
        switchTo().frame($(By.tagName("iframe")));
        $x("//span[text()='Выбрать']").click();
        $x("//div[@data-md-name='INVITE_PERSON']/div[@class='card-col-item']/input[@type='text']").setValue("Иванов Андрей Петрович");
        $x("//select[@id='card-item-0007']/option[@value='388053031142']").click();
        Thread.sleep(5000);
    }


    public String requestCreation()
    {
        $x("//div[@data-md-name='AUTHOR_ID']/div/select/option[@value='360024640042']").click();
        $x("//div[@data-md-name='NAME']/div[@class='card-col-item']/input[@type='text']").setValue("Тестовое Мероприятие");
        $x("//div[@data-md-name='EVENT_REASON']/div[@class='card-col-item']/input[@type='text']").setValue("Тестовая Тема");
        $x("//div[@data-md-name='ORG_TYPE_ID']/div[@class='card-col-item']/select/option[@value='386627491142']").click();
        $x("//div[@data-md-name='SENDER_ORG_ID']/div[@class='card-col-item']/div/input[@type='text']").setValue("ООО \"Медведь Абакан\"").pressEnter();
        switchTo().frame($(By.tagName("iframe")));
        $x("//span[text()='Выбрать']").click();
        switchTo().defaultContent();
        $x("//div[@data-md-name='INVITE_PERSON']/div[@class='card-col-item']/input[@type='text']").setValue("Иванов Андрей Петрович");
        $x("//div[@data-md-name='PARTNERSHIP_FORM']/div[@class='card-col-item']/select/option[@value='388053031142']").click();

        $x("//div[@data-md-name='START_DATE_PLAN']/div[@class='card-col-item']/span/input[@type='text']").setValue(dateFormat.format(Calendar.DATE + 7));
        $x("//div[@data-md-name='END_DATE_PLAN']/div[@class='card-col-item']/span/input[@type='text']").setValue(dateFormat.format(Calendar.DATE + 8));
        $x("//div[@data-md-name='FEEDBACK_DATE']/div[@class='card-col-item']/span/input[@type='text']").setValue(dateFormat.format(Calendar.DATE + 3));
        $x("//div[@data-md-name='EVENT_PROGRAM']/div[@class='card-col-item']/textarea").setValue("Тестовая программа мероприятия");

        $x("//div[@data-md-name='COUNTRY']/div[@class='card-col-item']/input[@type='text']").setValue("Россия");
        $x("//div[@data-md-name='CITY']/div[@class='card-col-item']/input[@type='text']").setValue("Воронеж");
        $x("//div[@data-md-name='ADDRESS']/div[@class='card-col-item']/input[@type='text']").setValue("Московский проспект, 1");
        $x("//button[@value='Сохранить']").click();
        $x("//div[@class='toast-message']").shouldHave(Condition.text("Данные сохранены."));

        String requestNumber = $x("//div[@data-md-name='CODE']/div[@class='card-col-item']").getText();

        $x("//div[@data-md-name='EXPENSES_CONFIRMATION']/div[@class='card-col-item']/input[@type='checkbox']").click();
        $x("//button[@value='Отправить на согласование']").click();
        switchTo().frame($(By.tagName("iframe")));
        $x("//textarea[@name='P3434_COMMENT']").setValue("Тестовый комментарий");
        $x("//button[@value='Отправить']").click();
        $x("//div[@class='toast-message']").shouldHave(Condition.text("Операция выполнена."));

        $x("//a[text()='Согласование']").click();
        $x("//tr[@title='Выполненный шаг']/td[@class='td RESULT_NAME']").shouldHave(Condition.text("Отправить на согласование"));


        return requestNumber;
    }

    @Test
    public void testTest() throws IOException, CsvValidationException, InterruptedException {
        open(baseUrl);
        data = reader.readNext();
        login(data[0],data[1]);
        $x("//button[text()='Compliance']").click();
        $x("//span/a[text()='Заявки']").click();
        $x("//button[@value='Добавить']").click();
        $x("//a[text()='Приглашение на мероприятие']").click();
        //creat();
    }

    public void requestApproval(String requestNumber, int coordinatorNumber)
    {
        $x("//select[@title='Представления']/optgroup/option[@value='40328786030593856']").click();
        $x("//input[@title='Поиск в представлении']").setValue(requestNumber).pressEnter();
        $x("//td[@headers='C40317615269586202']/a").click();
        $x("//button[@value='Одобрить']").click();
        switchTo().frame($(By.tagName("iframe")));
        $x("//textarea[@name='P3434_COMMENT']").setValue("Одобрительный тестовый комментарий");
        $x("//button[@title='Отправить']").click();
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
