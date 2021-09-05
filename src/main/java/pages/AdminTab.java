package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class AdminTab {


    public String mainPageURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
    public SelenideElement adminTab = $(byText("Admin"));
    public SelenideElement addButton = $(By.id("btnAdd"));
    public SelenideElement deleteUserButton = $(By.id("btnDelete"));

    public SelenideElement addUserHeading = $(byText("System Users"));
    public SelenideElement userRoleField = $(By.id("systemUser_userType"));
    public SelenideElement employeeNameField = $(By.id("systemUser_employeeName_empName"));
    public SelenideElement userNameField = $(By.id("systemUser_userName"));
    public SelenideElement statusField = $(By.id("systemUser_status"));
    public SelenideElement passwordField = $(By.id("systemUser_password"));
    public SelenideElement confirmPasswordField = $(By.id("systemUser_confirmPassword"));
    public SelenideElement saveButton = $(By.id("btnSave"));
    public ElementsCollection employees = $$(byXpath("//tr[@class = 'odd']//td[4]"));

    public ElementsCollection users = $$ ("a[href^='saveSystemUser']");
    public SelenideElement user = $(byText("Admin"));
    public SelenideElement jobTab = $(By.id("menu_admin_Job"));
    public SelenideElement jobTitleLink = $(byText("Job Titles"));
    public SelenideElement jobTitleAddButton = $(By.id("btnAdd"));
    public SelenideElement jobTitleField = $(By.id("jobTitle_jobTitle"));
    public SelenideElement jobDescriptionField = $(By.id("jobTitle_jobDescription"));
    public SelenideElement jobSpecificationField = $(By.id("jobTitle_jobSpec"));
    public SelenideElement jobNoteField = $(By.id("jobTitle_note"));
    public ElementsCollection jobTitles = $$ ("a[href^='https://opensource-demo.orangehrmlive.com/index.php/admin/saveJobTitle']");
    public SelenideElement deleteJobTitleButton = $(By.id("btnDelete"));
    public SelenideElement confirmationRequiredOKButton = $(By.id("dialogDeleteBtn"));
    public SelenideElement errorMessage = $(byText("Employee does not exist"));



    @Step("Открытие вкладки Admin")
    public void selectAdminTab(){
        adminTab.click();
    }

    @Step("Нажатие на кнопку Add")
    public void clickAddButton(){
        addButton.click();
    }

    @Step("Заполнение всех полей в форме Add user")
    public void fillAllFields(User user){
        userRoleField.should(Condition.exist).selectOption(1);
        employeeNameField.should(Condition.exist).val(user.getEmployeeName());
        userNameField.should(Condition.exist).val(user.getAdminAddUserName());
        statusField.should(Condition.exist).selectOption(0);
        passwordField.should(Condition.exist).val(user.getAdminAddUserPassword());
        confirmPasswordField.should(Condition.exist).val(user.getAdminAddUserPassword());
    }

    @Step("Взятие employeeName из списка пользователей")
    public String getEmployeeFromUserList(){
        return employees.get(0).getText();
    }

    @Step("Заполнение всех полей в форме Add user, где employeeName взят из списка пользователей")
    public void fillAllFieldsWithKnownEmployees(User user, String employee){
        userRoleField.should(Condition.exist).selectOption(1);
        employeeNameField.should(Condition.exist).val(employee);
        userNameField.should(Condition.exist).val(user.getAdminAddUserName());
        statusField.should(Condition.exist).selectOption(0);
        passwordField.should(Condition.exist).val(user.getAdminAddUserPassword());
        confirmPasswordField.should(Condition.exist).val(user.getAdminAddUserPassword());
    }

    @Step("Заполнение всех полей в форме Add user, где employeeName невалидный")
    public void invalidFillAllFields(User user){
        userRoleField.should(Condition.exist).selectOption(1);
        employeeNameField.should(Condition.exist).val(user.getInvalidEmployeeName());
        users.findBy(text(user.getInvalidEmployeeName())).shouldNot(exist);
        userNameField.should(Condition.exist).val(user.getAdminAddUserName());
        statusField.should(Condition.exist).selectOption(0);
        passwordField.should(Condition.exist).val(user.getAdminAddUserPassword());
        confirmPasswordField.should(Condition.exist).val(user.getAdminAddUserPassword());
    }

   @Step("Проверка наличия пользователя в списке пользователей")
    public void checkUserExisting(User user) {
        $(byXpath("//a[text()='"+user.getAdminAddUserName()+"']")).should(Condition.exist);
    }

    @Step("Переход на страницу добавления jobTitle")
    public void getJobTitlePage(){
        selectAdminTab();
        jobTab.click();
        jobTitleLink.click();
        jobTitleAddButton.click();
    }

    @Step("Заполнение всех полей в форме Add Job Title")
    public void fillAllFieldsForAddingJobTitle(String jobTitle, String jobDescription, String jobNote){
        jobTitleField.val(jobTitle);
        jobDescriptionField.val(jobDescription);
        jobSpecificationField.uploadFromClasspath("picture.jpg");
        jobNoteField.val(jobNote);
    }
    @Step("Выбор чекбокса добавленного JobTitle")
    public void clickCheckBox(String jobTitle){
        $(byXpath("//a[text()='"+jobTitle+"']/../..//input[@type='checkbox']")).click();
    }

    @Step("Нажатие на кнопку Save")
    public void clickSaveButton(){
        saveButton.click();
    }

    @Step("Выбор чекбокса добавленного пользователя")
    public void clickUserCheckBox(User user){
        $(byXpath("//a[text()='"+user.getAdminAddUserName()+"']/../..//input[@type='checkbox']")).click();
    }

    @Step("Нажатие на кнопку Delete")
    public void clickDeleteUserButton(){
        deleteUserButton.click();
    }

    @Step("Проверка отсутствия пользователя в списке пользователей")
    public void checkDeleting(User user) {
        $(byXpath("//a[text()='"+user.getAdminAddUserName()+"']")).shouldNot(Condition.exist);
    }

    @Step("Удаление JobTitle")
    public void deleteJobTitle(String jobTitle) {
        clickCheckBox(jobTitle);
        deleteJobTitleButton.click();
        confirmationRequiredOKButton.shouldBe(visible).click();
    }
    @Step("Проверка наличия созданного JobTitle")
    public void checkJobTitleIsExists(String jobTitle) {
        jobTitles.findBy(exactText(jobTitle)).should(exist);
    }

    @Step("Проверка удаления созданного JobTitle")
    public void checkJobTitleIsNotExists(String jobTitle) {
        jobTitles.findBy(exactText(jobTitle)).shouldNot(exist);
    }
}
