package Pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class EventInvitationRequestCreationPage extends EventInvitationRequestPage {
    @Step("Выбрать инициатора")
    public EventInvitationRequestCreationPage selectInitiator(String initiator) {
        $x("//div[@data-md-name='AUTHOR_ID']/div/select/option[text()='" + initiator + "']").click();
        return this;
    }

    @Step("Ввести название мероприятия")
    public EventInvitationRequestCreationPage enterEventName(String eventName) {
        $x("//div[@data-md-name='NAME']/div[@class='card-col-item']/input[@type='text']").setValue(eventName);
        return this;
    }

    @Step("Ввести тему мероприятия")
    public EventInvitationRequestCreationPage enterEventTheme(String eventTheme) {
        $x("//div[@data-md-name='EVENT_REASON']/div[@class='card-col-item']/input[@type='text']").setValue(eventTheme);
        return this;
    }

    @Step("Выбрать тип организации")
    public EventInvitationRequestCreationPage selectOrganizationType(String organizationType) {
        $x("//div[@data-md-name='ORG_TYPE_ID']/div[@class='card-col-item']/select/option[text()='" + organizationType + "']").click();
        return this;
    }

    @Step("Выбрать приглашающую сторону")
    public EventInvitationRequestCreationPage enterSenderOrganization(String senderOrganization) {
        $x("//div[@data-md-name='SENDER_ORG_ID']/div[@class='card-col-item']/div/input[@type='text']").setValue(senderOrganization).pressEnter();
        return this;
    }

    @Step("Нажать на ENTER в поле \"Приглашающая сторона\"")
    public EventInvitationRequestCreationPage pressEnterOnSenderOrganization() {
        $x("//div[@data-md-name='SENDER_ORG_ID']/div[@class='card-col-item']/div/input[@type='text']").pressEnter();
        return this;
    }

    @Step("Переключиться на диалоговое окно")
    public EventInvitationRequestCreationPage switchToFrame() {
        switchTo().frame($(By.tagName("iframe")));
        return this;
    }

    @Step("Выбрать первую организацию в списке")
    public EventInvitationRequestCreationPage selectFirstOrganizationInFrame() {
        $x("//span[text()='Выбрать']").click();
        return this;
    }

//    @Step("Выйти из диалогового окна")
//    public EventInvitationRequestCreationPage returnFromFrame() {
//        switchTo().defaultContent();
//        return this;
//    }

    @Step("Ввести ФИО приглашающего")
    public EventInvitationRequestCreationPage enterInviterName(String inviterName) {
        $x("//div[@data-md-name='INVITE_PERSON']/div[@class='card-col-item']/input[@type='text']").setValue(inviterName);
        return this;
    }

    @Step("Выбрать форму партнёрства")
    public EventInvitationRequestCreationPage selectPartnershipForm(String partnershipForm) {
        $x("//div[@data-md-name='PARTNERSHIP_FORM']/div[@class='card-col-item']/select/option[text()='" + partnershipForm + "']").click();
        return this;
    }

    @Step("Выбрать дату начала мероприятия")
    public EventInvitationRequestCreationPage enterEventStartDate(String eventStartDate) {
        $x("//div[@data-md-name='START_DATE_PLAN']/div[@class='card-col-item']/span/input[@type='text']").setValue(eventStartDate);
        return this;
    }

    @Step("Выбрать дату окончания мероприятия")
    public EventInvitationRequestCreationPage enterEventEndDate(String eventEndDate) {
        $x("//div[@data-md-name='END_DATE_PLAN']/div[@class='card-col-item']/span/input[@type='text']").setValue(eventEndDate);
        return this;
    }

    @Step("Выбрать дату дедлайна по ответу на приглашение")
    public EventInvitationRequestCreationPage enterInvitationResponseDeadline(String invitationResponseDeadline) {
        $x("//div[@data-md-name='FEEDBACK_DATE']/div[@class='card-col-item']/span/input[@type='text']").setValue(invitationResponseDeadline);
        return this;
    }

    @Step("Ввести программу мероприятия")
    public EventInvitationRequestCreationPage enterEventProgram(String eventProgram) {
        $x("//div[@data-md-name='EVENT_PROGRAM']/div[@class='card-col-item']/textarea").setValue(eventProgram);
        return this;
    }

    @Step("Ввести страну")
    public EventInvitationRequestCreationPage enterCountry(String country) {
        $x("//div[@data-md-name='COUNTRY']/div[@class='card-col-item']/input[@type='text']").setValue(country);
        return this;
    }

    @Step("Ввести город")
    public EventInvitationRequestCreationPage enterCity(String city) {
        $x("//div[@data-md-name='CITY']/div[@class='card-col-item']/input[@type='text']").setValue(city);
        return this;
    }

    @Step("Ввести адрес")
    public EventInvitationRequestCreationPage enterAddress(String address) {
        $x("//div[@data-md-name='ADDRESS']/div[@class='card-col-item']/input[@type='text']").setValue(address);
        return this;
    }

    @Step("Нажать кнопку \"Сохранить\"")
    public EventInvitationRequestCreationPage pressSaveButton() {
        $x("//button[@value='Сохранить']").click();
        return this;
    }

    @Step("Проверить, что данные сохранены")
    public EventInvitationRequestCreationPage checkDataSave() {
        $x("//div[@class='toast-message']").shouldHave(Condition.text("Данные сохранены."));
        return this;
    }

    @Step("Подтвердить расходы")
    public EventInvitationRequestCreationPage confirmExpenses() {
        $x("//div[@data-md-name='EXPENSES_CONFIRMATION']/div[@class='card-col-item']/input[@type='checkbox']").click();
        return this;
    }

    @Step("Нажать на кнопку \"Отправить на согласование\"")
    public EventInvitationRequestCreationPage pressSendForApprovalButton() {
        $x("//button[@value='Отправить на согласование']").click();
        return this;
    }

    @Step("Ввести коментарий")
    public EventInvitationRequestCreationPage enterCommentInFrame(String comment) {
        $x("//textarea[@name='P3434_COMMENT']").setValue(comment);
        return this;
    }

    @Step("Нажать на кнопку \"Отправить\"")
    public EventInvitationRequestCreationPage pressSendButtonInFrame() {
        $x("//button[@value='Отправить']").click();
        return this;
    }

    @Step("Проверить, что операция выполнена")
    public EventInvitationRequestPage checkOperationCompletion() {
        $x("//div[@class='toast-message']").shouldHave(Condition.text("Операция выполнена."));
        return this;
    }

    @Step("Перейти на вкладку \"Согласование\"")
    public EventInvitationRequestPage pressApprovalButton() {
        $x("//a[text()='Согласование']").click();
        return page(EventInvitationRequestPage.class);
    }

    @Step("Получить номер заявки")
    public String getRequestNumber() {
        return $x("//div[@data-md-name='CODE']/div[@class='card-col-item']").getText();
    }
}
