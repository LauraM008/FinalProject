package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerOpenAccountPage extends InitialPage{

    public ManagerOpenAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userSelect")
    private WebElement userSelectElement;
    @FindBy(id="currency")
    private WebElement currencyElement;
    @FindBy(xpath = "//button[@type='submit' and text()='Process']")
    private WebElement processButton;

    public void selectCustomerName(String value){
        elementHelper.waitVisibleElement(userSelectElement);
        userSelectElement.click();
        LoggerUtility.infoLog("The user clicks on Customer Name");
        elementHelper.fillElement(userSelectElement, value );
        elementHelper.pressElement(userSelectElement, Keys.ENTER);
        LoggerUtility.infoLog("The user selects the customer name");
    }

    public void selectCurrency(String value){
        elementHelper.waitVisibleElement(currencyElement);
        currencyElement.click();
        LoggerUtility.infoLog("The user clicks on Currency");
        elementHelper.fillElement(currencyElement, value );
        elementHelper.pressElement(currencyElement, Keys.ENTER);
        LoggerUtility.infoLog("The user selects the currency");
    }

    public void interactWithProcessButton(){
        elementHelper.clickElement(processButton);
        LoggerUtility.infoLog("The user clicks on Process button");
    }

    public void openAccount(String customerNameValue, String currencyValue){
        selectCustomerName(customerNameValue);
        selectCurrency(currencyValue);
        interactWithProcessButton();
        alertHelper.acceptAlert();
    }
}