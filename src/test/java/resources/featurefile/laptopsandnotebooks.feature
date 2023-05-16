Feature: Laptops and notebooks page

  As a user I should be able to navigate laptops and notebooks page and place an order successfully

  @smoke @regression
  Scenario: User should be able to verify products price display high to low successfully
    Given I am on homepage
    When I mouse hover and click on Laptops & Notebooks tab
    And I click on "Show All Laptops & Notebooks"
    And I select sort by "Price (High > Low)"
    Then I should be able to verify that the product is arranged in High to Low order


  @sanity @regression
  Scenario: User should be able to verify that user place order successfully
    Given I am on homepage
    When I mouse hover and click on Laptops & Notebooks tab
    And I click on "Show All Laptops & Notebooks"
    And I select sort by "Price (High > Low)"
    And I Select Product "MacBook"
    And I verify the productText "MacBook"
    And I click on "Add To Cart" button on MacBook page
    And I verify the MacBook message "Success: You have added MacBook to your shopping cart!"
    And I click on link “shopping cart” display on MacBook page
    And I verify the text "Shopping Cart" from MacBook page
    And I verify the text "MacBook" product name
    And I change the quantity "2"
    And I click on "Update" tab
    And I verify the message "Success: You have modified your shopping cart!" on MacBook page
    And I verify the Total £737.45
    And I click on "Checkout" button on MACBook page
    And I verify the text "checkout" on MacBook page shopping cart
    And I verify the text "New Customer" on MacBook page
    And I click on "Guest Checkout" radio button
    And I click on "Continue" tab on MacBook page
    And I enter below details in the form
      | John | Smith | john123@gmail.com | 056981239 | CrossWay | Slough | 363641 | United Kingdom | Cardiff |
    And I click on "Continue" Button on checkout page
    And I add comments about your order into text area
    And I check the Terms & Conditions check box
    And I click on continue
    Then I verify the message "Warning: Payment method required!" on checkout page
