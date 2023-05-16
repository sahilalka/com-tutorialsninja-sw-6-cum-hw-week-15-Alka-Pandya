Feature: Login functionality
  As user I want to navigate to login link and verify the login and logout functionality

  @smoke @regression
  Scenario: User should be able to navigate to login page successfully
    Given I am on homepage
    When I pass selectMyAccountOptions method parameter "Login" on homepage
    Then I should be able to verify the text "Returning Customer"


  @sanity @regression
  Scenario: User should be able to login and logout successfully
    Given I am on homepage
    When I pass selectMyAccountOptions method parameter "Login" on homepage
    And I enter the below details in the form
      |magnussmith123@gmail.com  |  smith123456|
    And I click on Login button
    And I verify text "My Account"
    And I pass selectMyAccountOptions method parameter "Logout" on my account page
    And I verify text "Account Logout" from homepage
    Then I click on continue button on homepage