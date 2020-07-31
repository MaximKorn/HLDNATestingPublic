package Steps;

import Pages.EventInvitationRequestCreationPage;
import Pages.EventInvitationRequestPage;
import Pages.RequestsListPage;

import static com.codeborne.selenide.Selenide.page;

public class RequestListStep {

    RequestsListPage requestsListPage;

    public RequestListStep() {
        requestsListPage = page(RequestsListPage.class);
    }

    public RequestsListPage setPrimaryReportOption() {
        return requestsListPage
                .pressEventInvitationButton()
                .selectPrimaryReportOption();
    }

    public EventInvitationRequestCreationPage addEventInvitationRequest() {
        return requestsListPage.pressAddRequestButton();
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
