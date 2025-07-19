package pageobject;


import objectmanager.FileReaderManager;
import objectmanager.WaitManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;


public class LoginPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    WebDriver driver;
    WaitManager waitManager;
    Actions actions;

    @FindBy(xpath = "//*[@name='uid']")
    WebElement userName;
    @FindBy(xpath = "//*[@name='password']")
    WebElement password;
    @FindBy(xpath = "//*[@name='btnLogin']")
    WebElement loginBtn;

//    @FindBy(xpath = "//*[text()='Total Recurring Reimbursement for all Patients Per Month:']")
//    WebElement actualMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitManager = new WaitManager(driver);
        actions = new Actions(driver);
    }

    public void loginFitpeoPage(String url) {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl(url));
    }

    public void enterUsernameAndPwd(String user, String pwd) throws InterruptedException {
    waitManager.applyExplicitWait(15).until(ExpectedConditions.elementToBeClickable(userName));
        waitManager.applyExplicitWait(10).until(ExpectedConditions.elementToBeClickable(userName));
       userName.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserName(user));
        waitManager.applyWait(20);
        waitManager.applyExplicitWait(20).until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPassword(pwd));
        waitManager.applyExplicitWait(10).until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();}

//    public void verifyMessage(String verifyMsg) {
//        final String EXPECTED_MESSAGE = "Total Recurring Reimbursement for all Patients Per Month:";
//        String actualValue = actualMessage.getAttribute("value");
//        System.out.println("Slider value: " + actualValue);
//        if (EXPECTED_MESSAGE.equals(actualValue)) {
//            System.out.println("Message is not verified. Actual value:");
//        } else {
//            System.err.println("Message is verified" + actualValue);
//        }
//        driver.quit();
    }


