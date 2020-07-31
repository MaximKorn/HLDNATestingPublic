package Steps;

import Pages.EventInvitationRequestCreationPage;
import Pages.EventInvitationRequestPage;

import static com.codeborne.selenide.Selenide.page;

public class EventInvitationRequestCreationStep {

    EventInvitationRequestCreationPage eventInvitationRequestCreationPage;

    public EventInvitationRequestCreationStep(EventInvitationRequestCreationPage eventInvitationRequestCreationPage1)
    {
        eventInvitationRequestCreationPage = eventInvitationRequestCreationPage1;
    }


    public EventInvitationRequestCreationPage fillInEventInvitationRequest(String eventName, String eventTheme, String senderOrganization, String inviterName,
                                                                   String eventStartDate, String eventEndDate, String invitationResponseDeadline,
                                                                   String eventProgram, String country, String city, String address)
    {
        return eventInvitationRequestCreationPage
                .selectInitiator()
                .enterEventName(eventName)
                .enterEventTheme(eventTheme)
                .selectOrganizationType()
                .enterSenderOrganization(senderOrganization)
                .pressEnterOnSenderOrganization()
                .switchToFrame()
                .selectFirstOrganizationInFrame()
                .enterInviterName(inviterName)
                .selectPartnershipForm()
                .enterEventStartDate(eventStartDate)
                .enterEventEndDate(eventEndDate)
                .enterInvitationResponseDeadline(invitationResponseDeadline)
                .enterEventProgram(eventProgram)
                .enterCountry(country)
                .enterCity(city)
                .enterAddress(address)
                .pressSaveButton()
                .checkDataSave()
                .confirmExpenses();
    }

    public EventInvitationRequestPage sendCreatedRequestToApproval(String comment)
    {

        return eventInvitationRequestCreationPage  .pressSendForApprovalButton()
            .switchToFrame()
            .enterCommentInFrame(comment)
            .pressSendButtonInFrame()
            .checkOperationCompletion();
    }

}
