package com.tutorialsninja.steps;

import com.tutorialsninja.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

public class RegistrationTestPage {
    @When("^I pass selectMyAccountOptions method parameter \"([^\"]*)\"$")
    public void i_pass_selectMyAccountOptions_method_parameter(String arg1)  {
        new RegisterPage().selectMyOptions("Register");

    }

    @Then("^I should be able to verify \"([^\"]*)\"$")
    public void i_should_be_able_to_verify(String arg1)  {
        Assert.assertEquals( new RegisterPage().verifyTextRegisterAccount(), "Register Account", "Register Account text is not matching");
    }

    @And("^I enter below details in the registration form$")
    public void
    iEnterBelowDetailsInTheRegistrationForm(DataTable datatable) {
        List<List<String>> form = datatable.asLists(String.class);

        String fName = form.get(0).get(0);
        String lName = form.get(0).get(1);
        String telephone = form.get(0).get(2);
        String password = form.get(0).get(3);
        String cPassword = form.get(0).get(4);

        new RegisterPage().enterFirstName(fName);
        new RegisterPage().enterLastName(lName);
        new RegisterPage().enterTelephone(telephone);
        new RegisterPage().enterPassword(password);
        new RegisterPage().enterConfirmPassword(cPassword);

    }

    @And("^I select subscribe yes radio button$")
    public void iSelectSubscribeYesRadioButton() {
        new RegisterPage().clickOnYesRadioButton();
    }

    @And("^I Click on Privacy Policy check box$")
    public void iClickOnPrivacyPolicyCheckBox() {
        new RegisterPage().clickOnPrivacyPolicyCheckBox();
    }

    @And("^I Click on Continue button on register account page$")
    public void iClickOnContinueButtonOnRegisterAccountPage() {
        new RegisterPage().clickOnContinueButton();
    }

    @And("^I Verify the message \"([^\"]*)\"$")
    public void iVerifyTheMessage(String arg0) {
        Assert.assertEquals(new RegisterPage().verifyMessageAccountCreated(), "Your Account Has Been Created!", "Error message");

    }


    @And("^I pass selectMyAccountOptions method parameter \"([^\"]*)\" on registration page$")
    public void iPassSelectMyAccountOptionsMethodParameterOnRegistrationPage(String arg0)  {
        new RegisterPage().selectMyOptions("Logout");
    }

    @And("^I verify the text \"([^\"]*)\" on registration page$")
    public void iVerifyTheTextOnRegistrationPage(String arg0) {
        Assert.assertEquals( new RegisterPage().verifyTextAccountLogout(), "Account Logout", "Error message");

    }
    @And("^I click on Continue button$")
    public void iClickOnContinueButton() {
        new RegisterPage().clickOnContinue();
    }


    @And("^I click on Continue tab$")
    public void iClickOnContinueTab() {
        new RegisterPage().clickOnContinueTab();

    }

    @And("^I enter email id$")
    public void iEnterEmailId() {
        new RegisterPage().enterEmailId();


    }


}
