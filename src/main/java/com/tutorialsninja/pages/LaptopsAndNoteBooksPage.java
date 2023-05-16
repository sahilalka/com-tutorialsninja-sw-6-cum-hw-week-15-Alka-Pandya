package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNoteBooksPage extends Utility {

    private static final Logger log = LogManager.getLogger(LaptopsAndNoteBooksPage.class.getName());
    public LaptopsAndNoteBooksPage(){
        PageFactory.initElements(driver,this);
    }


    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksTab;
    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement showAllLaptopsAndNotebooks;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement productPriceHighToLow;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBook;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='MacBook']")
    WebElement textMacBook;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement macBookAddedText;
    @CacheLookup
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCart;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement textShoppingCart;
    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'MacBook')])[2]")
    WebElement productNameMacBook;
    @CacheLookup
    @FindBy(css = "input[value='1']")
    WebElement qty2;
    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-refresh']")
    WebElement updateTab;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement modifiedCart;
    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkoutButton;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement textCheckout;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomer;
    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckout;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueTab;
    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;
    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCode;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement comments;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAndCondition;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continue1;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;


    public void mouseHoverOnLaptopAndNotebooksTabAndClick() {
        log.info("Mouse hover on laptop and notebooks tab and click");
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        log.info("click on show all laptops and notebooks");
        clickOnElement(showAllLaptopsAndNotebooks);
    }

    public void selectSortByHighToLow(String text) {
        log.info("select sort by high to low");
        selectByVisibleTextFromDropDown(sortBy, text);
    }

    public List<Double> beforeSortingPriceHighToLow() {
        log.info("Verify the Product price will arrange in High to Low order before sorting");
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        //sort by reverse order
        Collections.sort(originalProductPrice, Collections.reverseOrder());
        System.out.println(originalProductPrice);
        return originalProductPrice;
    }

    public List<Double> afterSortingPriceHighToLow() {
        //After filter Price (High > Low) get all the products price and stored into array list
        log.info("Verify the Product price will arrange in High to Low order after sorting");
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return afterSortByPrice;

    }

    public void clickOnMacBook() {
        log.info("clicking on Macbook.");
        clickOnElement(macBook);
    }

    public String verifyTextMacBook() {
        log.info("verify text Macbook");
        return getTextFromElement(textMacBook);
    }

    public void clickOnAddToCart() {
        log.info("clicking on add to cart.");
        clickOnElement(addToCart);
    }

    public String getAddedMacBookText() {
        log.info("get added Macbook text");
        return getTextFromElement(macBookAddedText);
    }

    public void clickOnShoppingCart() {
        log.info("clicking on shopping cart.");
        clickOnElement(shoppingCart);
    }

    public String verifyTextShoppingCart() {
        log.info("Verify text shopping cart ");
        return getTextFromElement(textShoppingCart);
    }

    public String verifyProductNameMacBook() {
        log.info("Verify product name Macbook");
        return getTextFromElement(productNameMacBook);
    }

    public void changeQuantity() {
        log.info("change quantity");
        clearValue(By.cssSelector("input[value='1']"));
        sendTextToElement(qty2, "2");

    }

    public void clickOnUpdateTab() {
        log.info("click on update tab");
        clickOnElement(updateTab);
    }

    public String verifyModifiedYourShoppingCart() {
        log.info("Verify modified shopping cart");
        return getTextFromElement(modifiedCart);
    }

    public String verifyTotal() {
        log.info("Verify total");
        return getTextFromElement(total);
    }

    public void clickOnCheckoutButton() {
        log.info("clicking on checkout button.");
        clickOnElement(checkoutButton);
    }

    public String verifyTheTextCheckout() {
        log.info("Verify the text checkout");
        return getTextFromElement(textCheckout);
    }

    public String verifyTheTextNewCustomer() {
        log.info("Verify the text Newcustomer");
        return getTextFromElement(newCustomer);
    }

    public void clickOnGuestCheckOutRadioButton() {
        log.info("clicking on guest checkout radiobutton.");
        clickOnElement(guestCheckout);
    }

    public void clickOnContinueTab() {
        log.info("clicking on continue tab.");
        clickOnElement(continueTab);
    }

    public void enterFirstName(String fName) {
        log.info("Enter fName" + fName + "to firstName " + firstName.toString());
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lName) {
        log.info("Enter lName " + lName + "to lastName  " + lastName.toString());
        sendTextToElement(lastName, lName);
    }

    public void enterEmailId(String emailId) {
        log.info("Enter emailId " + emailId + "to email " + email.toString());
        sendTextToElement(email, emailId);
    }

    public void enterTelephone(String number) {
        log.info("Enter number " + number + "to telephone" + telephone.toString());
        sendTextToElement(telephone, number);
    }

    public void enterAddress(String add) {
        log.info("Enter add " + add + "to address " + address.toString());
        sendTextToElement(address, add);
    }

    public void enterCity(String cityName) {
        log.info("Enter cityName " + cityName + "to city " + city.toString());
        sendTextToElement(city, cityName);
    }

    public void enterPostCode(String postalCode) {
        log.info("Enter postalCode" + postalCode + "to postcode" + postCode.toString());
        sendTextToElement(postCode, postalCode);
    }

    public void selectCountryFromDropDown(String countryName) {
        log.info("select country from dropdown");
        selectByVisibleTextFromDropDown(country, countryName);
    }

    public void selectRegionFromDropDown(String regionName) {
        log.info("select region from dropdown");
        selectByVisibleTextFromDropDown(region, regionName);
    }

    public void clickOnContinueButton() {
        log.info("clicking on continue button.");
        clickOnElement(continueButton);
    }

    public void addCommentsAboutYourOrder() {
        log.info("Add Comments About your order into text area");
        sendTextToElement(comments, "I have added two products");
    }

    public void clickOnTermsAndConditionsCheckBox() {
        log.info("clicking on Terms & Conditions check box.");
        clickOnElement(termsAndCondition);
    }

    public void clickOnContinue() {
        log.info("clicking On Continue button.");
        clickOnElement(continue1);
    }

    public String verifyMessagePaymentMethodRequired() {
        log.info("verify Message Payment Method Required");
        return getTextFromElement(warningMessage);
    }


}
