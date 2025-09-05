package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class EdgeBrowser implements Browser {
    private WebDriver driver;
    private EdgeOptions edgeOptions;

    @Override
    public void openBrowser(){
        configureBrowser();
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.startTest(this.getClass().getSimpleName());
    }

    @Override
    public void configureBrowser(){
        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("window-size=1920,1080");
        edgeOptions.addArguments("--disable-gpu");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-extensions");
        //edgeOptions.addArguments("--headless=new");
        edgeOptions.addArguments("--incognito");
    }

    public WebDriver getDriver(){
        return driver;
    }
}
