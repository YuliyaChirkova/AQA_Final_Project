package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LeaveTab {

    protected SelenideElement leaveTab = $(By.id("menu_leave_viewLeaveModule"));
    protected SelenideElement leaveListTab = $(By.id("menu_leave_viewLeaveList"));
    protected SelenideElement assignLeaveTab = $(By.id("menu_leave_assignLeave"));
    protected SelenideElement employeeNameField = $(".ac_input.inputFormatHint");
    protected SelenideElement leaveTypeField = $(By.id("assignleave_txtLeaveType"));
    protected SelenideElement leaveBalance = $(By.id("assignleave_leaveBalance"));
    protected SelenideElement fromDateField = $(By.id("assignleave_txtFromDate"));
    protected SelenideElement toDateField = $(By.id("assignleave_txtToDate"));
    protected SelenideElement partialDaysField = $(By.id("assignleave_partialDays"));
    protected SelenideElement commentField = $(By.id("assignleave_txtComment"));
    protected SelenideElement assignButton = $(By.id("assignBtn"));
    protected SelenideElement durationField = $(By.id("assignleave_firstDuration_duration"));
    protected SelenideElement ampmField = $(By.id("assignleave_firstDuration_ampm"));
    protected SelenideElement confirmLeaveButton = $(By.id("confirmOkButton"));

    protected SelenideElement fromDateLeaveListField = $(By.id("calFromDate"));
    protected SelenideElement toDateLeaveListField = $(By.id("calToDate"));
    protected SelenideElement allCheckBox = $(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck"));
    protected SelenideElement employeeLeaveList = $(By.id("leaveList_txtEmployee_empName"));
    protected SelenideElement searchButton = $(By.id("btnSearch"));

    @Step("Переход во вкладку Leave")
    public void clickLeaveTab(){
        leaveTab.click();
    }

    @Step("Переход по ссылке Assign Leave")
    public void clickAssignLeaveTab(){
        assignLeaveTab.click();
    }

    @Step("Переход по ссылке Leave List")
    public void clickLeaveListTab(){
        leaveListTab.click();
    }

    @Step("Проверка наличия запроса на отпуск в списке запросов")
    public void checkAssignInLeaveList(User user){
        fromDateLeaveListField.val(user.getFromDate());
        fromDateLeaveListField.pressEnter();
        toDateLeaveListField.val(user.getToDate());
        toDateLeaveListField.pressEnter();
        allCheckBox.click();
        employeeLeaveList.val(user.getEmployeeName());
        searchButton.click();
        $(byXpath("//a[text()='"+user.getEmployeeName()+"']")).should(Condition.exist);
    }

    @Step("Заполнение всех полей на странице Assign Leave")
    public void fillAllFieldsAssignLeave(User user){
        employeeNameField.should(Condition.exist).val(user.getEmployeeName());
        leaveTypeField.should(Condition.exist).selectOptionContainingText("CAN - Vacation");
        fromDateField.should(Condition.exist).val(user.getFromDate());
        toDateField.should(Condition.exist).val(user.getToDate());
        toDateField.should(Condition.exist).pressEnter();
        partialDaysField.should(Condition.exist).selectOptionContainingText("All Days");
        durationField.should(Condition.exist);
        ampmField.should(Condition.exist);
        commentField.should(Condition.exist).val("vacation");
    }

    @Step("Нажатие не акнопку Assign")
    public void clickAssignButton(){
        assignButton.click();
    }

    @Step("Подтверждение запроса на отпуск")
    public void clickLeaveButton(){
        confirmLeaveButton.click();
    }


}
