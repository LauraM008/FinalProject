package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerAddCustomerPage extends InitialPage {

    public ManagerAddCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[ng-model='fName']")
    private WebElement firstNameElement;
    @FindBy(css = "input[ng-model='lName']")
    private WebElement lastNameElement;
    @FindBy(css = "input[ng-model='postCd']")
    private WebElement postCodeElement;
    @FindBy(xpath = "//button[@class= 'btn btn-default']")
    private WebElement addCustomerButton;

    public void fillFirstName(String firstNameValue) {
        elementHelper.waitVisibleElement(firstNameElement);
        elementHelper.fillElement(firstNameElement, firstNameValue);
        LoggerUtility.infoLog("The user fills the first name with value: " + firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        elementHelper.fillElement(lastNameElement, lastNameValue);
        LoggerUtility.infoLog("The user fills the last name with value: " + lastNameValue);
    }

    public void fillPostCode(String postCodeValue) {
        elementHelper.fillElement(postCodeElement, postCodeValue);
        LoggerUtility.infoLog("The user fills the post code with value: " + postCodeValue);
    }

    public void submitCustomer() {
        elementHelper.clickElement(addCustomerButton);
        LoggerUtility.infoLog("The user clicks on Add Customer Button");
    }

    public void addCustomer(String firstName, String lastName, String postCode) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillPostCode(postCode);
        submitCustomer();
        alertHelper.acceptAlert();
    }
}

