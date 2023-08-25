package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.dataTest.DataHelp;

import static com.codeborne.selenide.Selenide.$;

public class TransactionPage {
    private SelenideElement amount = $("[data-test-id='amount'] input");
    private SelenideElement card = $("[data-test-id='from'] input");
    private SelenideElement actionTransfer = $("[data-test-id='action-transfer']");

    public TransactionPage() {
        amount.shouldBe(Condition.visible);
    }

    public DashBoardPage setInfoTransactionSecondCardForCucumber(String sum, String numCard) {
        amount.setValue(sum);
        card.setValue(numCard);
        actionTransfer.click();
        return new DashBoardPage();
    }
}
