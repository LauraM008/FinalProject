package tests;

import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;
import sharedData.SharedData;

public class CustomerLoginTest extends SharedData {

    @Test
    public void testMethod(){
        String customerNameValue = "Albus Dumbledore";
        String expectedTitle = "XYZ Bank";
        String expectedHomeButtonText = "Home";
        String expectedCustomerButtonText = "Customer Login";
        String expectedManagerButtonText = "Bank Manager Login";

        LoginPage loginPage = new LoginPage(driver);
        CustomerPage customerPage = new CustomerPage(driver);

        loginPage.validateTextOfAllElements(expectedTitle,expectedHomeButtonText, expectedCustomerButtonText, expectedManagerButtonText);

        loginPage.interactWithCustomerLoginElement();
        customerPage.loginCustomer(customerNameValue);
        loginPage.interactWithLogoutButton();
        loginPage.interactWithHomeButton();
        loginPage.interactWithBankManagerLoginElement();
        loginPage.interactWithHomeButton();
    }
}