Feature: Hotel create account
  Scenario: Successful user account creation
    Given Login page opened: https://hotel-testlab.coderslab.pl/en/login?back=my-account
    When Unique email entered in 'email address' input box
    And Create an account button clicked
    And Form filled with data: ala, alowska, false, password, true, false
    And Register button clicked
    Then User account creation success confirmation panel displayed
