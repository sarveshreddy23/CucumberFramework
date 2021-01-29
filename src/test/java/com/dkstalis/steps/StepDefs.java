package com.dkstalis.steps;

import com.dkstalis.pages.*;
import com.dkstalis.utills.SeleniumUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class StepDefs {

    public SeleniumUtils selenium;

    public StepDefs(){
        System.out.println("Launch Constructor");
            selenium = SeleniumUtils.getInstance();

    }




    @Given("^user opens Midtrans Pillow app$")
    public void userOpensMidtransPillowApp() {
        selenium.launchApp();
        selenium.takeScreenshot();
    }

    @When("^user click on BUY NOW button$")
    public void userClickOnBUYNOWButton() throws Throwable{
        selenium.click(HomePage.btn_BuyNow);
        Assert.assertTrue("Verify Shopping Cart is visible: ", selenium.exists(ShoppingCart.hdr_ShoppingCart));
        selenium.takeScreenshot();
    }

    @When("^user click on CHECKOUT button$")
    public void userClickOnCHECKOUTButton() throws Throwable{
        selenium.click(ShoppingCart.btn_CHECKOUT);
        Thread.sleep(5000);
        selenium.switchFrame(0);
        Assert.assertTrue("Verify Order Summary is visible: ", selenium.exists(OrderSummary.hdr_OrderSummary));
        selenium.swithToDefaultContent();
        selenium.takeScreenshot();
    }


    @When("^user click on CONTINUE button on Order Summary page$")
    public void userClickOnCONTINUEButtonOnOrderSummaryPage() {
        selenium.switchFrame(0);
        selenium.click(OrderSummary.btn_CONTINUE);
        Assert.assertTrue("Verify Select Payment is visible: ", selenium.exists(SelectPayment.hdr_SelectPayment));
        selenium.swithToDefaultContent();
    }

    @When("^user choose Credit/Debit Card on Select Payment page$")
    public void userChooseCreditDebitCardOnSelectPaymentPage() {
        selenium.switchFrame(0);
        selenium.click(SelectPayment.lbl_Credit_DebitCard);
        Assert.assertTrue("Verify header Credit/Debit Card is visible: ", selenium.exists(CardDetails.hdr_Credit_DebitCard));
        selenium.swithToDefaultContent();
    }

    @When("^user enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" in Card Details page$")
    public void userEntersInCardDetailsPage(String cardNumber, String expiry, String cvv) throws Throwable {
        selenium.switchFrame(0);
        selenium.enterText(CardDetails.txt_CardNumber, cardNumber);
        selenium.enterText(CardDetails.txt_ExpiryDate, expiry);
        selenium.enterText(CardDetails.txt_CVV, cvv);
        selenium.swithToDefaultContent();
    }

    @When("^user click on PAYNOW button on Card Details page$")
    public void userClickOnPAYNOWButtonOnCardDetailsPage() throws Throwable{
        selenium.switchFrame(0);
        selenium.click(CardDetails.btn_PAYNOW);
        Thread.sleep(3000);
        selenium.switchFrame(0);
        System.out.println("Frame Size:"+selenium.getDriver().findElements(By.tagName("iframe")).size());
        Assert.assertTrue("Verify Bank OTP page is visible: ", selenium.exists(CardDetails.txt_BankOtp));
        selenium.swithToDefaultContent();
    }

    @When("^user enters \"([^\"]*)\" in Payment verification page$")
    public void userEntersInPaymentVerificationPage(String otp) throws Throwable {
        selenium.switchFrame(0);
        System.out.println("Frame Size:"+selenium.getDriver().findElements(By.tagName("iframe")).size());
        selenium.switchFrame(0);
        selenium.enterText(CardDetails.txt_BankOtp, otp);
        selenium.swithToDefaultContent();
    }

    @And("^user click OK button on Payment Verification page$")
    public void userClickOKButtonOnPaymentVerificationPage() {
        selenium.switchFrame(0);
        System.out.println("Frame Size:"+selenium.getDriver().findElements(By.tagName("iframe")).size());
        selenium.switchFrame(0);
        selenium.click(CardDetails.btn_OK);
        selenium.swithToDefaultContent();
    }

    @Then("^Thank you for your Payment Message is displayed on Home page$")
    public void thankYouForYourPaymentMessageIsDisplayedOnHomePage() {
        Assert.assertTrue("Verify Thank You Message on Home Page: ", selenium.exists(HomePage.lbl_ThanksForYourPurchase));
        Assert.assertTrue("Verify BUY NOW button on Home Page: ", selenium.exists(HomePage.btn_BuyNow));
    }

    @Then("^verify Transaction failure message$")
    public void verifyTransactionFailureMessage() {
        selenium.switchFrame(0);
        Assert.assertTrue("Verify Failed Transaction message is present:", selenium.exists(CardDetails.lbl_TransactionFailed));
        selenium.swithToDefaultContent();
    }
}
