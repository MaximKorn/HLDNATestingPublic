package Steps;

import Pages.EventInvitationRequestCreationPage;
import Pages.EventInvitationRequestPage;
import Pages.RequestsListPage;

import static com.codeborne.selenide.Selenide.page;

public class RequestListStep {

    RequestsListPage requestsListPage;

    public RequestListStep(RequestsListPage requestsListPage1) {
        requestsListPage = requestsListPage1;
    }

    public RequestsListPage setPrimaryReportOption() {
        return requestsListPage.selectPrimaryReportOption();
    }

    public EventInvitationRequestCreationPage addEventInvitationRequest() {
        return requestsListPage.pressAddRequestButton().pressEventInvitationButton();
    }

    public EventInvitationRequestPage chooseFoundRequest() {
        return requestsListPage.pressFirstRequestInListButton();
    }

    public RequestsListPage searchRequestByNumber(String requestNumber) {
        return requestsListPage
                .enterRequestNumberInSearchField(requestNumber)
                .pressEnterOnSearchField();
    }
}