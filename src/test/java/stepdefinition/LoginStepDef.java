package stepdefinition;

import helper.TestContext;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;

public class LoginStepDef {
    TestContext testContext;
    WebDriver driver;
    LoginPage loginPage;

    public LoginStepDef(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        loginPage =testContext.getPageObjectManager().getLoginPage();
    }
    @Given("I launch {string} Application")
    public void i_launch_application(String url) {
    loginPage.loginToGuruDemoWebsite(url);
    }
    @Given("I  enter the {string} and {string}")
    public void i_enter_the_and(String string1, String string2) throws InterruptedException {
       loginPage.enterUsernameAndPwd(string1,string2);
    }
}

;