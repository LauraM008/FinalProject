package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends InitialPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//strong[text()='XYZ Bank']")
    private WebElement xyzBankElement;
    @FindBy(xpath = "//button[@ng-click='customer()']")
    private WebElement customerLoginElement;
    @FindBy(xpath = "//button[@ng-click='manager()']")
    private WebElement managerLoginElement;

    public void interactWithCustomerLoginElement(){
        customerLoginElement.click();
        LoggerUtility.infoLog("The user clicks on Customer Login");
    }

    public void interactWithBankManagerLoginElement(){
        managerLoginElement.click();
        LoggerUtility.infoLog("The user clicks on Bank Manager Login");
    }

    public void validateTextOfAllElements(String expectedTitleText, String expectedHomeButtonText, String expectedCustomerButtonText, String expectedManagerButtonText){
        elementHelper.validateElementEqualsText(xyzBankElement, expectedTitleText);
        LoggerUtility.infoLog("The user validates title: " + xyzBankElement.getText());
        elementHelper.validateElementEqualsText(getHomeButtonElement(),expectedHomeButtonText);
        LoggerUtility.infoLog("The user validates home button text: " + getHomeButtonElement().getText());
        elementHelper.validateElementEqualsText(customerLoginElement, expectedCustomerButtonText);
        LoggerUtility.infoLog("The user validates Customer Login text");
        elementHelper.validateElementEqualsText(managerLoginElement, expectedManagerButtonText);
        LoggerUtility.infoLog("The user validates Bank Manager Login text");
    }
}