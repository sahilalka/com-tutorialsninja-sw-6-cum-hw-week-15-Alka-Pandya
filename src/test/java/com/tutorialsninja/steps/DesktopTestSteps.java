package com.tutorialsninja.steps;

import com.tutorialsninja.pages.DesktopsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class DesktopTestSteps {

    @And("^I select sort by position \"([^\"]*)\"$")
    public void i_select_sort_by_position(String productSortBy) {
        new DesktopsPage().selectPositionByZtoA(productSortBy);
    }

    @Then("^I should be able to verify that the product is arranged in descending order$")
    public void i_should_be_able_to_verify_that_the_product_is_arranged_in_descending_order() {
        new DesktopsPage().ProductNameDisplayOrder();
    }

    @When("^I click on product \"([^\"]*)\"$")
    public void i_click_on_product(String arg1) {
        new DesktopsPage().clickOnProductHPLP3065();
    }

    @And("^I verify the text \"([^\"]*)\"$")
    public void iVerifyTheText(String arg0) {
        Assert.assertEquals(new DesktopsPage().getTextHPLP3065(), "HP LP3065", "Product name is not matching");
    }

    @And("^I Select Delivery Date \"([^\"]*)\"$")
    public void iSelectDeliveryDate(String arg0) {
        new DesktopsPage().selectDateFromCalender();
    }

    @And("^I enter qty \"([^\"]*)\"$")
    public void iEnterQty(String arg0) {
        new DesktopsPage().enterQuantity();
    }

    @And("^I click on “Add to Cart” button$")
    public void iClickOnAddToCartButton() {
        new DesktopsPage().clickOnAddToCart();
    }

    @And("^I verify the message \"([^\"]*)\"$")
    public void iVerifyTheMessage(String arg0) {
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!";
        String actualText1 = new DesktopsPage().getSuccessfulShoppingCartMessageText();
        boolean message = actualText1.contains(expectedText1.trim());
        Assert.assertTrue(message);

    }

    @And("^I click on link \"([^\"]*)\"$")
    public void iClickOnLink(String arg0) {
        new DesktopsPage().clickOnShoppingCart();
    }

    @Then("^I Verify the shopping cart with below values$")
    public void iVerifyTheShoppingCartWithBelowValues(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        System.out.println("Table = " + table);

        String heading = table.get(0).get("heading");

        String productName = table.get(0).get("productName");
        String deliveryDate = table.get(0).get("deliveryDate");
        String model = table.get(0).get("model");
        String total = table.get(0).get("total");

        String actualHeading = new DesktopsPage().getShoppingCartText();

        String actualProductName = new DesktopsPage().getProductNameHPLPText();
        String actualDeliveryDate = new DesktopsPage().verifyDeliveryDate();
        String actualTotal = new DesktopsPage().verifyTotal();
        String actualModel = new DesktopsPage().verifyModelProduct21();

        boolean outcome = actualHeading.contains(heading);
        Assert.assertTrue(outcome);


        Assert.assertEquals(actualProductName, productName, "Text not matching");
        Assert.assertEquals(actualDeliveryDate, deliveryDate, "Text not matching");
        Assert.assertEquals(actualTotal, total, "Text not matching");
        Assert.assertEquals(actualModel, model, "Text not matching");

    }



}
