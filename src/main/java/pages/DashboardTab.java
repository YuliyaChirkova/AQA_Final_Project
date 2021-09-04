package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DashboardTab {

    protected SelenideElement dashboardHeader = $(byText("Dashboard"));
    protected SelenideElement quickLaunchHeader = $(byText("Quick Launch"));
    protected SelenideElement assignLeaveHeader = $(byText("Assign Leave"));
    protected SelenideElement leaveListHeader = $(byText("Leave List"));
    protected SelenideElement timesheetsHeader = $(byText("Timesheets"));
    protected SelenideElement applyLeaveHeader = $(byText("Apply Leave"));
    protected SelenideElement myLeaveHeader = $(byText("My Leave"));
    protected SelenideElement myTimesheetHeader = $(byText("My Timesheet"));
    protected SelenideElement employeeDistributionHeader = $(byText("Employee Distribution by Subunit"));
    protected SelenideElement legendHeader = $(byText("Legend"));
    protected SelenideElement pendingLeaveRequestsHeader = $(byText("Pending Leave Requests"));
    protected SelenideElement threeMonthTitle = $(byText("3 month(s)"));
    protected SelenideElement totalTitle = $(byXpath("//td[contains(text(), 'Total')]"));

    @Step("Проверка наличия всех элементов во вкладке Dashboard")
    public void checkElementsOnDashboard(){
        dashboardHeader.should(Condition.exist);
        quickLaunchHeader.should(Condition.exist);
        assignLeaveHeader.should(Condition.exist);
        leaveListHeader.should(Condition.exist);
        timesheetsHeader.should(Condition.exist);
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
