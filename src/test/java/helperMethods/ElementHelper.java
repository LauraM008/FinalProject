package helperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class ElementHelper {
    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void validateElementEqualsText(WebElement element, String expectedText){
        Assert.assertEquals(element.getText(), expectedText, "Actual element text: " + element.getText() + " is different than " + expectedText);
    }

    public void validateElementEqualsIntValue(WebElement element, int expectedValue){
        Assert.assertEquals(Integer.parseInt(element.getText()), expectedValue, "Actual element value: " + Integer.parseInt(element.getText()) + " is different than " + expectedValue);
    }

    public void fillElement(WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void fillElement(WebElement element, int value){
        waitVisibleElement(element);
        element.sendKeys(String.valueOf(value));
    }

    public void pressElement(WebElement element, Keys value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void waitVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillPressElement(WebElement element, String value, Keys keyValue ){
        fillElement(element, value);
        pressElement(element, keyValue);
    }

    public void clickElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void ckickJSElement(WebElement element) {
        waitVisibleElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void validateListSize(List<WebElement> elementsList, int expectedSize) {
        waitVisibleList(elementsList);
        Assert.assertEquals(elementsList.size(), expectedSize, "Actual elements list size: " + elementsList.size() + " is different than " + expectedSize);
    }

    public void validateElementContainsText(WebElement element, String expectedText) {
        waitVisibleElement(element);
        Assert.assertTrue(element.getText().contains(expectedText), "Actual element text: " + element.getText() + " is different than " + expectedText);
    }

    public void waitVisibleList(List<WebElement> elementsList) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));

    }

    public WebElement getButtonByText(String text, List<WebElement> buttons) {
        for (WebElement button : buttons) {
            if (button.getText().trim().equalsIgnoreCase(text)) {
                return button;
            }
        }
        throw new NoSuchElementException("Button with text '" + text + "' not found.");
    }
}