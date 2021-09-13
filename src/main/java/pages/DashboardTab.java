package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DashboardTab {

    protected SelenideElement dashboardHeader = $(byXpath("//b[text() = 'Dashboard']"));
    protected SelenideElement quickLaunchHeader = $(byXpath("//legend[text() = 'Quick Launch']"));
    protected SelenideElement assignLeaveHeader = $(byXpath("//span[text() = 'Assign Leave']"));
    protected SelenideElement leaveListHeader = $(byXpath("//span[text() = 'Leave List']"));
    protected SelenideElement timeSheetsHeader = $(byXpath("//span[text() = 'Timesheets']"));
    protected SelenideElement applyLeaveHeader = $(byXpath("//span[text() = 'Apply Leave']"));
    protected SelenideElement myLeaveHeader = $(byXpath("//span[text() = 'My Leave']"));
    protected SelenideElement myTimesheetHeader = $(byXpath("//span[text() = 'My Timesheet']"));
    protected SelenideElement employeeDistributionHeader = $(byXpath("//legend[text() = 'Employee Distribution by Subunit']"));
    protected SelenideElement legendHeader = $(byXpath("//legend[text() = 'Legend']"));
    protected SelenideElement pendingLeaveRequestsHeader = $(byXpath("//legend[text() = 'Pending Leave Requests']"));
    protected SelenideElement threeMonthTitle = $(byXpath("//span[text() = '3 month(s)']"));
    protected SelenideElement totalTitle = $(byXpath("//td[contains(text(), 'Total')]"));

    @Step("Проверка наличия всех элементов во вкладке Dashboard")
    public void checkElementsOnDashboard(){
        dashboardHeader.should(Condition.exist);
        quickLaunchHeader.should(Condition.exist);
        assignLeaveHeader.should(Condition.exist);
        leaveListHeader.should(Condition.exist);
        timeSheetsHeader.should(Condition.exist);
        applyLeaveHeader.should(Condition.exist);
        myLeaveHeader.should(Condition.exist);
        myTimesheetHeader.should(Condition.exist);
        employeeDistributionHeader.should(Condition.exist);
        legendHeader.should(Condition.exist);
        pendingLeaveRequestsHeader.should(Condition.exist);
        threeMonthTitle.should(Condition.exist);
        totalTitle.should(Condition.exist);
    }
}
