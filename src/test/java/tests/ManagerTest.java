package tests;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

public class ManagerTest extends SharedData {

    @Test
    public void testMethod() {
        String firstName = "Cornel";
        String lastName = "Georgescu";
        String postCode = "060708";
        String nameValue = "Cornel Georgescu";
        String currencyValue = "Dollar";
        int accountNumber = 1016 ;
        int tableSize = 5;

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.interactWithBankManagerLoginElement();

        ManagerActionsPage managerActionsPage = new ManagerActionsPage(getDriver());

        managerActionsPage.validateCustomerListSize(tableSize);
        managerActionsPage.addCustomer(firstName, lastName, postCode);
        managerActionsPage.validateCustomerListSize(tableSize+1);
        managerActionsPage.openAccount(nameValue, currencyValue);
        managerActionsPage.validateNewCustomer(tableSize, firstName, lastName, postCode, accountNumber);
        managerActionsPage.deleteCustomer(firstName);
        managerActionsPage.validateCustomerListSize(tableSize);

        loginPage.interactWithHomeButton();
    }
}