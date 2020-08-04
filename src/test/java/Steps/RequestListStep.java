package Steps;

import Pages.EventInvitationRequestCreationPage;
import Pages.EventInvitationRequestPage;
import Pages.RequestsListPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class RequestListStep {

    RequestsListPage requestsListPage;

    public RequestListStep() {
        requestsListPage = page(RequestsListPage.class);
    }

    @Step("Выбрать \"Основное\" представление")
    public RequestsListPage setPrimaryReportOption() {
        return requestsListPage.selectPrimaryReportOption();
    }

    @Step("Добавить заявку \"Приглашение на мероприятие\"")
    public EventInvitationRequestCreationPage addEventInvitationRequest() {
        return requestsListPage.pressAddRequestButton().pressEventInvitationButton();
    }

    @Step("Выбрать найденную заявку")
    public EventInvitationRequestPage chooseFoundRequest() {
        return requestsListPage.pressFirstRequestInListButton();
    }

    @Step("Найти заявку по номеру")
    public RequestsListPage searchRequestByNumber(String requestNumber) {
        return requestsListPage
                .enterRequestNumberInSearchField(requestNumber)
                .pressEnterOnSearchField();
    }
}
