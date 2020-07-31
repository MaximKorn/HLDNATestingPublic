package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
//    public SelenideElement complianceButton = $x("//button[text()='Compliance']");
//    public SelenideElement requestsButton = $x("//span/a[text()='Заявки']");
//    public SelenideElement logoutButton = $x("//a[@title='Выход из приложения']");

    public BasePage pressComplianceButton() {
        $x("//button[text()='Compliance']").click();
        return this;
    }

    public RequestsListPage pressRequestsButton() {
        $x("//span/a[text()='Заявки']").click();
        return page(RequestsListPage.class);
    }

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
