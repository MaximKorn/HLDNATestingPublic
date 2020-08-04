package Pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class EventInvitationRequestPage extends BasePage {


    @Step("Перейти на вкладку \"Согласование\"")
    public EventInvitationRequestPage pressApprovalButton() {
        $x("//a[text()='Согласование']").click();
        return this;
    }

    @Step("Убедиться, что результат данного этапа - \"Отправить на согласование\"")
    public EventInvitationRequestPage checkCreationStepResult() {
        $x("//tr[@title='Выполненный шаг']/td[@class='td RESULT_NAME']").shouldHave(Condition.text("Отправить на согласование"));
        return this;
    }

    @Step("Нажать кнопку \"Одобрить\"")
    public EventInvitationRequestPage pressApproveButton() {
        $x("//button[@value='Одобрить']").click();
        return this;
    }

    @Step("Ввести коментарий")
    public EventInvitationRequestPage enterCommentInFrame(String comment) {
        $x("//textarea[@name='P3434_COMMENT']").setValue(comment);
        return this;
    }

    @Step("Нажать на кнопку \"Отправить\"")
    public EventInvitationRequestPage pressSendButtonInFrame() {
        $x("//button[@value='Отправить']").click();
        return this;
    }

    @Step("Убедиться, что результат данного этапа - \"Одобрить\"")
    public EventInvitationRequestPage checkApprovalStepResult(int approvalStepNumber) {
        $$x("//tr[@title='Выполненный шаг']/td[@class='td RESULT_NAME']").get(approvalStepNumber).shouldHave(Condition.text("Одобрить"));
        return this;
    }

    @Step("Проверить, что операция выполнена")
    public EventInvitationRequestPage checkOperationCompletion() {
        $x("//div[@class='toast-message']").shouldHave(Condition.text("Операция выполнена."));
        return this;
    }

    @Step("Убедиться, что статус заявки - \"Согласована\"")
    public EventInvitationRequestPage checkApprovalFinalStatus(int approvalFinalStepNumber) {
        $$x("//tr[@title='Выполненный шаг']/td[@class='td STATUS_NAME']").get(approvalFinalStepNumber-1).shouldHave(Condition.text("Согласована"));
        return this;
    }

    @Step("Переключиться на диалоговое окно")
    public EventInvitationRequestPage switchToFrame() {
        switchTo().frame($(By.tagName("iframe")));
        return this;
    }

}
