package Steps;

import Pages.BasePage;
import Pages.LoginPage;
import Pages.RequestsListPage;

import static com.codeborne.selenide.Selenide.page;


public class BaseStep {
    private BasePage basePage;

    public BaseStep(BasePage basePage1)
    {
        basePage = basePage1;
    }

    public RequestsListPage goToRequestListPage()
    {
        return basePage
                .pressComplianceButton()
                .pressRequestsButton();
    }

    public LoginPage logout()
    {
        return basePage.pressLogoutButton();
    }
}
