package Tests;

import Pages.*;
import Steps.*;
import Steps.LoginStep;
import Steps.BaseStep;
import static Steps.LoginStep.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideDriver;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.javatuples.Pair;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static Utils.UtilsCSV.csvUserData;
import static Utils.UtilsCSV.readCSV;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class UserTests extends BaseTest {
    CSVReader reader;
    String[][] userData = new String[3][2];
    public Pair<String, String> initiatorUserData;
    public Pair<String, String> headOfDivisionUserData;
    public Pair<String, String> headOfComplianceUserData;
    SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");

    public BaseStep baseStep;
    public LoginStep loginStep;
    public RequestListStep requestListStep;
    public EventInvitationRequestStep eventInvitationRequestStep;
    public EventInvitationRequestCreationStep eventInvitationRequestCreationStep;

    String eventName, eventTheme, senderOrganization, inviterName,
            eventStartDate, eventEndDate, invitationResponseDeadline,
            eventProgram, country, city, address, commentCreation, commentApproval;

    @BeforeMethod
    public void beforeMethod() throws IOException, CsvValidationException {
//        baseStep = new BaseStep();
//        loginStep = new LoginStep();
//        requestListStep = new RequestListStep();
//        eventInvitationRequestStep = new EventInvitationRequestStep();
//        eventInvitationRequestCreationStep = new EventInvitationRequestCreationStep();

        reader = readCSV(csvUserData);
        for (int i = 0; i < 3; i++) {
            userData[i] = reader.readNext();
        }
        initiatorUserData = new Pair<>(userData[0][0], userData[0][1]);
        headOfDivisionUserData = new Pair<>(userData[1][0], userData[1][1]);
        headOfComplianceUserData = new Pair<>(userData[2][0], userData[2][1]);

        eventName = "Тестовое Мероприятие";
        eventTheme = "Тестовая Тема";
        senderOrganization = "ООО \"Медведь Абакан\"";
        inviterName = "Иванов Андрей Петрович";
        eventStartDate = dateFormat.format(Calendar.DATE + 7);
        eventEndDate = dateFormat.format(Calendar.DATE + 8);
        invitationResponseDeadline = dateFormat.format(Calendar.DATE + 3);
        eventProgram = "Тестовая программа мероприятия";
        country = "Россия";
        city = "Воронеж";
        address = "Московский проспект, 1";
        commentCreation = "Тестовый комментарий";
        commentApproval = "Тестовый одобрительный комментарий";

        Configuration.timeout = 8000;
    }

    @Test
    public void requestCreationAndApprovalTest() throws IOException, CsvValidationException {
//        reader = readCSV(csvUserData);
//        for (int i = 0; i < 3; i++) {
//            userData[i] = reader.readNext();
//        }
//        initiatorUserData = new Pair<>(userData[0][0], userData[0][1]);
//        headOfDivisionUserData = new Pair<>(userData[1][0], userData[1][1]);
//        headOfComplianceUserData = new Pair<>(userData[2][0], userData[2][1]);
//
//        eventName = "Тестовое Мероприятие";
//        eventTheme = "Тестовая Тема";
//        senderOrganization = "ООО \"Медведь Абакан\"";
//        inviterName = "Иванов Андрей Петрович";
//        eventStartDate = dateFormat.format(Calendar.DATE + 7);
//        eventEndDate = dateFormat.format(Calendar.DATE + 8);
//        invitationResponseDeadline = dateFormat.format(Calendar.DATE + 3);
//        eventProgram = "Тестовая программа мероприятия";
//        country = "Россия";
//        city = "Воронеж";
//        address = "Московский проспект, 1";
//        commentCreation = "Тестовый комментарий";
//        commentApproval = "Тестовый одобрительный комментарий";
//
//        Configuration.timeout = 8000;

       LoginPage loginPage = open(baseUrl, LoginPage.class);
       loginStep = new LoginStep(loginPage);

        // Действия пользователя с ролью Initiator
        BasePage basePage = loginStep
                .login(initiatorUserData.getValue0(), initiatorUserData.getValue1());
        baseStep = new BaseStep(basePage);
        RequestsListPage requestsListPage = baseStep
                .goToRequestListPage();
        requestListStep = new RequestListStep(requestsListPage);
        EventInvitationRequestCreationPage eventInvitationRequestCreationPage = requestListStep
                .addEventInvitationRequest();
        eventInvitationRequestCreationStep = new EventInvitationRequestCreationStep(eventInvitationRequestCreationPage);

        eventInvitationRequestCreationStep
                .fillInEventInvitationRequest(eventName, eventTheme, senderOrganization, inviterName,
                        eventStartDate, eventEndDate, invitationResponseDeadline,
                        eventProgram, country, city, address);

        String requestNumber = eventInvitationRequestCreationStep
                .rememberCreatedRequestNumber();

        EventInvitationRequestPage eventInvitationRequestPage = eventInvitationRequestCreationStep
                .sendCreatedRequestToApproval(commentCreation);

        eventInvitationRequestStep = new EventInvitationRequestStep(eventInvitationRequestPage);

        eventInvitationRequestStep
                .checkApprovalRequestFirstStepResult();
        baseStep
                .logout();

        // Действия пользователя с ролью Head of Division
        loginStep
                .login(headOfDivisionUserData.getValue0(), headOfDivisionUserData.getValue1());
        baseStep
                .goToRequestListPage();
        requestListStep
                .setPrimaryReportOption();
        requestListStep
                .searchRequestByNumber(requestNumber);
        requestListStep
                .chooseFoundRequest();
        eventInvitationRequestStep
                .approveEventInvitationRequest(commentApproval);
        eventInvitationRequestStep
                .checkApprovalRequestSecondStepResult();
        baseStep
                .logout();

        // Действия пользователя с ролью Head of Compliance
        loginStep
                .login(headOfComplianceUserData.getValue0(), headOfComplianceUserData.getValue1());
        requestListStep
                .setPrimaryReportOption();
        requestListStep
                .searchRequestByNumber(requestNumber);
        requestListStep
                .chooseFoundRequest();
        eventInvitationRequestStep
                .approveEventInvitationRequest(commentApproval);
        eventInvitationRequestStep
                .checkApprovalRequestThirdStepResult();
        eventInvitationRequestStep
                .checkApprovalRequestFinalStatus();
    }
}
