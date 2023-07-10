Feature: US-321 Searching the employee
  Background:
    When user enters valid username and valid password
    And user clicks on login button
    Then  user is successfully logged in
    When user clicks on PIM option
    And user clicks on EmployeeList option

  @regression @sprint4 @Smoke
  Scenario: Search employee by id
    #Given user is navigated to HRMS application             // its in Hooks class now
    #When user enters valid username and valid password      // MOVED TO BACKGROUND
    #And user clicks on login button                         // MOVED TO BACKGROUND
    #Then  user is successfully logged in                    // MOVED TO BACKGROUND
    #When user clicks on PIM option                          // MOVED TO BACKGROUND
    #And user clicks on EmployeeList option                  // MOVED TO BACKGROUND
    When user enter valid employee id
    And user clicks on search button
    Then user see employee information is displayed

  @regression @sprint4 @Smoke @tc001
  Scenario: Search employee by name
    #Given user is navigated to HRMS application               // its in Hooks class now
    #When user enters valid username and valid password        // MOVED TO BACKGROUND
    #And user clicks on login button                           // MOVED TO BACKGROUND
    #Then  user is successfully logged in                      // MOVED TO BACKGROUND
    #When user clicks on PIM option                            // MOVED TO BACKGROUND
    #And user clicks on EmployeeList option                    // MOVED TO BACKGROUND
    When user enter valid employee name
    And user clicks on search button
    Then user see employee information is displayed