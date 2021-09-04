package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PIMTab {
    protected SelenideElement pimTab = $(byText("PIM"));
    protected SelenideElement subUnitField = $(By.id("empsearch_sub_unit"));
    protected SelenideElement pimSearchButton = $(By.id("searchBtn"));
    protected ElementsCollection sales = $$(byXpath("//a[contains(@href, '/index.php/pim/viewEmployee/')]"));
    protected SelenideElement personalDetailsHeader = $(byText("Personal Details"));

    protected SelenideElement firstNameField = $(By.id("personal_txtEmpFirstName"));
    protected SelenideElement middleNameField = $(By.id("personal_txtEmpMiddleName"));
    protected SelenideElement lastNameField = $(By.id("personal_txtEmpLastName"));
    protected SelenideElement employeeIDField = $(By.id("personal_txtEmployeeId"));
    protected SelenideElement driversLicensenNoField = $(By.id("personal_txtLicenNo"));
    protected SelenideElement ssnNoField = $(By.id("personal_txtNICNo"));
    protected SelenideElement otherIDField = $(By.id("personal_txtOtherID"));
    protected SelenideElement licExpDateField = $(By.id("personal_txtLicExpDate"));
    protected SelenideElement sinNoField = $(By.id("personal_txtSINNo"));
    protected SelenideElement optGenderMale = $(By.id("personal_optGender_1"));
    protected SelenideElement optGenderFemale = $(By.id("personal_optGender_2"));
    protected SelenideElement nationSelect = $(By.id("personal_cmbNation"));
    protected SelenideElement maritalStatusSelect = $(By.id("personal_cmbMarital"));
    protected SelenideElement birthDateField = $(By.id("personal_DOB"));
    protected SelenideElement nickNameField = $(By.id("personal_txtEmpNickName"));
    protected SelenideElement militaryServiceField = $(By.id("personal_txtMilitarySer"));
    protected SelenideElement smokerCheckbox = $(By.id("personal_chkSmokeFlag"));
    protected SelenideElement saveDetailsButton = $(By.id("btnSave"));

    @Step("Переход во вкладку PIM")
    public void getPIMTab(){
        pimTab.click();
    }

    @Step("Выбор sales в поле Sub Unit ")
    public void selectSales(){
        subUnitField.selectOption(7);
        pimSearchButton.click();
    }

    @Step("Выбор сотрудника Sale из списка")
    public void chooseSalesEmployee(){
        sales.get(0).click();
    }

    @Step("Проверка наличия всх полей в форме Personal details")
    public void checkAllPersonalDetails(){
        personalDetailsHeader.should(Condition.exist);
        firstNameField.should(Condition.exist);
        middleNameField.should(Condition.exist);
        lastNameField.should(Condition.exist);
        employeeIDField.should(Condition.exist);
        driversLicensenNoField.should(Condition.exist);
        ssnNoField.should(Condition.exist);
        otherIDField.should(Condition.exist);
        licExpDateField.should(Condition.exist);
        sinNoField.should(Condition.exist);
        optGenderMale.should(Condition.exist);
        optGenderFemale.should(Condition.exist);
        nationSelect.should(Condition.exist);
        maritalStatusSelect.should(Condition.exist);
        birthDateField.should(Condition.exist);
        nickNameField.should(Condition.exist);
        militaryServiceField.should(Condition.exist);
        smokerCheckbox.should(Condition.exist);
        saveDetailsButton.should(Condition.exist);
    }

}
