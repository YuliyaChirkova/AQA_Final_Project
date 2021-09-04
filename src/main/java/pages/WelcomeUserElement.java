package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class WelcomeUserElement {
    public SelenideElement welcomeIcon = $(By.id("welcome"));
    public SelenideElement logOutSelect = $(byText("Logout"));

    @Step("Выход из аккаунта")
    public void signOut(){
        welcomeIcon.click();
        logOutSelect.shouldBe(Condition.visible).click();
    }
}
