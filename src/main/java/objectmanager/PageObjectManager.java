package objectmanager;

import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.PaymentGateway;
import pageobject.TelecomProject;

public class PageObjectManager {
    private final WebDriver driver;
    private LoginPage loginPage=null;
    private TelecomProject telecomProject=null;
    private PaymentGateway paymentGateway=null;


    public PageObjectManager(WebDriver driver){
    this.driver=driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
            return loginPage;
        } else return loginPage;
    }
    public TelecomProject getTelecomProject() {
        if (telecomProject == null) {
            telecomProject = new TelecomProject(driver);
            return telecomProject;
        } else return telecomProject;
    }
    public PaymentGateway getPaymentGateway() {
        if (paymentGateway == null) {
            paymentGateway = new PaymentGateway(driver);
            return paymentGateway;
        } else return paymentGateway;
    }

}
