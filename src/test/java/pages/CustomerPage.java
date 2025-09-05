package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends InitialPage {

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userSelect")
    private WebElement userSelectElement;
    @FindBy(xpath="//button[@class='btn btn-default']")
    private WebElement loginButtonElement;

    public void loginCustomer(String customerNameValue){
        clickCustomerName();
        selectCustomerName(customerNameValue);
        clickLoginElement();
    }

    public void clickCustomerName(){
        userSelectElement.click();
        LoggerUtility.infoLog("The user clicks on customer name");
    }

    public void selectCustomerName(String value){
        elementHelper.fillElement(userSelectElement, value );
        LoggerUtility.infoLog("The user enters the customer name");
        elementHelper.pressElement(userSelectElement, Keys.ENTER);
        LoggerUtility.infoLog("The user clicks Enter");
    }

    public void clickLoginElement(){
        loginButtonElement.click();
        LoggerUtility.infoLog("The user clicks on Login button");
    }

}