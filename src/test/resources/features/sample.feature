Feature: Sample feature

  Scenario: User tries to login
    Given user opens web browser
    When user navigates to login page
    Then user should see login form
    When user enters valid username
    And user enters valid password
    And user enters submit button
    Then user should be logged in successfully
    And user selects dropdown option
    Then user closes web browser

