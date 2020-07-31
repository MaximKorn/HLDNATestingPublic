package Steps;

import Pages.EventInvitationRequestPage;

import static com.codeborne.selenide.Selenide.page;

public class EventInvitationRequestStep {
    public EventInvitationRequestPage eventInvitationRequestPage;

    public EventInvitationRequestStep() {
        eventInvitationRequestPage = page(EventInvitationRequestPage.class);
    }

    public EventInvitationRequestPage approveEventInvitationRequest(String comment) {
        return eventInvitationRequestPage
                .pressApproveButton()
                .switchToFrame()
                .enterCommentInFrame(comment)
                .pressSendButtonInFrame()
                .checkOperationCompletion();
    }

    public EventInvitationRequestPage checkApprovalRequestFirstStepResult() {
        return eventInvitationRequestPage
                .pressApprovalButton()
                .checkCreationStepResult();
    }

    public EventInvitationRequestPage checkApprovalRequestSecondStepResult()
    {
        return eventInvitationRequestPage
                .pressApprovalButton()
                .checkApprovalStepResult(1);
    }

    public EventInvitationRequestPage checkApprovalRequestThirdStepResult()
    {
        return eventInvitationRequestPage
                .pressApprovalButton()
                .checkApprovalStepResult(2);
    }

    public EventInvitationRequestPage checkApprovalRequestFinalStatus()
    {
        return eventInvitationRequestPage
                .pressApprovalButton()
                .checkApprovalFinalStatus(3);
    }

}