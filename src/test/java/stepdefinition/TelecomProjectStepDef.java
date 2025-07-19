package stepdefinition;

import helper.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.TelecomProject;

public class TelecomProjectStepDef {
    TestContext testContext;
    WebDriver driver;
    TelecomProject telecomProject;

    public TelecomProjectStepDef(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        telecomProject=testContext.getPageObjectManager().getTelecomProject();
    }
    @Then("I click on TelecomProject Tab")
    public void i_click_on_telecom_project_tab() {
        telecomProject.clickOnTelecomProjectTab();
    }

    @And("I click on Add Customer Button")
    public void iClickOnAddCustomerButton() {
        telecomProject.clickOnAddCustomerBtn();
    }

    @And("I click on Done Button")
    public void iClickOnDoneButton() {
        telecomProject.clickOnDoneBtn();
    }

    @Then("I click on FirstName and LastName details under Billing Address Section")
    public void iClickOnFirstNameAndLastNameDetailsUnderBillingAddressSection() {
        telecomProject.clickOnDetailsTab();
    }

    @And("I fill the {string},{string},{string}")
    public void iFillThe(String arg0, String arg1, String arg2) {
        telecomProject.fillTheMandatoryDetails(arg0,arg1,arg2);
    }

    @Then("I click on Submit Button")
    public void iClickOnSubmitButton() {
        telecomProject.clickOnSubmitBtn();
    }

    @And("I verify this {string}")
    public void iVerifyThis(String arg0) {
        telecomProject.verifyThisCustomerID(arg0);
    }

    @And("I close the Browser")
    public void iCloseTheBrowser() {
        telecomProject.closeTheBrowser();
    }

    @And("I click on Home Button")
    public void iClickOnHomeButton() {
        telecomProject.clickOnHomeBtn();
    }

    @And("I click on Add Tariff Button")
    public void iClickOnAddTariffButton() {
        telecomProject.clickOnAddTariffButton();
    }

    @And("I click on Add Tariff Plan to Customer Button")
    public void iClickOnAddTariffPlanToCustomerButton() {
        telecomProject.clickOnAddTariffPlanToCustomerButton();
    }

    @And("I click on Pay Billing")
    public void iClickOnPayBilling() {
        telecomProject.clickOnPayBilling();
    }

    @Then("I fill the Add Tariff Plans {string}")
    public void iFillTheAddTariffPlans(String arg0) {
        telecomProject.fillAllTheData(arg0);
    }

    @And("I verify the {string} Message")
    public void iVerifyTheMessage(String msg) {
        telecomProject.verifyCongratulationMsg(msg);
    }

    @Then("I Enter the {string}")
    public void iEnterThe(String id) {
        telecomProject.enterCustomerID(id);
    }

    @And("I verify the {string}")
    public void iVerifyThe(String msg) {
        telecomProject.verifyMsg(msg);
    }

    @And("I verify the {string} {string}")
    public void iVerifyThe(String id, String name) {
        telecomProject.verifyBillingHistory(id,name);
    }
}
