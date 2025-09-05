package helperMethods;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {
    private WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitAlert();
        Alert alert = driver.switchTo().alert();
        LoggerUtility.infoLog("The user switches to alert");
        alert.accept();
        LoggerUtility.infoLog("The user accepts the alert");
    }
}