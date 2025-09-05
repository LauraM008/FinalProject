package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPage {
    public WebDriver driver;
    public ElementHelper elementHelper;
    public AlertHelper alertHelper;

    public InitialPage( WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@ng-click='home()']")
    private WebElement homeButtonElement;
    @FindBy(xpath = "//button[@ng-click='byebye()']")
    private WebElement logoutButtonElement;

    public void interactWithHomeButton(){
        homeButtonElement.click();
        LoggerUtility.infoLog("The user clicks on Home button");
    }

    public void interactWithLogoutButton(){
        logoutButtonElement.click();
        LoggerUtility.infoLog("The user clicks on Logout button");
    }

    public WebElement getHomeButtonElement() {
        return homeButtonElement;
    }

    public WebElement getLogoutButtonElement() {
        return logoutButtonElement;
    }
}