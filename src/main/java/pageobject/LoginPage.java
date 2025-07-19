package pageobject;


import objectmanager.FileReaderManager;
import objectmanager.WaitManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitManager = new WaitManager(driver);
        actions = new Actions(driver);
    }

    public void loginToGuruDemoWebsite(String url) {
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
    }


