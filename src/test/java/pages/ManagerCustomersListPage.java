package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManagerCustomersListPage extends InitialPage{

    public ManagerCustomersListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="input[ng-model='searchCustomer']")
    private WebElement searchCustomerElement;
    @FindBy(css = "button[ng-click='deleteCust(cust)']")
    private WebElement deleteElement;
    @FindBy(xpath = "//tr[@class='ng-scope']")
    private List<WebElement> customersRowList;
    @FindBy(xpath="//span[@ng-repeat='account in cust.accountNo'][1]")
    private List<WebElement> customersAccountNumberCol;

    public void searchCustomer(String customer){
        elementHelper.clickElement(searchCustomerElement);
        searchCustomerElement.sendKeys(customer);
        LoggerUtility.infoLog("The user searches for customer name");
    }

    public void removeCustomer(String customer){
        elementHelper.clickElement(deleteElement);
        LoggerUtility.infoLog("The user removes the customer " + customer + " from the list");
        elementHelper.clickElement(searchCustomerElement);
        searchCustomerElement.clear();
        LoggerUtility.infoLog("The user removes the customer " + customer + " from the search box");
    }

    public void validateListSize(int expectedSize){
        elementHelper.waitVisibleList(customersRowList);
        elementHelper.validateListSize(customersRowList, expectedSize);
        LoggerUtility.infoLog("The user validates the list size: " + customersRowList.size());
    }

    public void validateNewCustomerValues(int listSize, String firstName, String lastName, String postCode, int accountNumber){
        elementHelper.validateElementContainsText(customersRowList.get(listSize), firstName);
        LoggerUtility.infoLog("The user validates first name: " + firstName);
        elementHelper.validateElementContainsText(customersRowList.get(listSize), lastName);
        LoggerUtility.infoLog("The user validates last name: " + lastName);
        elementHelper.validateElementContainsText(customersRowList.get(listSize), postCode);
        LoggerUtility.infoLog("The user validates post code: " + postCode);
        elementHelper.validateElementEqualsIntValue(customersAccountNumberCol.get(listSize), accountNumber);
        LoggerUtility.infoLog("The user validates account number: " + accountNumber);
    }
}