Feature:  Login functionality

  @regression @sprint1 @tc100
  Scenario: Valid admin login
    #Given user is navigated to HRMS application  // its in Hooks class now
    When  user enters valid username and valid password
    And   user clicks on login button
    Then  user is successfully logged in

  @regression @tc101
  Scenario: Valid employee login
    #Given user is navigated to HRMS application // its in Hooks class now
    When user enters employee username and employee password
    And   user clicks on login button
    Then  user is successfully logged in

  @regression @tc102
  Scenario: Invalid admin login
    #Given user is navigated to HRMS application // its in Hooks class now
    When user enters invalid username and invalid password
    And user clicks on login button
    Then error message displayed

  @regression @tc105
  Scenario Outline: Invalid login functionality
    When user enters different "<username>" and "<password>" and verify the "<error>" for it
    Examples:
      | username | password | error |
      |admin     |cristiano |Invalid credentials|
      |ronaldo   |Hum@nhrm123|Invalid credentials|
      |          |Hum@nhrm123|Username cannot be empty|
      |admin     |           |Password cannot be empty|


