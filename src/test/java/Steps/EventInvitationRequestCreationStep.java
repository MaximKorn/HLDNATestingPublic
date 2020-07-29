package Steps;

import Pages.EventInvitationRequestCreationPage;

import static com.codeborne.selenide.Selenide.page;

public class EventInvitationRequestCreationStep {

    EventInvitationRequestCreationPage eventInvitationRequestCreationPage;

    public EventInvitationRequestCreationStep()
    {
        eventInvitationRequestCreationPage = page(EventInvitationRequestCreationPage.class);
    }
}
