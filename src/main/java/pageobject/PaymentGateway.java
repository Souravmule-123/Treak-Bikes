package pageobject;

import objectmanager.FileReaderManager;
import objectmanager.WaitManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class PaymentGateway {
    private static final Logger log = LogManager.getLogger(TelecomProject.class);
    WebDriver driver;
    WaitManager waitManager;
    Actions actions;

    @FindBy(xpath = "//*[text()='Payment Gateway Project']")
    WebElement paymentGatewayProject;
    @FindBy(xpath = "//*[@name='quantity']")
    WebElement quantityValue;
    @FindBy(xpath = "//*[@class='button special']")
    WebElement buyNowOption;
    @FindBy(xpath = "//*[@class='6u 12u$(xsmall)']/font[2]")
    WebElement amountValue;
    @FindBy(xpath = "//*[@class='button special']")
    WebElement paysTab;
    @FindBy(xpath = "//*[@id='card_nmuber']")
    WebElement cardNumber;
    @FindBy(xpath = "//*[@id='month']")
    WebElement month;
    @FindBy(xpath = "//*[@id='year']")
    WebElement year;
    @FindBy(xpath = "//*[@id='cvv_code']")
    WebElement cvv;
    @FindBy(xpath = "//*[@class='alt access']/tbody/tr/td[2]/h3/strong")
    WebElement orderID;
    @FindBy(xpath = "//*[@class='table-wrapper']/h2")
    WebElement successfullMsgValidation;
    @FindBy(xpath = "//*[@id='nav']/a[3]")
    WebElement checkCreditCardLimit;
    @FindBy(xpath = "//*[@class='table-wrapper']/h4")
    WebElement creditCardBalanceStatement;
    @FindBy(xpath = "//*[@id='nav']/a[2]")
    WebElement generateCardNumberTab;
    @FindBy(xpath = "//*[@class='align-center']/h2")
    WebElement newCardGenerationMessage;


    public PaymentGateway(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitManager = new WaitManager(driver);
        actions = new Actions(driver);
    }

    public void selectTheValue() {
        Select select=new Select(quantityValue);
        select.selectByIndex(2);
    }

    public void clickOnBuyNowOption() {
        buyNowOption.click();
    }

    public void clickOnPaymentGatewayProject(String arg0) {
        paymentGatewayProject.click();
    }

    public void verifyAmount() {
        Assert.assertTrue(amountValue.isDisplayed(), "value is not displayed");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid yellow';", amountValue);
        System.out.println(amountValue.getText());
    }

    public void selectAllTheValue(String arg0, String arg1, String arg2, String arg3) {
        waitManager.applyExplicitWait(10).until(ExpectedConditions.elementToBeClickable(cardNumber));
        cardNumber.sendKeys(FileReaderManager.getInstance().getConfigReader().getCardNumber(arg0));
        waitManager.applyExplicitWait(15).until(ExpectedConditions.elementToBeClickable(month));
        month.sendKeys(FileReaderManager.getInstance().getConfigReader().getExpMonth(arg1));
        waitManager.applyExplicitWait(15).until(ExpectedConditions.elementToBeClickable(year));
        year.sendKeys(FileReaderManager.getInstance().getConfigReader().getExpiryYear(arg2));
        waitManager.applyExplicitWait(15).until(ExpectedConditions.elementToBeClickable(cvv));
        cvv.sendKeys(FileReaderManager.getInstance().getConfigReader().getCVVNumber(arg3));
    }
    public void clickOnPaysTab() {
        paysTab.click();
    }

    public void verifySuccessFullMsg() {
        Assert.assertTrue(orderID.isDisplayed(), "value is not displayed");
        Assert.assertTrue(successfullMsgValidation.isDisplayed(), "value is not displayed");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid yellow';", orderID);
        js.executeScript("arguments[0].style.border='10px solid yellow';", successfullMsgValidation);
        System.out.println(orderID.getText());
        System.out.println(successfullMsgValidation.getText());
    }

    public void clickOnCheckCreditCrdLimit() {
        checkCreditCardLimit.click();
    }

    public void enterCreditCardNumber(String argo) {
        waitManager.applyExplicitWait(10).until(ExpectedConditions.elementToBeClickable(cardNumber));
        cardNumber.sendKeys(FileReaderManager.getInstance().getConfigReader().getCardNumber(argo));
    }

    public void verifyCreditCardBalance() {
        Assert.assertTrue(creditCardBalanceStatement.isDisplayed(), "creditCardLimit is not displayed");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid yellow';", creditCardBalanceStatement);
    }

    public void clickOnGenerateCardNumber(String arg0) {
        generateCardNumberTab.click();
    }

    public void cardNewCreationMessage(String arg0) {
        String mainWindow=driver.getWindowHandle();
        Set<String> allWindow= driver.getWindowHandles();
        for (String windowHandle:allWindow){
            if (!windowHandle.equals(mainWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertTrue(newCardGenerationMessage.isDisplayed(), "new Card Generation is not displayed");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid yellow';", newCardGenerationMessage);

    }
}
