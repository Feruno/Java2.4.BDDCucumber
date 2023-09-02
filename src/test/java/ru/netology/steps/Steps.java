package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.netology.page.DashBoardPage;
import ru.netology.page.LoginPageV1;
import ru.netology.page.TransactionPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.$;

public class Steps {
    private static LoginPageV1 loginPageV1;
    private static DashBoardPage dashBoardPage;
    private static VerificationPage verificationPage;
    private static TransactionPage transactionPage;



    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPageV1 = Selenide.open(url, LoginPageV1.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNamePass(String login, String pass) {
        verificationPage = loginPageV1.validLoginForCucumber(login, pass);
    }

    @И("пользователь вводит проверочный код 'из смс' {string}")
    public void validCode(String verifCode) {
        dashBoardPage = verificationPage.validVerifyForCucumber(verifCode);
    }

    @Тогда("происходит успешная авторизацияи пользоваетль попадает на страницу выбора карт")
    public void verifyDashboadrPage() {
        dashBoardPage.verifyDashboadrPage();
    }

    @И("выбирает пополнить {int} карту")
    public void choseCard(Integer numCountCard) {
        transactionPage = dashBoardPage.cardSelection(numCountCard);
    }

    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою первую карту с главной страницы")
    public void validTransactionInfo(String sum, String numCard) {
        transactionPage.setInfoTransactionSecondCardForCucumber(sum, numCard);
    }

    @Тогда("баланс его {int} карты из списка на главной странице должен стать {int} рублей.")
    public void validTransaction(Integer numCard, Integer expectedSumAfterTransaction) {
        int actual = dashBoardPage.getCardBalance(numCard);
        Assertions.assertEquals(expectedSumAfterTransaction, actual);
    }

}
