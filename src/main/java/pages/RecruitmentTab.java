package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import data.Candidate;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RecruitmentTab {

    protected SelenideElement recruitmentTab = $(byText("Recruitment"));
    protected SelenideElement candidatesAddButton = $(By.id("btnAdd"));
    protected SelenideElement candidateFirstNameField = $(By.id("addCandidate_firstName"));
    protected SelenideElement candidateMiddleNameField = $(By.id("addCandidate_middleName"));
    protected SelenideElement candidateLastNameField = $(By.id("addCandidate_lastName"));
    protected SelenideElement candidateEmailField = $(By.id("addCandidate_email"));
    protected SelenideElement candidateContactNoField = $(By.id("addCandidate_contactNo"));
    protected SelenideElement jobVacancyField = $(By.id("addCandidate_vacancy"));
    protected SelenideElement resumeField = $(By.id("addCandidate_resume"));
    protected SelenideElement keyWordsField = $(By.id("addCandidate_keyWords"));
    protected SelenideElement commentField = $(By.id("addCandidate_comment"));
    protected SelenideElement keepDataCheckbox = $(By.id("addCandidate_consentToKeepData"));
    protected SelenideElement saveCandidateButton = $(By.id("btnSave"));


    @Step("Переход во вкладку Recruitment")
    public void selectRecruitmentTab(){
        recruitmentTab.click();
    }

    @Step("Нажатие на кнопку Add")
    public void clickAddButton(){
        candidatesAddButton.click();
    }

    @Step("Заполнение всех полей в форме Add Candidate")
    public void fillAllCandidateFields(Candidate candidate){
        candidateFirstNameField.val(candidate.getFirstName());
        candidateMiddleNameField.val(candidate.getMiddleName());
        candidateLastNameField.val(candidate.getLastName());
        candidateEmailField.val(candidate.getEmail());
        candidateContactNoField.val(candidate.getContactNo());
        jobVacancyField.selectOption(2);
        resumeField.uploadFromClasspath("resume.txt");
        keyWordsField.val(candidate.getKeyWords());
        commentField.val(candidate.getComment());
        keepDataCheckbox.click();
    }

    @Step("Нажатие на кнопку save")
    public void clickSaveCandidate(){
        saveCandidateButton.click();
    }

    @Step("Проверка наличия созданного кандидата")
    public void checkCreationCandidate(Candidate candidate){
        $(byXpath("//td[contains(text(), 'added " + candidate.getFirstName()+" "
                + candidate.getMiddleName()+" " +candidate.getLastName()+"')]"))
                .should(Condition.exist);
    }
}
