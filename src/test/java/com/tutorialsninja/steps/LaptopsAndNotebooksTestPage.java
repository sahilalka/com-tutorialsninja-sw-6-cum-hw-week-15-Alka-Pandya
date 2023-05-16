package com.tutorialsninja.steps;

import com.tutorialsninja.pages.LaptopsAndNoteBooksPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class LaptopsAndNotebooksTestPage {
    @And("^I click on \"([^\"]*)\"$")
    public void iClickOn(String arg0) {
        new LaptopsAndNoteBooksPage().clickOnShowAllLaptopsAndNotebooks();
    }

    @And("^I select sort by \"([^\"]*)\"$")
    public void iSelectSortBy(String arg0) {
        new LaptopsAndNoteBooksPage().selectSortByHighToLow("Price (High > Low)");

    }

    @Then("^I should be able to verify that the product is arranged in High to Low order$")
    public void iShouldBeAbleToVerifyThatTheProductIsArrangedInHighToLowOrder() {
        Assert.assertEquals(new LaptopsAndNoteBooksPage().beforeSortingPriceHighToLow(), new LaptopsAndNoteBooksPage().afterSortingPriceHighToLow(), "Products are not sorted high to low");

    }

    @And("^I Select Product \"([^\"]*)\"$")
    public void iSelectProduct(String arg0) {
        new LaptopsAndNoteBooksPage().clickOnMacBook();

    }

    @And("^I click on \"([^\"]*)\" button$")
    public void iClickOnButton(String arg0) {
        new LaptopsAndNoteBooksPage().clickOnAddToCart();

    }

    @And("^I verify the productText \"([^\"]*)\"$")
    public void iVerifyTheProductText(String arg0) {
        Assert.assertEquals(new LaptopsAndNoteBooksPage().verifyTextMacBook(), "MacBook", "Product name is not matching");
    }

    @And("^I click on \"([^\"]*)\" button on MacBook page$")
    public void iClickOnButtonOnMacBookPage(String arg0) {
        new LaptopsAndNoteBooksPage().clickOnAddToCart();

    }

    @And("^I verify the MacBook message \"([^\"]*)\"$")
    public void iVerifyTheMacBookMessage(String arg0) {
        String expectedMessage = "Success: You have added MacBook to your shopping cart!";
        String actualMessage = new LaptopsAndNoteBooksPage().getAddedMacBookText();
        boolean message = actualMessage.contains(expectedMessage.trim());
        Assert.assertTrue(message);

    }

    @And("^I click on link “shopping cart” display on MacBook page$")
    public void iClickOnLinkShoppingCartDisplayOnMacBookPage() {
        new LaptopsAndNoteBooksPage().clickOnShoppingCart();
    }

    @And("^I verify the text \"([^\"]*)\" from MacBook page$")
    public void iVerifyTheTextFromMacBookPage(String arg0) {
        Assert.assertEquals(new LaptopsAndNoteBooksPage().verifyTextShoppingCart(), "Shopping Cart  (0.00kg)", "Shopping cart text is not matching");

    }

    @And("^I change the quantity \"([^\"]*)\"$")
    public void iChangeTheQuantity(String arg0) {
        new LaptopsAndNoteBooksPage().changeQuantity();

    }

    @And("^I click on \"([^\"]*)\" tab$")
    public void iClickOnTab(String arg0) {
        new LaptopsAndNoteBooksPage().clickOnUpdateTab();

    }

    @And("^I verify the message \"([^\"]*)\" on MacBook page$")
    public void iVerifyTheMessageOnMacBookPage(String arg0) {
        String expectedMessage1 = "Success: You have modified your shopping cart!";
        String actualMessage1 = new LaptopsAndNoteBooksPage().verifyModifiedYourShoppingCart();
        boolean outcome = actualMessage1.contains(expectedMessage1.trim());
        Assert.assertTrue(outcome);
    }

    @And("^I verify the Total £(\\d+)\\.(\\d+)$")
    public void iVerifyTheTotal£(int arg0, int arg1) {
        Assert.assertEquals(new LaptopsAndNoteBooksPage().verifyTotal(), "$1,204.00", "Total amount is not matching");

    }

    @And("^I click on \"([^\"]*)\" button on MACBook page$")
    public void iClickOnButtonOnMACBookPage(String arg0) {
        new LaptopsAndNoteBooksPage().clickOnCheckoutButton();

    }

    @And("^I verify the text \"([^\"]*)\" on MacBook page$")
    public void iVerifyTheTextOnMacBookPage(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(new LaptopsAndNoteBooksPage().verifyTheTextNewCustomer(), "New Customer", "New customer text is not matching");
    }


    @And("^I click on \"([^\"]*)\" tab on MacBook page$")
    public void iClickOnTabOnMacBookPage(String arg0) {
        new LaptopsAndNoteBooksPage().clickOnContinueTab();

    }

    @And("^I verify the text \"([^\"]*)\" on MacBook page shopping cart$")
    public void iVerifyTheTextOnMacBookPageShoppingCart(String arg0) {
        Assert.assertEquals(new LaptopsAndNoteBooksPage().verifyTheTextCheckout(), "Checkout", "Checkout text is not matching");
    }

    @And("^I enter below details in the form$")
    public void iEnterBelowDetailsInTheForm(DataTable dataTable) {
        List<List<String>> form = dataTable.asLists(String.class);
        String firstName = form.get(0).get(0);
        String lastName = form.get(0).get(1);
        String email = form.get(0).get(2);
        String telephone = form.get(0).get(3);
        String address = form.get(0).get(4);
        String city = form.get(0).get(5);
        String postcode = form.get(0).get(6);
        String country = form.get(0).get(7);
        String region = form.get(0).get(8);
        //String password = form.get(0).get(9);
        //String confirmPassword = form.get(0).get(10);


        new LaptopsAndNoteBooksPage().enterFirstName(firstName);
        new LaptopsAndNoteBooksPage().enterLastName(lastName);
        new LaptopsAndNoteBooksPage().enterEmailId(email);
        new LaptopsAndNoteBooksPage().enterTelephone(telephone);
        new LaptopsAndNoteBooksPage().enterAddress(address);
        new LaptopsAndNoteBooksPage().enterAddress(address);
        new LaptopsAndNoteBooksPage().enterCity(city);
        new LaptopsAndNoteBooksPage().enterPostCode(postcode);
        new LaptopsAndNoteBooksPage().selectCountryFromDropDown(country);
        new LaptopsAndNoteBooksPage().selectRegionFromDropDown(region);
        //new LaptopsAndNoteBooksPage().enterPasswordAndConfirmPassword(password, confirmPassword);


    }

    @And("^I click on \"([^\"]*)\" Button on checkout page$")
    public void iClickOnButtonOnCheckoutPage(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        new LaptopsAndNoteBooksPage().clickOnContinueButton();
    }

    @And("^I add comments about your order into text area$")
    public void iAddCommentsAboutYourOrderIntoTextArea() {
        new LaptopsAndNoteBooksPage().addCommentsAboutYourOrder();

    }

    @And("^I check the Terms & Conditions check box$")
    public void iCheckTheTermsConditionsCheckBox() throws InterruptedException {
        Thread.sleep(200);
        new LaptopsAndNoteBooksPage().clickOnTermsAndConditionsCheckBox();

    }

    @And("^I click on continue$")
    public void iClickOnContinue() {
        new LaptopsAndNoteBooksPage().clickOnContinue();
    }

    @And("^I click on \"([^\"]*)\" radio button$")
    public void iClickOnRadioButton(String arg0)  {
        new LaptopsAndNoteBooksPage().clickOnGuestCheckOutRadioButton();

    }

    @And("^I verify the text \"([^\"]*)\" product name$")
    public void iVerifyTheTextProductName(String arg0)  {
        Assert.assertEquals( new LaptopsAndNoteBooksPage().verifyProductNameMacBook(), "MacBook", "MacBook name is not matching on shopping cart page");


    }

    @Then("^I verify the message \"([^\"]*)\" on checkout page$")
    public void iVerifyTheMessageOnCheckoutPage(String arg0)  {
        String expectedMessage2 = "Warning: Payment method required!";
        String actualMessage2 = new LaptopsAndNoteBooksPage().verifyMessagePaymentMethodRequired();
        boolean message2 = actualMessage2.contains(expectedMessage2.trim());
        Assert.assertTrue(message2);


    }

}
