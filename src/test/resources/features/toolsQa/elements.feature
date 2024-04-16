@toolsQaElements
Feature: Tools QA Elements

  @textBox
  Scenario Outline: Text Box
    Given I navigate to the text-box page
    And I enter "<fullName>" as the full name
    And I enter "<email>" as the email
    And I enter "<currentAddress>" as the current address
    And I enter "<permanentAddress>" as the permanent address
    And I click on submit
    Then I see the entered full name "<fullName>" in the box below the submit button
    Then I see the entered email "<email>" in the box below the submit button
    Then I see the entered current address "<currentAddress>" in the box below the submit button
    Then I see the entered permanent address "<permanentAddress>" in the box below the submit button

    Examples:
      | fullName       | email          | currentAddress    | permanentAddress  |
      | Antoine Brunet | test@gmail.com | 123, False Street | 123, False Street |

  @checkBox
  Scenario: Check Box
    Given I navigate to the check box page
    And I select Notes which is under Desktop which is under Home
    Then I see the message indicating I have selected Notes

  @radioButton
  Scenario: Radio Button
    Given I navigate to the radio button page
    And I select Yes
    Then I see the message indicating I have selected Yes

  @tableDeleteFirstRow
  Scenario: Delete First Row in Table
    Given I navigate to the table page
    And I click on delete for the first row
    Then I see the row I deleted is no longer present

  @tableModifyFirstRow
  Scenario Outline: Modify First Row in Table
    Given I navigate to the table page
    And I click on modify for the first row
    And I change the first name to "<newFirstName>"
    And I click on submit
    Then I see the first row now has the first name "<newFirstName>"

    Examples:
      | newFirstName |
      | Antoine      |

  @tableAddRow
  Scenario Outline: Add Row in Table
    Given I navigate to the table page
    And I click on add
    And I enter "<firstName>" for the first name
    And I enter "<lastName>" for the last name
    And I enter "<email>" for the email
    And I enter "<age>" for the age
    And I enter "<salary>" for the salary
    And I enter "<department>" for the department
    And I click on submit
    Then I see the first name of the new row is "<firstName>"
    Then I see the last name of the new row is "<lastName>"
    Then I see the age of the new row is "<age>"
    Then I see the email of the new row is "<email>"
    Then I see the salary of the new row is "<salary>"
    Then I see the department of the new row is "<department>"

    Examples:
      | firstName | lastName | email          | age | salary | department |
      | Antoine   | Brunet   | test@email.com | 50  | 90000  | Sales      |

  @buttonsDoubleClick
  Scenario: Double Click for Buttons
    Given I navigate to the buttons page
    And I double click on the first button
    Then I see the message indicating I have done a double click

  @buttonsRightClick
  Scenario: Double Click for Buttons
    Given I navigate to the buttons page
    And I right click on the second button
    Then I see the message indicating I have done a right click