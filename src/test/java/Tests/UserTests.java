package Tests;

import Models.EventInvitationRequest;
import Models.User;
import Steps.*;
import Steps.LoginStep;
import Steps.BaseStep;

import static Models.EventInvitationRequest.createEventInvitationRequestFromData;
import static Models.User.createUserFromData;

import com.codeborne.selenide.Configuration;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.Console;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static Utils.UtilsCSV.*;
import static com.codeborne.selenide.Selenide.open;

public class UserTests extends BaseTest {
    CSVReader reader;
    ArrayList<String[]> userData = new ArrayList<>();
    ArrayList<String[]> requestData = new ArrayList<>();
    String[] csvCell;
    public User initiatorUserData;
    public User headOfDivisionUserData;
    public User headOfComplianceUserData;
    public EventInvitationRequest eventInvitationRequest;
    SimpleDateFormat dateFormat;
    Calendar calendar;
    String eventStartDate;
    String eventEndDate;
    String invitationResponseDeadline;

    public BaseStep baseStep;
    public LoginStep loginStep;
    public RequestListStep requestListStep;
    public EventInvitationRequestStep eventInvitationRequestStep;
    public EventInvitationRequestCreationStep eventInvitationRequestCreationStep;

    String commentApproval;

    @BeforeMethod(description = "Чтение данных из CSV-файлов. Открытие браузера")
    public void beforeMethod() throws IOException, CsvValidationException {

        dateFormat = new SimpleDateFormat("d.MM.yyyy");

        reader = readCSV(csvUserData);
        while ((csvCell = reader.readNext())!= null) {
            userData.add(csvCell);
        }

        reader = readCSV(csvRequestData);
        requestData.add(reader.readNext());
        reader.close();

        initiatorUserData = createUserFromData(userData.get(0));
        headOfDivisionUserData = createUserFromData(userData.get(1));
        headOfComplianceUserData = createUserFromData(userData.get(2));
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,3);
        invitationResponseDeadline = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.DATE,3);
        eventStartDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.DATE,3);
        eventEndDate = dateFormat.format(calendar.getTime());

        eventInvitationRequest = createEventInvitationRequestFromData(requestData.get(0), eventStartDate,
                eventEndDate, invitationResponseDeadline);

        commentApproval = "Тестовый одобрительный комментарий";

        Configuration.timeout = 8000;
        open(baseUrl);
        baseStep = new BaseStep();
        loginStep = new LoginStep();
        requestListStep = new RequestListStep();
        eventInvitationRequestStep = new EventInvitationRequestStep();
        eventInvitationRequestCreationStep = new EventInvitationRequestCreationStep();
    }

    @Description("Проверка создания и согласования заявки \"Приглашение на мероприятие\"")
    @Test
    public void requestCreationAndApprovalTest() {

        // Действия пользователя с ролью Initiator
        loginStep
                .login(initiatorUserData);
        baseStep
                .goToRequestListPage();
        requestListStep
                .addEventInvitationRequest();

        eventInvitationRequestCreationStep
                .fillInEventInvitationRequest(eventInvitationRequest);

        eventInvitationRequest.setRequestNumber(eventInvitationRequestCreationStep
                .rememberCreatedRequestNumber());

        eventInvitationRequestCreationStep
                .sendCreatedRequestToApproval(eventInvitationRequest.getCommentCreation());

        eventInvitationRequestStep
                .checkApprovalRequestFirstStepResult();
        baseStep
                .logout();

        // Действия пользователя с ролью Head of Division
        loginStep
                .login(headOfDivisionUserData);
        baseStep
                .goToRequestListPage();
        requestListStep
                .setPrimaryReportOption();
        requestListStep
                .searchRequestByNumber(eventInvitationRequest.getRequestNumber());
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
                .login(headOfComplianceUserData);
        requestListStep
                .setPrimaryReportOption();
        requestListStep
                .searchRequestByNumber(eventInvitationRequest.getRequestNumber());
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
