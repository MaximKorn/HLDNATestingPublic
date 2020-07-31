package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class EventInvitationRequestPage extends BasePage {
    public String getRequestNumber() {
        return $x("//div[@data-md-name='CODE']/div[@class='card-col-item']").getText();
    }

    public EventInvitationRequestPage pressApprovalButton() {
        $x("//a[text()='Согласование']").click();
        return this;
    }

    public EventInvitationRequestPage checkCreationStepResult() {
        $x("//tr[@title='Выполненный шаг']/td[@class='td RESULT_NAME']").shouldHave(Condition.text("Отправить на согласование"));
        return this;
    }

    public EventInvitationRequestPage pressApproveButton() {
        $x("//button[@value='Одобрить']").click();
        return this;
    }

    public EventInvitationRequestPage enterCommentInFrame(String comment) {
        $x("//textarea[@name='P3434_COMMENT']").setValue(comment);
        return this;
    }

    public EventInvitationRequestPage pressSendButtonInFrame() {
        $x("//button[@value='Отправить']").click();
        return this;
    }

    public EventInvitationRequestPage checkApprovalStepResult(int approvalStepNumber) {
        $$x("//tr[@title='Выполненный шаг']/td[@class='td RESULT_NAME']").get(approvalStepNumber).shouldHave(Condition.text("Одобрить"));
        return this;
    }

    public EventInvitationRequestPage checkOperationCompletion() {
        $x("//div[@class='toast-message']").shouldHave(Condition.text("Операция выполнена."));
        return this;
    }

    public EventInvitationRequestPage checkApprovalFinalStatus(int approvalFinalStepNumber) {
        $$x("//tr[@title='Выполненный шаг']/td[@class='td STATUS_NAME']").get(approvalFinalStepNumber-1).shouldHave(Condition.text("Согласована"));
        return this;
    }

    public EventInvitationRequestPage switchToFrame() {
        switchTo().frame($(By.tagName("iframe")));
        return this;
    }

}
