package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {

    private static final Logger log = LogManager.getLogger(DesktopsPage.class.getName());

    public DesktopsPage(){
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement positionZtoA;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> allProductName;

    @FindBy(id = "input-sort")
    WebElement positionAtoZ;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement hpProduct;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement textHPLP3065;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calender;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthYear;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement yearAndMonth;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> allDates;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successfulShoppingCartMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;


    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement product21;


    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;


    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;


    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productHPLp3065;


    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;


    public String getShoppingCartText() {
        log.info("get shopping cart text");
        return getTextFromElement(shoppingCartText);
    }

    public String getProductNameHPLPText() {
        log.info("get product name HPLP3065Text");
        return getTextFromElement(productHPLp3065);
    }

    public String verifyDeliveryDate() {
        log.info("verify delivery date");
        return getTextFromElement(deliveryDate);
    }

    public String verifyModelProduct21() {
        log.info("verify model product21");
        return getTextFromElement(product21);
    }

    public String verifyTotal() {
        log.info("Verify total");
        return getTextFromElement(totalPrice);
    }

    public void clickOnShoppingCart() {
        log.info("click on shopping cart");
        clickOnElement(shoppingCart);
    }


    public String getSuccessfulShoppingCartMessageText() {
        log.info("getting shopping cart text");
        return getTextFromElement(successfulShoppingCartMessage);
    }

    public void enterQuantity() {
        log.info(" enter Quantity" + quantity.toString());
        sendTextToElement(quantity, "");
    }

    public void clickOnAddToCart() {
        log.info("clicking on add to cart.");
        clickOnElement(addToCart);
    }

    public void selectDateFromCalender() {
        log.info("select date from Calender");
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(calender);
        while (true) {
            String monthAndYear = monthYear.getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(yearAndMonth);
            }
        }
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

    }

    public String getTextHPLP3065() {
        log.info("get Text HPLP3065");
        return getTextFromElement(textHPLP3065);
    }


    public void clickOnProductHPLP3065() {
        log.info("click on product HPLP3065");
        clickOnElement(hpProduct);
    }

    public void selectPositionByAtoZ(String productSortBy) {
        log.info("Selection of sort by position Name: A to A" + positionAtoZ.toString());
        selectByVisibleTextFromDropDown(positionAtoZ, productSortBy);
    }

    public void selectPositionByZtoA(String productSortBy) {
        log.info("Selection of sort by position Name: Z to A" + positionZtoA.toString());
        selectByVisibleTextFromDropDown(positionZtoA, productSortBy);
    }

    public void ProductNameDisplayOrder() {
        log.info("Displaying products in descending order");
        ArrayList<String> actualList = getArrayListOfStringsFromWebElements(allProductName);
        ArrayList<String> expectedList = getArrayListOfStringsFromWebElements(allProductName);
        Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(expectedList);
        Assert.assertEquals(actualList, expectedList, "Products are not displayed in alphabetical order");
    }



}
