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
import java.util.UUID;

public class RegisterPage extends Utility {

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());
    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }


    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li/a")
    WebElement options;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccount;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement yesRadioButton;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement accountText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueTab;

    @CacheLookup
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
    WebElement myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continue1;


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


    public String verifyTextRegisterAccount() {
        log.info("Verifying text register account");
        return getTextFromElement(registerAccount);
    }

    public void enterFirstName(String fName) {
        log.info("Enter fName" + fName + "to firstName " + firstName.toString());
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lName) {
        log.info("Enter lName " + lName + "to lastName  " + lastName.toString());
        sendTextToElement(lastName, lName);
    }

    public void enterEmailId() {
        log.info("Enter emailId");
        String randomEmail = randomEmail();
        sendTextToElement(email, randomEmail);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    public void enterTelephone(String telNum) {
        log.info("Enter telNum" + telNum + "to telephone" + telephone.toString());
        sendTextToElement(telephone, telNum);
    }

    public void enterPassword(String passWord) {
        log.info("Enter passWord " + passWord + "to Password" + password.toString());
        sendTextToElement(password, passWord);
    }

    public void enterConfirmPassword(String conPassword) {
        log.info("Enter confirmPassword " + conPassword + "to confirmPassword" + confirmPassword.toString());
        sendTextToElement(confirmPassword, conPassword);
    }

    public void clickOnYesRadioButton() {
        log.info("clicking on radiobutton.");
        clickOnElement(yesRadioButton);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        log.info("Clicking on privacy policy checkbox.");
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        log.info("Clicking on continue button.");
        clickOnElement(continueButton);
    }

    public String verifyMessageAccountCreated() {
        log.info("Verifying message account created");
        return getTextFromElement(accountText);
    }

    public void clickOnContinueTab() {
        log.info("Clicking on continue tab");
        clickOnElement(continueTab);
    }

    public void clickOnMyAccountTab() {
        log.info("Clicking on my account tab.");
        clickOnElement(myAccountTab);
    }

    public String verifyTextAccountLogout() {
        log.info("Verify the text account logout");
        return getTextFromElement(accountLogoutText);
    }

    public void clickOnContinue() {
        log.info("Clicking on continue.");
        clickOnElement(continue1);
    }




}
