package stepdefinition;

import helper.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.PaymentGateway;

public class PaymentGatewayStepDef {
    TestContext testContext;
    WebDriver driver;
    PaymentGateway paymentGateway;

    public PaymentGatewayStepDef(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        paymentGateway=testContext.getPageObjectManager().getPaymentGateway();
    }
    @Then("I Add a Quantity of Mother Elephant With Babies Soft Toy")
    public void i_add_a_quantity_of_mother_elephant_with_babies_soft_toy() {
    paymentGateway.selectTheValue();
    }
    @And("I click on Buy Now Option")
    public void iClickOnBuyNowOption() {
    paymentGateway.clickOnBuyNowOption();
    }

    @And("I click on {string}")
    public void iClickOn(String arg0) {
        paymentGateway.clickOnPaymentGatewayProject(arg0);
    }

    @Then("I verify the Payment Amount of Selected Quantity of Mother Elephant With Babies Soft Toy")
    public void iVerifyThePaymentAmountOfSelectedQuantityOfMotherElephantWithBabiesSoftToy() {
        paymentGateway.verifyAmount();
    }

    @And("I click on Pay Tab")
    public void iClickOnPayTab() {
        paymentGateway.clickOnPaysTab();
    }

    @And("I fill the {string},{string},{string},{string}")
    public void iFillThe(String arg0, String arg1, String arg2, String arg3) {
        paymentGateway.selectAllTheValue(arg0,arg1,arg2,arg3);
    }

    @Then("I verify Successiful message as well as Order ID")
    public void iVerifySuccessifulMessageAsWellAsOrderID() {
        paymentGateway.verifySuccessFullMsg();
    }

    @Then("I click on credit card Limit Btn")
    public void iClickOnCreditCardLimitBtn() {
        paymentGateway.clickOnCheckCreditCrdLimit();
    }

    @And("I fill the {string}")
    public void iFillThe(String arg0) {
        paymentGateway.enterCreditCardNumber(arg0);
    }

    @And("I verify Credit Card Balance Verification")
    public void iVerifyCreditCardBalanceVerification() {
        paymentGateway.verifyCreditCardBalance();
    }

    @When("I click on the {string}")
    public void iClickOnThe(String arg0) {
        paymentGateway.clickOnGenerateCardNumber(arg0);
    }

    @And("i Verify this text {string}")
    public void iVerifyThisText(String arg0) {
        paymentGateway.cardNewCreationMessage(arg0);
    }
}
