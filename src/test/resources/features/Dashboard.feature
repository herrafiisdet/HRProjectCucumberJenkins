Feature: Dashboard functionality

  @regression @tc107 @sprint2
  Scenario: Verify dashboard
    #Given user is navigated to HRMS application    // its in Hooks class now
    When  user enters valid username and valid password
    And   user clicks on login button
    Then  user is successfully logged in
    Then  user verify dashboard page
    Then user verify all the dashboard tabs
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|

    # here in @tc107 we are using Data table with values only and No Keys  this methode it mean using Methods of " LIST "
    # see explanation by Sohel cucumberbatch14 v#6 time: 1:40
