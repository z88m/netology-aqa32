package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import ru.netology.testUtils.DataHelper;

import static com.codeborne.selenide.Selenide.$;

@Value
public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}