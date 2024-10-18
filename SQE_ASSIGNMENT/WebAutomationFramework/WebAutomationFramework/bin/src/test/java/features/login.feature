Feature: Login Functionality

  Scenario Outline: Login with different credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    Then the user should be redirected to the homepage

  Examples:
    | username         | password       |
    | valid_username   | valid_password  |
    | invalid_username | invalid_password|
