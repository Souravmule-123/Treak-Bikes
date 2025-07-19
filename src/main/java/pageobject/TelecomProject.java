package pageobject;

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
import org.testng.Assert;


public class TelecomProject {
    private static final Logger log = LogManager.getLogger(TelecomProject.class);
    WebDriver driver;
    WaitManager waitManager;
    Actions actions;

    @FindBy(xpath = "//*[text()='Telecom Project']")
    WebElement telecomProjectTab;
    @FindBy(xpath = "//*[@class='flex-item left']/div/h3/a[text()='Add Customer']")
    WebElement addCustomerBtn;
    @FindBy(xpath = "//*[text()='Done']")
    WebElement doneBtn;
    @FindBy(xpath = "//*[@placeholder='FirstName']")
    WebElement firstName;
    @FindBy(xpath = "//*[@placeholder='LastName']")
    WebElement lastName;
    @FindBy(xpath = "//*[@placeholder='Email']")
    WebElement email;
    @FindBy(xpath = "//*[@placeholder='Enter your address']")
    WebElement address;
    @FindBy(xpath = "//*[@placeholder='Mobile Number']")
    WebElement mobileNumber;
    @FindBy(xpath = "//*[@name='submit']")
    WebElement submitBtn;
    @FindBy(xpath = "//*[@class='alt access']/tbody/tr/td[2]/h3")
    WebElement customerID;
    @FindBy(xpath = "//*[@class='button']")
    WebElement HomeBtn;
    @FindBy(xpath = "//*[@class='flex-item right']/div/h3/a[text()='Add Tariff Plan']")
    WebElement addTariffPlanBtn;
    @FindBy(xpath = "//*[@id='rental1']")
    WebElement monthlyRentalBtn;
    @FindBy(xpath = "//*[@id='local_minutes']")
    WebElement freeLocalMinBtn;
    @FindBy(xpath = "//*[@id='inter_minutes']")
    WebElement freeInternationalMinBtn;
    @FindBy(xpath = "//*[@id='sms_pack']")
    WebElement freeSMSBtn;
    @FindBy(xpath = "//*[@id='minutes_charges']")
    WebElement localMinChargeBtn;
    @FindBy(xpath = "//*[@id='inter_charges']")
    WebElement internationalPerMinBtn;
    @FindBy(xpath = "//*[@id='sms_charges']")
    WebElement smsChargesBtn;
    @FindBy(xpath = "//*[text()='Congratulation you add Tariff Plan']")
    WebElement addTariffPlanValidationStatus;
    @FindBy(xpath = "//*[@class='flex-item left']/div/h3/a[text()='Add Tariff Plan to Customer']")
    WebElement addTariffPlanToCustomerBtn;
    @FindBy(xpath = "//*[@id='customer_id']")
    WebElement enterCustomerID;
    @FindBy(xpath = "//*[@id=\"main\"]/div/marquee/h3")
    WebElement addTariffPlanToCustomerVerificationMsg;
    @FindBy(xpath = "//*[@class='flex-item right']/div/h3/a[text()='Pay Billing']")
    WebElement payBillingBtn;
    @FindBy(xpath = "//*[@id=\"main\"]/div/h3")
    WebElement billingHistoryValidation;


    public TelecomProject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitManager = new WaitManager(driver);
        actions = new Actions(driver);
    }
    public void clickOnTelecomProjectTab() {
        telecomProjectTab.click();
    }
    public void clickOnDoneBtn() {
        doneBtn.click();
    }
    public void clickOnAddCustomerBtn() {
        addCustomerBtn.click();
    }
    public void clickOnDetailsTab() {
        firstName.sendKeys("Rahul");
        lastName.sendKeys("Sharma");
    }
    public void fillTheMandatoryDetails(String arg0, String arg1, String arg2) {
        waitManager.applyExplicitWait(10).until(ExpectedConditions.elementToBeClickable(email));
    email.sendKeys("rahul.sharma91@testmail.com");
        waitManager.applyExplicitWait(10).until(ExpectedConditions.elementToBeClickable(address));
    address.sendKeys("EionCenter Park Street Delhi");
        waitManager.applyExplicitWait(10).until(ExpectedConditions.elementToBeClickable(mobileNumber));
    mobileNumber.sendKeys("9876543210");
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    public void verifyThisCustomerID(String text) {
        Assert.assertTrue(customerID.isDisplayed(), "'Add Customer' text is not displayed!");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid yellow';", customerID);
        System.out.println(customerID.getText());
    }

    public void closeTheBrowser() {
        driver.close();
    }

    public void clickOnHomeBtn() {
        HomeBtn.click();
    }

    public void clickOnAddTariffButton() {
        addTariffPlanBtn.click();
    }
    public void fillAllTheData(String arg0) {
    monthlyRentalBtn.sendKeys("10");
    freeLocalMinBtn.sendKeys("100");
    freeInternationalMinBtn.sendKeys("20");
    freeSMSBtn.sendKeys("50");
    localMinChargeBtn.sendKeys("10");
    internationalPerMinBtn.sendKeys("75");
    smsChargesBtn.sendKeys("5");
    }


    public void clickOnAddTariffPlanToCustomerButton() {
        addTariffPlanToCustomerBtn.click();
    }

    public void clickOnPayBilling() {
        payBillingBtn.click();
    }

    public void verifyCongratulationMsg(String msg) {
        Assert.assertTrue(addTariffPlanValidationStatus.isDisplayed(), "Congratulation you add Tariff Plan not displayed!");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid yellow';", addTariffPlanValidationStatus);
        System.out.println(addTariffPlanValidationStatus.getText());

    }

    public void enterCustomerID(String id) {
        enterCustomerID.sendKeys("890522");
    }

    public void verifyMsg(String msg) {
        Assert.assertTrue(addTariffPlanToCustomerVerificationMsg.isDisplayed(), "Welcome to add customer tariff plan Rahul is not displayed");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid yellow';", addTariffPlanToCustomerVerificationMsg);
        System.out.println(addTariffPlanToCustomerVerificationMsg.getText());
    }

    public void verifyBillingHistory(String id, String name) {
            Assert.assertTrue(billingHistoryValidation.isDisplayed(), "customer ID and Customer name is not present");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='10px solid yellow';", billingHistoryValidation);
            System.out.println(billingHistoryValidation.getText());
        }
        }


