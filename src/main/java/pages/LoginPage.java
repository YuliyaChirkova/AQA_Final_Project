package pages;

import com.codeborne.selenide.SelenideElement;
import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public SelenideElement userNameField = $(By.id("txtUsername"));
    public SelenideElement passwordField = $(By.id("txtPassword"));
    public SelenideElement loginButton = $(By.id("btnLogin"));

    @Step("Открытие страницы логина")
    public void openLoginPage() {
        open("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }
    @Step("Введение логина и пароля и вход на сайт")
    public void login(User user){
        userNameField.val(user.getUserName());
        passwordField.val(user.getPassword());
        loginButton.click();
    }
    @Step("Открытие страницы логина и вход на сайт")
    public void openLoginPageAndLogin(User user) {
        open("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        userNameField.val(user.getUserName());
        passwordField.val(user.getPassword());
        loginButton.click();
    }
}
