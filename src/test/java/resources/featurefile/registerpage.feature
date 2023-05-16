Feature: Registration functionality
  As user I want to navigate to register link and verify the registration functionality

  @sanity @regression
  Scenario: User should be able to navigate to register page successfully
    Given I am on homepage
    When I pass selectMyAccountOptions method parameter "Register"
    Then I should be able to verify "Register Account"

  @smoke @regression
  Scenario: User should be able to navigate to register page successfully
    Given I am on homepage
    When I pass selectMyAccountOptions method parameter "Register"
    And I enter email id
    And I enter below details in the registration form
      | Magnus     |Smith   | 0782565511 | smith123456|smith123456|
    And I select subscribe yes radio button
    And I Click on Privacy Policy check box
    And I Click on Continue button on register account page
    And I Verify the message "Your Account Has Been Created!"
    And I click on Continue tab
    And I pass selectMyAccountOptions method parameter "Logout" on registration page
    And I verify the text "Account Logout" on registration page
    Then I click on Continue button