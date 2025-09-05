package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TransactionsPage extends InitialPage {

    public TransactionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[ng-click='back()']")
    private WebElement backElement;
    @FindBy(css = "button[ng-click='reset()']")
    private WebElement resetElement;

    //@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr")
    @FindBy(xpath = "//table[@class='table table-bordered table-striped']")
    List<WebElement> transactionsList;
    @FindBy(xpath = "//td[@class='ng-binding'][2]")
    List<WebElement> amountColumnElement;
    @FindBy(xpath = "//td[@class='ng-binding'][3]")
    List<WebElement> typeColumnElement;


    public void interactWithBackElement() {
        elementHelper.clickElement(backElement);
        LoggerUtility.infoLog("The user clicks on Back button");
    }

    public void interactWithResetElement() {
        elementHelper.waitVisibleElement(resetElement);
        elementHelper.clickElement(resetElement);
        LoggerUtility.infoLog("The user clicks on Reset button");
    }

    public void validateTransactionListSize() {
        elementHelper.waitVisibleList(transactionsList);
        elementHelper.validateListSize(transactionsList, AccountPage.getTransactionNumber());
        LoggerUtility.infoLog("The user validates transactions list size");
    }

    public void validateTransactionListAmount(List<Integer> amountColumn) {
        for (int index = 0; index < transactionsList.size(); index++) {
            elementHelper.validateElementEqualsIntValue(amountColumnElement.get(index), amountColumn.get(index));
        }
        LoggerUtility.infoLog("The user validates the Amount Column");
    }

    public void validateTransactionListType(List<String> typeColumn) {
        for (int index = 0; index < transactionsList.size(); index++) {
            elementHelper.validateElementEqualsText(typeColumnElement.get(index), typeColumn.get(index));
        }
        LoggerUtility.infoLog("The user validates the Type column");
    }

    public void validateTransactionListSizeAndValues(List<Integer> amountColumn, List<String> typeColumn){
        validateTransactionListSize();
        validateTransactionListAmount(amountColumn);
        validateTransactionListType(typeColumn);
    }
}