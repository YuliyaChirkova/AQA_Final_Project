package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
