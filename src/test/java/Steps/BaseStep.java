package Steps;

import Pages.BasePage;
import Pages.LoginPage;
import Pages.RequestsListPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;


public class BaseStep {
    private BasePage basePage;

    public BaseStep()
    {
        basePage = page(BasePage.class);
    }

    @Step("Перейти на страницу со списком заявок")
    public RequestsListPage goToRequestListPage()
    {
        return basePage
                .pressComplianceButton()
                .pressRequestsButton();
    }

    @Step("Выйти из системы")
    public LoginPage logout()
    {
        return basePage.pressLogoutButton();
    }
}
