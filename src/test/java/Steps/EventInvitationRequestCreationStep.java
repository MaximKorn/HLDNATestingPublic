package Steps;

import Models.EventInvitationRequest;
import Pages.EventInvitationRequestCreationPage;
import Pages.EventInvitationRequestPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class EventInvitationRequestCreationStep {

    EventInvitationRequestCreationPage eventInvitationRequestCreationPage;

    public EventInvitationRequestCreationStep() {
        eventInvitationRequestCreationPage = page(EventInvitationRequestCreationPage.class);
    }

    @Step("Заполнить информацию о заявке и сохраненить")
    public EventInvitationRequestCreationPage fillInEventInvitationRequest(EventInvitationRequest request) {
        return eventInvitationRequestCreationPage
                .selectInitiator(request.getInitiatorName())
                .enterEventName(request.getEventName())
                .enterEventTheme(request.getEventTheme())
                .selectOrganizationType(request.getOrganizationType())
                .enterSenderOrganization(request.getSenderOrganization())
                .pressEnterOnSenderOrganization()
                .switchToFrame()
                .selectFirstOrganizationInFrame()
                .enterInviterName(request.getInviterName())
                .selectPartnershipForm(request.getPartnershipForm())
                .enterEventStartDate(request.getEventStartDate())
                .enterEventEndDate(request.getEventEndDate())
                .enterInvitationResponseDeadline(request.getInvitationResponseDeadline())
                .enterEventProgram(request.getEventProgram())
                .enterCountry(request.getCountry())
                .enterCity(request.getCity())
                .enterAddress(request.getAddress())
                .pressSaveButton()
                .checkDataSave()
                .confirmExpenses();
    }

    @Step("Отправить заявку на согласование")
    public EventInvitationRequestPage sendCreatedRequestToApproval(String comment) {

        return eventInvitationRequestCreationPage.pressSendForApprovalButton()
                .switchToFrame()
                .enterCommentInFrame(comment)
                .pressSendButtonInFrame()
                .checkOperationCompletion();
    }

    @Step("Запомнить номер созданной заявки")
    public String rememberCreatedRequestNumber() {
        return eventInvitationRequestCreationPage.getRequestNumber();
    }
}
