@All
Feature: To test the Bus functionality to book bus ticket

  Background: 
    Given User is on homepage

  #Functional Testing
  @Search
  Scenario Outline: To validate search functionality to book bus ticket
    When User enters the "<source>" Source
    And User enters the "<destination>" destination
    And User enters the "<date>" of travel
    And click on search
    Then buses from source to destination should be displayed

    Examples: 
      | source  | destination | date |
      | Mumbai | Bengalore   |   24 |

  #Functional Testing
  @InvalidSearch
  Scenario: To validate that source city and destination city can not be same
    When User enters the From value
      | Bhopal |
    And User enters the To value
      | Bhopal |
    Then error message should be displayed

  #Functional Testing
  @Filter1
  Scenario: To validate user preferences based on AC, seat type and single window seats
    When User selects on non-AC button
    And User selects on sleeper button
    And User clicks on single seater option
    Then list of buses which provides non-AC, sleeper and single seater services will be displayed

  #Functional Testing
  @Filter2
  Scenario: To validate user preferences based on pickup point, drop point and travel operators
    When User selects pickup point
     | Kharghar |
    And User selects drop point
     | Hinje Wadi |
    And User selects travel operators
     | VRL Travels |
    Then list of buses which satisfies specific pickup point, drop point and travel operators will be displayed

  #Functional Testing
  @SortBy
  Scenario: To validate user can select fastest functionality and cheapest functionality simultaneously
    When User clicks on fastest option
    And User clicks on cheapest option
    Then list of buses in the order of fastest and cheapest bus first will be displayed
