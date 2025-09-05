package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AccountPage extends InitialPage{

    private int balance;
    private static int transactionNumber = 0;
    private List<Integer> transactionAmountColumn = new ArrayList<>();
    private List<String> transactionTypeColumn = new ArrayList<>();

    private LoginPage loginPage;
    private CustomerPage customerPage;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//span[@class='fontBig ng-binding']")
    private WebElement customerNameTextElement;
    @FindBy(id = "accountSelect")
    private WebElement selectAccountNumberElement;
    @FindBy(xpath = "(//div[@class='center']//strong)[1]")
    private WebElement displayedAccountNumberElement;
    @FindBy(xpath = "(//div[@class='center']//strong)[2]")
    private WebElement balanceElement;
    @FindBy(xpath = "(//div[@class='center']//strong)[3]")
    private WebElement currencyElement;

    @FindBy(css = "button[ng-class='btnClass1']")
    private WebElement transactionsButton;
    @FindBy(css = "button[ng-class='btnClass2']")
    private WebElement depositButton;
    @FindBy(css = "button[ng-class='btnClass3']")
    private WebElement withdrawlButton;

    @FindBy(css="input[ng-model='amount']")
    private WebElement amountElement;
    @FindBy(xpath="//button[text()='Deposit']")
    private WebElement submitDepositElement;
    @FindBy(css="span[class='error ng-binding']")
    private WebElement successfulDepositWithdrawlMessageElement;
    @FindBy(xpath="//button[text()='Withdraw']")
    private WebElement submitWithdrawElement;

    public void interactWithTransactionButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        elementHelper.ckickJSElement(transactionsButton);
        LoggerUtility.infoLog("The user clicks on Transactions button");
    }

    public void interactWithDepositButton(){
        elementHelper.clickElement(depositButton);
        elementHelper.waitVisibleElement(submitDepositElement);
        LoggerUtility.infoLog("The user clicks on Deposit button");
    }

    public void interactWithWithdrawlButton(){
        elementHelper.clickElement(withdrawlButton);
        elementHelper.waitVisibleElement(submitWithdrawElement);
        LoggerUtility.infoLog("The user clicks on Withdrawl button");

    }

    public void submitDepositAmount(int value){
        elementHelper.clickElement(amountElement);
        LoggerUtility.infoLog("The user clicks on amount element");
        elementHelper.fillElement(amountElement, value);
        LoggerUtility.infoLog("The user introduces the amount to be deposited: " + value);
        elementHelper.clickElement(submitDepositElement);
        LoggerUtility.infoLog("The user clicks on Submit Deposit Amount");
        balance = balance + value;
        LoggerUtility.infoLog("The new balance is: " + Integer.parseInt(balanceElement.getText()));
        transactionNumber++;
        LoggerUtility.infoLog("Transaction number: " +transactionNumber);
        transactionAmountColumn.add(value);
        LoggerUtility.infoLog("The value: " + value + " was added to transactionAmountColumn list");
        transactionTypeColumn.add("Credit");
        LoggerUtility.infoLog("The value Credit was added to transactionTypeColumn list");
    }

    public void submitWithdrawlAmount(int value){
        elementHelper.clickElement(amountElement);
        LoggerUtility.infoLog("The user clicks on amount element");
        elementHelper.fillElement(amountElement, value);
        LoggerUtility.infoLog("The user introduces the amount to be withdrawn: " + value);
        elementHelper.clickElement(submitWithdrawElement);
        LoggerUtility.infoLog("The user clicks on Submit Withdrawal Amount");
        balance = balance - value;
        LoggerUtility.infoLog("The new balance is: " + Integer.parseInt(balanceElement.getText()));
        transactionNumber++;
        LoggerUtility.infoLog("Transaction number: " +transactionNumber);
        transactionAmountColumn.add(value);
        LoggerUtility.infoLog("The value: " + value + " was added to transactionAmountColumn list");
        transactionTypeColumn.add("Debit");
        LoggerUtility.infoLog("The value Debit was added to transactionTypeColumn list");
    }

    public void loginCustomer(String customerNameValue){
        loginPage = new LoginPage(driver);
        loginPage.interactWithCustomerLoginElement();
        customerPage = new CustomerPage(driver);
        customerPage.loginCustomer(customerNameValue);
        balance = Integer.parseInt(balanceElement.getText());
    }

    public static int getTransactionNumber() {
        return transactionNumber;
    }

    public List<Integer> getTransactionAmountColumn() {
        return transactionAmountColumn;
    }

    public List<String> getTransactionTypeColumn() {
        return transactionTypeColumn;
    }
}