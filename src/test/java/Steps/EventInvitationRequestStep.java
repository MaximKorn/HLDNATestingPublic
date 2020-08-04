package Steps;

import Pages.EventInvitationRequestPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class EventInvitationRequestStep {
    public EventInvitationRequestPage eventInvitationRequestPage;

    public EventInvitationRequestStep() {
        eventInvitationRequestPage = page(EventInvitationRequestPage.class);
    }

    @Step("Одобрить заявку")
    public EventInvitationRequestPage approveEventInvitationRequest(String comment) {
        return eventInvitationRequestPage
                .pressApproveButton()
                .switchToFrame()
                .enterCommentInFrame(comment)
                .pressSendButtonInFrame()
                .checkOperationCompletion();
    }

    @Step("Проверить результат первого этапа согласования заявки")
    public EventInvitationRequestPage checkApprovalRequestFirstStepResult() {
        return eventInvitationRequestPage
                .pressApprovalButton()
                .checkCreationStepResult();
    }

    @Step("Проверить результат второго этапа согласования заявки")
    public EventInvitationRequestPage checkApprovalRequestSecondStepResult()
    {
        return eventInvitationRequestPage
                .pressApprovalButton()
                .checkApprovalStepResult(1);
    }

    @Step("Проверить результат третьего этапа согласования заявки")
    public EventInvitationRequestPage checkApprovalRequestThirdStepResult()
    {
        return eventInvitationRequestPage
                .pressApprovalButton()
                .checkApprovalStepResult(2);
    }

    @Step("Проверить окончательный статус заявки")
    public EventInvitationRequestPage checkApprovalRequestFinalStatus()
    {
        return eventInvitationRequestPage
                .checkApprovalFinalStatus(3);
    }

}