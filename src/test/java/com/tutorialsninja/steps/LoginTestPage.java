package com.tutorialsninja.steps;

import com.tutorialsninja.pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

public class LoginTestPage {
    @Then("^I should be able to verify the text \"([^\"]*)\"$")
    public void i_should_be_able_to_verify_the_text(String arg1) {
        Assert.assertEquals(new LoginPage().verifyTextReturningCustomer(), "Returning Customer", "Returning customer text is not matching");
    }

    @When("^I pass selectMyAccountOptions method parameter \"([^\"]*)\" on homepage$")
    public void iPassSelectMyAccountOptionsMethodParameterOnHomepage(String arg0) {
        new LoginPage().selectMyOptions("Login");

    }

    @And("^I enter the below details in the form$")
    public void iEnterTheBelowDetailsInTheForm(DataTable datatable) {
        List<List<String>> form = datatable.asLists(String.class);
        String email = form.get(0).get(0);
        String password = form.get(0).get(1);
        new LoginPage().enterEmail(email);
        new LoginPage().enterPasswordField(password);
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @And("^I verify text \"([^\"]*)\"$")
    public void iVerifyText(String arg0) {
        Assert.assertEquals(new LoginPage().verifyTextMyAccount(), "My Account", "My Account message is not matching");
    }


    @Then("^I click on continue button$")
    public void iClickOnContinueButton() {
        new LoginPage().clickOnMyAccount();
    }

    @And("^I pass selectMyAccountOptions method parameter \"([^\"]*)\" on my account page$")
    public void iPassSelectMyAccountOptionsMethodParameterOnMyAccountPage(String arg0) {
        new LoginPage().selectMyOptions("Logout");
    }

    @And("^I verify text \"([^\"]*)\" from homepage$")
    public void iVerifyTextFromHomepage(String arg0) {
        Assert.assertEquals(new LoginPage().getTextAccountLogout(), "Account Logout", "Error message");
    }

    @Then("^I click on continue button on homepage$")
    public void iClickOnContinueButtonOnHomepage() {
        new LoginPage().clickOnContinueLink();
    }


}
