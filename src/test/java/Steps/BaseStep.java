package Steps;

import Pages.BasePage;
import Pages.LoginPage;
import Pages.RequestsListPage;

import static com.codeborne.selenide.Selenide.page;

public class BaseStep {
    BasePage basePage;

    public BaseStep()
    {
        basePage = page(BasePage.class);
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
