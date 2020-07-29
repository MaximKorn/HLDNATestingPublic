package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class RequestsListPage extends BasePage {
    //private SelenideElement addRequestButton = $x("//button[@value='Добавить']");
    //private SelenideElement addEventInvitationButton = $x("//a[text()='Приглашение на мероприятие']");
    //private SelenideElement primaryReportOption = $x("//select[@title='Представления']/optgroup/option[@value='40328786030593856']");
    //private SelenideElement searchRequestInput = $x("//input[@title='Поиск в представлении']");
    //private SelenideElement firstRequestInListButton = $x("//td[@headers='C40317615269586202']/a");

    public EventInvitationRequestCreationPage pressAddRequestButton() {
        $x("//button[@value='Добавить']").click();
        return page(EventInvitationRequestCreationPage.class);
    }

    public RequestsListPage pressEventInvitationButton() {
        $x("//a[text()='Приглашение на мероприятие']").click();
        return this;
    }

    public RequestsListPage selectPrimaryReportOption() {
        $x("//select[@title='Представления']/optgroup/option[@value='40328786030593856']").click();
        return this;
    }

    public RequestsListPage enterRequestNumberInSearchField(String requestNumber) {
        $x("//input[@title='Поиск в представлении']").setValue(requestNumber);
        return this;
    }

    public RequestsListPage pressEnterOnSearchField() {
        $x("//input[@title='Поиск в представлении']").pressEnter();
        return this;
    }

    public EventInvitationRequestPage pressFirstRequestInListButton() {
        $x("//td[@headers='C40317615269586202']/a").click();
        return page(EventInvitationRequestPage.class);
    }
}
