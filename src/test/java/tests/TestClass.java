package tests;

import data.User;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClass extends BeforeAfterEach {
    LoginPage loginPage = new LoginPage();
    User user = new User();
    WelcomeUserElement welcomeUserElement = new WelcomeUserElement();
    AdminTab adminTab = new AdminTab();
    RecruitmentTab recruitmentTab = new RecruitmentTab();
    LeaveTab leaveTab = new LeaveTab();
    DashboardTab dashboardTab = new DashboardTab();
    PIMTab pimTab = new PIMTab();


    @Order(1)
    @Test
    @Description("Тест Логин на сайте")
    @Feature("Логин")
    @Severity(SeverityLevel.BLOCKER)
    @Story(value = "Пользователь логинится на сайте")
    public void loginTest() {
        loginPage.openLoginPageAndLogin(user);
        welcomeUserElement.welcomeIcon.should(exist);
        Assertions.assertEquals(adminTab.mainPageURL, url(), "The incorrect page is open or invalid title is specified");
    }

    @Order(2)
    @Test
    @Flaky
    @Description("Тест добавление пользователя для существующего сотрудника, позитивный тест")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("добавление пользователя в систему")
    @Story(value = "Сотрудник добавляет пользователя")
    public void addUserTest()  {
        loginPage.openLoginPageAndLogin(user);
        adminTab.selectAdminTab();
        adminTab.addUserHeading.shouldBe(visible);
        adminTab.clickAddButton();
        adminTab.fillAllFields(user);
        adminTab.clickSaveButton();
        adminTab.checkUserExisting(user);
    }

    @Order(3)
    @Test
    @Description("Тест удаление пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Удаление пользователя")
    @Story(value = "Сотрудник удаляет пользователя")
    public void deleteUserTest(){
        loginPage.openLoginPageAndLogin(user);

        adminTab.selectAdminTab();
        adminTab.addUserHeading.shouldBe(visible);
        adminTab.checkUserExisting(user);
        adminTab.clickUserCheckBox(user);
        adminTab.clickDeleteUserButton();
        adminTab.confirmationRequiredOKButton.shouldBe(visible).click();
        adminTab.checkDeleting(user);
    }

    @Order(4)
    @ParameterizedTest
    @CsvFileSource(resources = "/jobTitle.csv")
    @Description("Тест добавление трех jobTitle, затем их удаление")
    @Severity(SeverityLevel.NORMAL)
    @Feature("добавление и удаление jobTitle")
    public void addTreeJobTitleThenDeleteTest(String jobTitle, String jobDescription, String jobNote) {
        loginPage.openLoginPageAndLogin(user);
        adminTab.getJobTitlePage();
        adminTab.fillAllFieldsForAddingJobTitle(jobTitle,jobDescription, jobNote);
        adminTab.clickSaveButton();
        adminTab.checkJobTitleIsExists(jobTitle);
        adminTab.deleteJobTitle(jobTitle);
        adminTab.checkJobTitleIsNotExists(jobTitle);
   }

    @Order(5)
    @Test
    @Description("Тест добавление кандидата")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Добавление кандидата")
    @Story(value = "Сотрудник добавляет кандидата")
    public void addCandidateTest(){
        loginPage.openLoginPageAndLogin(user);
        recruitmentTab.selectRecruitmentTab();
        recruitmentTab.clickAddButton();
        recruitmentTab.fillAllCandidateFields();
        recruitmentTab.saveCandidate();
        recruitmentTab.checkCreationCandidate();
    }

    @Order(6)
    @Test
    @Flaky
    @Description("Тест назначение отпуска сотруднику")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Назначение отпуска")
    @Story(value = "Сотрудник добавляет заявку на отпуск")
    public void assignLeaveTest() {
        loginPage.openLoginPageAndLogin(user);
        leaveTab.selectLeaveTab();
        leaveTab.selectAssignLeaveTab();
        leaveTab.fillAllFieldsAssignLeave(user);
        leaveTab.clickAssignButton();
        leaveTab.confirmLeaveButton();
        leaveTab.selectLeaveListTab();
        leaveTab.checkAssignInLeaveList(user);
    }

    @Order(7)
    @Test
    @Description("Тест проверка наличия элементов во вкладке Dashboard")
    @Severity(SeverityLevel.NORMAL)
    public void checkDashboardTest(){
        loginPage.openLoginPageAndLogin(user);
        dashboardTab.checkElementsOnDashboard();
    }

    @Order(8)
    @Test
    @Description("Тест выход из системы")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Выход из системы")
    @Story(value = "Пользователь выходит из системы")
    public void loginOutTest(){
        loginPage.openLoginPageAndLogin(user);
        welcomeUserElement.signOut();
    }

    @Order(9)
    @Test
    @Description("Тест добавление пользователя для несуществующего сотрудника, негативный тест")
    @Severity(SeverityLevel.NORMAL)
    @Feature("добавление пользователя в систему")
    public void addUserWithInvalidEmployeeTest() {
        loginPage.openLoginPageAndLogin(user);
        adminTab.selectAdminTab();
        adminTab.addUserHeading.shouldBe(visible);
        adminTab.users.findBy(text(user.getInvalidEmployeeName())).shouldNot(exist);
        adminTab.clickAddButton();
        adminTab.invalidFillAllFields(user);
        adminTab.clickSaveButton();
        adminTab.errorMessage.should(exist);
    }

    @Order(10)
    @Test
    @Description("Тест проверка наличия элементов в разделе Personal details во вкладке PIM")
    @Severity(SeverityLevel.MINOR)
    public void personalDetailsTest() {
        loginPage.openLoginPageAndLogin(user);

        pimTab.getPIMTab();
        pimTab.selectSales();
        pimTab.chooseSalesEmployee();
        pimTab.checkAllPersonalDetails();
    }

    @Disabled ("Включить,если тест addUserTest() провалился")
    @Order(11)
    @Test
    @Description("Тест добавление пользователя для сотрудника, взятого из таблицы пользователей")
    @Severity(SeverityLevel.NORMAL)
    @Feature("добавление пользователя в систему")
    @Story(value = "Сотрудник добавляет пользователя для сотрудника, взятого из таблицы пользователей")
    public void addUserWithEmployeeFromUserListTest()  {
        loginPage.openLoginPageAndLogin(user);
        adminTab.selectAdminTab();
        adminTab.addUserHeading.shouldBe(visible);
        String employee = adminTab.getEmployeeFromUserList();
        adminTab.clickAddButton();
        adminTab.fillAllFieldsWithKnownEmployees(user, employee);
        adminTab.clickSaveButton();
        adminTab.checkUserExisting(user);
    }
}
