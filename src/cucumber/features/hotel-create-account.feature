Feature: Hotel create account
  Scenario Outline: Successful user account creation
    Given Login page opened: https://hotel-testlab.coderslab.pl/en/login?back=my-account
    When Unique email entered in 'email address' input box
    And Create an account button clicked
    And Form filled with data: <firstName>, <lastName>, <isMr>, <password>, <isNewsletter>, <isSpecialOffers>
    And Register button clicked
    Then User account creation success confirmation panel displayed
    And Take screenshot
Examples: 
    |firstName|lastName   |isMr |password    |isNewsletter|isSpecialOffers|
    |ala      | alowska   |false|password    | true       | false         |
    |adam     | romanowski|true |xyz123      | false      | true          |
    |lu       | xiaojun   |true |heavyLift!  | true       | true          |
