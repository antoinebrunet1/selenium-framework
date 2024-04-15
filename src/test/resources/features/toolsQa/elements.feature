Feature: Tools QA Elements

  @textBox
  Scenario Outline: Text Box
    Given I navigate to the text-box page
    And I enter "<fullName>" as the full name
    And I enter "<email>" as the email
    And I enter "<currentAddress>" as the current address
    And I enter "<permanentAddress>" as the permanent address

    Examples:
      | fullName       | email          | currentAddress    | permanentAddress  |
      | Antoine Brunet | test@gmail.com | 123, False Street | 123, False Street |
