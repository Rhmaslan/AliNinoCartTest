Feature: Search and add book to cart

  Scenario: Search experience for a product and adding to cart
    Given User is on landing page
    When User searches for "Mahmud" keyword
    Then User clicks on cart icon
    And item added to cart


