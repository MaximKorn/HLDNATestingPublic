package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    @Step("Нажать кнопку \"Compliance\"")
    public BasePage pressComplianceButton() {
        $x("//button[text()='___Compliance']").click();
        return this;
    }
    @Step("Выбрать пункт \"Заявки\"")
    public RequestsListPage pressRequestsButton() {
        $x("//span/a[text()='Заявки']").click();
        return page(RequestsListPage.class);
    }

    @Step("Нажать кнопку \"Выйти\"")
    public LoginPage pressLogoutButton() {
        $x("//a[@title='Выход из приложения']").click();
        return page(LoginPage.class);
    }


    public BasePage switchToFrame() {
        switchTo().frame($(By.tagName("iframe")));
        return this;
    }

    public BasePage returnFromFrame() {
        switchTo().defaultContent();
        return this;
    }
}
