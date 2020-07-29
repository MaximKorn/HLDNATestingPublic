package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class EventInvitationRequestCreationPage extends EventInvitationRequestPage {
    public EventInvitationRequestCreationPage selectInitiator() {
        $x("//div[@data-md-name='AUTHOR_ID']/div/select/option[@value='360024640042']").click();
        return this;
    }

    public EventInvitationRequestCreationPage enterEventName(String eventName) {
        $x("//div[@data-md-name='NAME']/div[@class='card-col-item']/input[@type='text']").setValue(eventName);
        return this;
    }

    public EventInvitationRequestCreationPage enterEventTheme(String eventTheme) {
        $x("//div[@data-md-name='EVENT_REASON']/div[@class='card-col-item']/input[@type='text']").setValue(eventTheme);
        return this;
    }

    public EventInvitationRequestCreationPage selectOrganizationType() {
        $x("//div[@data-md-name='ORG_TYPE_ID']/div[@class='card-col-item']/select/option[@value='386627491142']").click();
        return this;
    }

    public EventInvitationRequestCreationPage enterSenderOrganization(String senderOrganization) {
        $x("//div[@data-md-name='SENDER_ORG_ID']/div[@class='card-col-item']/div/input[@type='text']").setValue(senderOrganization).pressEnter();
        return this;
    }

    public EventInvitationRequestCreationPage pressEnterOnSenderOrganization() {
        $x("//div[@data-md-name='SENDER_ORG_ID']/div[@class='card-col-item']/div/input[@type='text']").pressEnter();
        return this;
    }

    public EventInvitationRequestCreationPage switchToFrame() {
        switchTo().frame($(By.tagName("iframe")));
        return this;
    }

    public EventInvitationRequestCreationPage selectFirstOrganizationInFrame() {
        $x("//span[text()='Выбрать']").click();
        return this;
    }

    public EventInvitationRequestCreationPage returnFromFrame() {
        switchTo().defaultContent();
        return this;
    }

    public EventInvitationRequestCreationPage enterInviterName(String inviterName) {
        $x("//div[@data-md-name='INVITE_PERSON']/div[@class='card-col-item']/input[@type='text']").setValue(inviterName);
        return this;
    }

    public EventInvitationRequestCreationPage selectPartnershipForm() {
        $x("//div[@data-md-name='PARTNERSHIP_FORM']/div[@class='card-col-item']/select/option[@value='388053031142']").click();
        return this;
    }

    public EventInvitationRequestCreationPage enterEventStartDate(String eventStartDate) {
        $x("//div[@data-md-name='START_DATE_PLAN']/div[@class='card-col-item']/span/input[@type='text']").setValue(eventStartDate);
        return this;
    }

    public EventInvitationRequestCreationPage enterEventEndDate(String eventEndDate) {
        $x("//div[@data-md-name='END_DATE_PLAN']/div[@class='card-col-item']/span/input[@type='text']").setValue(eventEndDate);
        return this;
    }

    public EventInvitationRequestCreationPage enterInvitationResponseDeadline(String invitationResponseDeadline) {
        $x("//div[@data-md-name='FEEDBACK_DATE']/div[@class='card-col-item']/span/input[@type='text']").setValue(invitationResponseDeadline);
        return this;
    }

    public EventInvitationRequestCreationPage enterEventProgram(String eventProgram) {
        $x("//div[@data-md-name='EVENT_PROGRAM']/div[@class='card-col-item']/textarea").setValue(eventProgram);
        return this;
    }

    public EventInvitationRequestCreationPage enterCountry(String country) {
        $x("//div[@data-md-name='COUNTRY']/div[@class='card-col-item']/input[@type='text']").setValue(country);
        return this;
    }

    public EventInvitationRequestCreationPage enterCity(String city) {
        $x("//div[@data-md-name='CITY']/div[@class='card-col-item']/input[@type='text']").setValue(city);
        return this;
    }

    public EventInvitationRequestCreationPage enterAddress(String address) {
        $x("//div[@data-md-name='ADDRESS']/div[@class='card-col-item']/input[@type='text']").setValue(address);
        return this;
    }

    public EventInvitationRequestCreationPage pressSaveButton() {
        $x("//button[@value='Сохранить']").click();
        return this;
    }

    public EventInvitationRequestCreationPage checkDataSave() {
        $x("//div[@class='toast-message']").shouldHave(Condition.text("Данные сохранены."));
        return this;
    }

    public EventInvitationRequestCreationPage confirmExpenses() {
        $x("//div[@data-md-name='EXPENSES_CONFIRMATION']/div[@class='card-col-item']/input[@type='checkbox']").click();
        return this;
    }

    public EventInvitationRequestCreationPage pressSendForApprovalButton() {
        $x("//button[@value='Отправить на согласование']").click();
        return this;
    }

    public EventInvitationRequestCreationPage enterCommentInFrame(String comment) {
        $x("//textarea[@name='P3434_COMMENT']").setValue(comment);
        return this;
    }

    public EventInvitationRequestCreationPage pressSendButtonInFrame() {
        $x("//button[@value='Отправить']").click();
        return this;
    }

    public EventInvitationRequestCreationPage checkOperationCompletion() {
        $x("//div[@class='toast-message']").shouldHave(Condition.text("Операция выполнена."));
        return this;
    }

    public EventInvitationRequestPage pressApprovalButon() {
        $x("//a[text()='Согласование']").click();
        return page(EventInvitationRequestPage.class);
    }
}
