package Utils;

import Steps.ErrorStep;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class CustomTestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
        if (result.getName()=="requestCreationAndApprovalTest")
        {
            ErrorStep errorStep = new ErrorStep();
            showPageStatus(errorStep.checkPageForErrors());
        }
    }

    @Attachment(value = "PageStatus")
    private String showPageStatus(String status)
    {
        return "Page status: " + status;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
