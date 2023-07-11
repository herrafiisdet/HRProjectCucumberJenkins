Feature: Add Employee

  Background:
    When user enters valid username and valid password
    And user clicks on login button
    Then  user is successfully logged in
    When user clicks on PIM option
    And user clicks on Add Employee button

    # 1- parameters passing using hardcoded data
  @regression @sprint3
  Scenario: Adding one employee
    #Given user is navigated to HRMS application   // its in Hooks class now
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully
  #************************************************************************************************
  # 2- parameters passing by passing one set of data from feature file
  @regression @test1
    Scenario: Adding one employee using feature file
      And user enters "Zalam" and "Alia"
      And user clicks on save button
      Then employee added successfully
  #*************************************************************************************************
  # 3- parameters passing using scenario outline -Example table:for passing multiple data sets.
  @regression @outline
    Scenario Outline: Adding multiple employees using feature file Scenario Outline
      #here will use Data driven testing=> one script execute multiple sets of data.
      And user  enters "<firstName>" and "<lastName>" for adding multiple employees
      And user clicks on save button
      Then employee added successfully
      Examples:
        | firstName | lastName |
        | gulnam    |mazar     |
        |rampal     |chambel   |
        |azam       |asel      |
  #**************************************************************************************************
  # 4- parameters passing using Data table : here hooks and background execute one time for multiple data sets.
  @regression @datatable @tc106
    Scenario: Adding multiple employees using data table
      When user adds multiple employees and verify they are added successfully
      |firstName|middleName|lastName|
      |zara     |MS        |camilullah|
      |birgul   |MS        |ozgin     |
      |alina    |MS        |bob       |

      #**** DATA TABLE ==>  LIST OF MAPS ***
      # above on @tc106 we used Data table where we have keys and values each raw with head is a map , x by 3 became
      # a list of maps.  (see Dashboard.feature for a  Data table with  Values only so we will use LIST methode only and not map od list )
      # see explanation by Sohel cucumberbatch14 v#6 time: around 1:40

  #***************************************************************************************************
  # 5- parameters passing using Excel -  to pass large volume of data.

  @regression @excel
  Scenario: Adding multiple employees using excel file
    When user adds multiple employee from excel using "EmployeeDataNoPicture" and verify it


    #*************************************************************************************************
  # 6- we also can pass data using config.properties file.
                              #@@@ All above shows all the approaches that we can perform for passing data.


  #@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

                                            #***  Data Base ***#



