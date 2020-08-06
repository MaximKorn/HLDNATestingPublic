package Steps;

import Pages.ErrorPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class ErrorStep {
    private ErrorPage errorPage;

    public ErrorStep()
    {
        errorPage = page(ErrorPage.class);
    }

    public String checkPageForErrors()
    {
        boolean correct = errorPage.checkIfPageCorrect();
        boolean error1 = errorPage.checkIfPageUnavailable();
        boolean error2 = errorPage.checkIfSQLError();
        boolean error3 = errorPage.checkIfErrorOnStart();
        return error1 ? "Unavailable page" : error2 ? "Failed to parse SQL query" :
               error3 ? "Error on start" : correct ? "Correct" : "Other";
    }
}
