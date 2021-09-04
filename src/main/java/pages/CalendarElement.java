package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CalendarElement {
    protected SelenideElement calendarPic = $(".ui-datepicker-trigger");
    protected SelenideElement selectMonth = $(".ui-datepicker-month");
    protected SelenideElement selectYear = $(".ui-datepicker-year");
    protected String date="23";
    protected SelenideElement selectDay = $(byXpath("//td[@data-handler='selectDay']/a[text()='"+ date +"']"));
    protected String month="Nov";
    protected String year="2021";


    public void getDate(){
        calendarPic.click();
        selectMonth.selectOptionContainingText(month);
        selectYear.selectOptionContainingText(year);
        selectDay.click();





    }
}
