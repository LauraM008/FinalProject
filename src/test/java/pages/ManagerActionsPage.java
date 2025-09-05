package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageType.PageType;

import java.util.List;

public class ManagerActionsPage  extends InitialPage{

    private final ManagerAddCustomerPage managerAddCustomerPage;
    private final ManagerOpenAccountPage managerOpenAccountPage;
    private final ManagerCustomersListPage managerCustomersPage;

    public ManagerActionsPage(WebDriver driver) {
        super(driver);
        this.managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        this.managerOpenAccountPage = new ManagerOpenAccountPage(driver);
        this.managerCustomersPage = new ManagerCustomersListPage(driver);
    }

    @FindBy(css = ".center button")
    private List<WebElement> managerButtons;

    public void addCustomer(String firstName, String lastName, String postCode){
        interactWithManagerAction(PageType.AddCustomer);
        managerAddCustomerPage.addCustomer(firstName, lastName, postCode);
    }

    public void openAccount(String customerNameValue, String currencyValue){
        interactWithManagerAction(PageType.OpenAccount);
        managerOpenAccountPage.openAccount(customerNameValue, currencyValue);
    }

    public void validateCustomerListSize(int expectedSize) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        interactWithManagerAction(PageType.Customers);
        managerCustomersPage.validateListSize(expectedSize);
    }

    public void validateNewCustomer(int listSize, String firstName, String lastName, String postCode, int accountNumber){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        interactWithManagerAction(PageType.Customers);
        managerCustomersPage.validateNewCustomerValues(listSize, firstName, lastName, postCode, accountNumber);
    }

    public void searchForCustomer(String customerName) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        interactWithManagerAction(PageType.Customers);
        managerCustomersPage.searchCustomer(customerName);
    }

    public void deleteCustomer(String customerName) {
        searchForCustomer(customerName);
        managerCustomersPage.removeCustomer(customerName);
    }

    public void interactWithManagerAction(String action) {
        WebElement targetButton;
        String logMessage;

        switch (action) {
            case PageType.AddCustomer:
                targetButton = elementHelper.getButtonByText("Add Customer", managerButtons);
                logMessage = "The user clicks on Add Customer";
                break;

            case PageType.OpenAccount:
                targetButton = elementHelper.getButtonByText("Open Account", managerButtons);
                logMessage = "The user clicks on Open Account";
                break;

            case PageType.Customers:
                targetButton = elementHelper.getButtonByText("Customers", managerButtons);
                logMessage = "The user clicks on Customers";
                break;

            default:
                throw new IllegalArgumentException("Invalid action: " + action);

        }
        elementHelper.waitVisibleElement(targetButton);
        elementHelper.clickElement(targetButton);
        LoggerUtility.infoLog(logMessage);
    }
}