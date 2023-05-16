package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li/a")
    WebElement options;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement returningCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountText;

    @CacheLookup
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement textAccountLogout;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continue2;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement  email ;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    public void selectMyOptions(String option) {
        log.info("Selecting my account options" + option.toString());
        clickOnElement(By.linkText("My Account"));
        List<WebElement> optionsList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li/a"));
        for (WebElement element : optionsList) {
            if (element.getText().equalsIgnoreCase(option)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public String verifyTextReturningCustomer() {
        log.info("Getting text Returning Customer” ");
        return getTextFromElement(returningCustomer);
    }

    public void clickOnLoginButton() {
        log.info("Clicking on login button.");
        clickOnElement(loginButton);
    }

    public String verifyTextMyAccount() {
        log.info("Getting text My account");
        return getTextFromElement(myAccountText);
    }

    public void clickOnMyAccount() {
        log.info("Clicking on my Account.");
        clickOnElement(myAccountLink);
    }

    public String getTextAccountLogout() {
        log.info("Getting the text account logout");
        return getTextFromElement(textAccountLogout);
    }

    public void clickOnContinueLink() {
        log.info("Clicking on continue link.");
        clickOnElement(continue2);

    }
    public void enterEmail(String emailId) {
        log.info("Enter emailId" + emailId + "to email" +email.toString());
        sendTextToElement(email, emailId);
    }

    public void enterPasswordField(String passwordField) {
        log.info("Enter  passwordField" +  passwordField + "to password" + password.toString());
        sendTextToElement(password, passwordField);
    }


}
