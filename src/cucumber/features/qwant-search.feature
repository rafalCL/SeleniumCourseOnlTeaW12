Feature: Qwant search

  Scenario Outline: Search for "<searchPhrase>" in https://www.qwant.com/
    Given Web page https://www.qwant.com/ opened in browser
    When Search phrase "<searchPhrase>" entered in search input box
    And key enter pressed
    Then First <resultsCount> search results titles contain phrase "<searchPhrase>"
Examples:
      |searchPhrase         |resultsCount|
      |W pustyni i w puszczy| 5          |
      |Pharaoh              | 3          |
