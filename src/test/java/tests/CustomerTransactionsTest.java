package tests;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

public class CustomerTransactionsTest extends SharedData {

    @Test
    public void testMethod() {

        String customerNameValue = "Ron Weasly";
        int depositAmount = 100;
        int withdrawAmount = 50;

        TransactionsPage transactionsPage = new TransactionsPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        accountPage.loginCustomer(customerNameValue);

        accountPage.interactWithDepositButton();
        accountPage.submitDepositAmount(depositAmount);

        accountPage.interactWithTransactionButton();
        transactionsPage.validateTransactionListSize();

        transactionsPage.interactWithBackElement();

        accountPage.interactWithWithdrawlButton();
        accountPage.submitWithdrawlAmount(withdrawAmount);

        accountPage.interactWithTransactionButton();
        transactionsPage.validateTransactionListSizeAndValues(accountPage.getTransactionAmountColumn(), accountPage.getTransactionTypeColumn());

        transactionsPage.interactWithResetElement();
    }
}