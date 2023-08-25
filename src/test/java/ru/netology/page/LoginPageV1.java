package ru.netology.page;

import ru.netology.dataTest.DataHelp;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageV1 {
    public VerificationPage validLoginForCucumber(String login, String pass) {
        $("[data-test-id=login] input").setValue(login);
        $("[data-test-id=password] input").setValue(pass);
        $("[data-test-id='action-login'] span").click();

        return new VerificationPage();
    }
}
