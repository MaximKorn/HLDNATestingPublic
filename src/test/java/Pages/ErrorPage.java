package Pages;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ErrorPage {

    public boolean checkIfPageCorrect() {
        return $$x("//div[@role='menubar']/ul/li").size() > 0;
    }

    public boolean checkIfPageUnavailable() {
        return $x("//h1[contains(text(),'Sorry, this page')]").exists();
    }

    public boolean checkIfSQLError() {
        return $x("//pre[contains(text(),'failed to parse SQL query')]").exists();
    }

    public boolean checkIfErrorOnStart() {
        return $x("//b[contains(text(),'S_BASE-003')]").exists();
    }
}
