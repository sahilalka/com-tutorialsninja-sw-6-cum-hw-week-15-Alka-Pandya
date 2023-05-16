Feature: Desktops Test
  As user I want to verify the product arranged in alphabetical order

  @regression @sanity
  Scenario: User should be able to verify the product arranged in alphabetical order
    Given I am on homepage
    When I mouse hover and click on Desktops tab
    And I pass selectMenu method name "Show AllDesktops"
    And I select sort by position "Name (Z - A)"
    Then I should be able to verify that the product is arranged in descending order

  @regression @smoke
  Scenario: User should be able to verify that product is added to shopping cart successfully
    Given I am on homepage
    When I mouse hover and click on Desktops tab
    And I pass selectMenu method name "Show AllDesktops"
    And I select sort by position "Name (A - Z)"
    And I click on product "HP LP3065"
    And I verify the text "HP LP3065"
    And I Select Delivery Date "2022-11-30"
    And I enter qty "1"
    And I click on “Add to Cart” button
    And I verify the message "Success: You have added HP LP3065 to your shopping cart!"
    And I click on link "shopping cart"
    Then I Verify the shopping cart with below values
      | heading       | productName | deliveryDate | model     | total  |
      | Shopping Cart | HP LP3065   | Delivery Date:2023-11-30  | Product 21 | $122.00 |

