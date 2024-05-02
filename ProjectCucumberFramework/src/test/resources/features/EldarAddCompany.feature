@regression @eldarapp @addcompany
Feature: Validating Add Company Creation

  Background: Add Company setup
    Given user navigates to EldarApp
    When user logs in with username "student1@mindtekbootcamp.com" and password "mindtek109"
    And user clicks on Company List icon
    And user clicks on Add Company button


  @Dotinput @DOT#maxCharacters
  Scenario: Validating upper boundary input and max of DOT#
    When user clicks on DOT field
    And user inputs "12345678901"
    Then validates that "1234567890" appears


  @DOTinput @DOT#minCharacters
  Scenario: Validating lower boundary input and min of DOT#
    When user clicks on DOT field
    And user inputs "12345"
    Then validates that error message "Min length is 6 characters, currently it is 5" appears

  @Dotinput @requiredDOTInput
  Scenario: Validating DOT input is a required field
    When user clicks on DOT field
    And user inputs one character "1"
    And user clears the input
    Then user validates error message "This field is required." appears


  @dotDigitsOnly
  Scenario Outline: Validate DOT input only accepts numbers
    When user clicks on DOT field
    And user input "<Data>" into DOT field
    Then user validates the if error msg appears "<Result>"
    Examples:
      | Data           | Result             |
      | asdasd         | Enter only digits. |
      | !@$%^&*()      | Enter only digits. |
      | 12345678asdasd | Enter only digits. |

  @uniqueValues @dot#
  Scenario: Validate DOT input only takes unique values, when creating a company.
    When user clicks on DOT field
    And user creates a company with test data and using random numbers for MC and DOT inputs
      | Name | Phone      | Street     | City    | State   | Zip code | Email         | Insurance(producer company name) | Calender Day | Policy number | Employer id number |
      | ABCDOT INPUT  | 1231231231 | 123 asdasd | Chicago | Alabama | 12232    | qwe@gmail.com | Blu cross                        | 30           | 123123123123  | 12-1212121         |
    Then user verifies that the error message "This DOT number is already in use." appears
#



  @uniqueValues @mc#
  Scenario: Validate MC input only takes unique values, when creating a company.
    And user creates a company with test data.
      | Name        | Phone      | Street     | City    | State   | Zip code | Email         | Insurance(producer company name) | Calender Day | Policy number | Employer id number |
      | ABCMC INPUT | 1231231231 | 123 asdasd | Chicago | Alabama | 12232    | qwe@gmail.com | Blu cross                        | 30           | 123123123123  | 12-1212121         |
    Then user verifies that using the same data for mc input will make the error message "This MC number is already in use." appear
#
  @iftaSelectOptions
  Scenario: Validating IFTA has a list of select values
    When user clicks on IFTA field
    Then user identifies 2 options no "No" and yes "Yes"


  @mc @regression @maxMin
  Scenario Outline: Validating MC input MaxMin
    When : user inputs data "<Data>" into MC field
    Then : user validates the correct output "<Output>" appears
    @max
    Examples:
      | Data       | Output     |
      | 1234567899 | 1234567899 |
    @min
    Examples:
      | Data | Output |
      | 1234 | 1234   |
    @max+
    Examples:
      | Data        | Output     |
      | 12345678991 | 1234567899 |
    @min-
    Examples:
      | Data | Output                                        |
      | 123  | Min length is 4 characters, currently it is 3 |


  @mc @required
  Scenario: Validating MC is a required field
    When : user inputs data "1" into MC field
    And user deletes the data in MC field
    Then : user verifies error "This field is required." appears



    ## missing test case scenario 7 unique characters for MC
  ## test case 15 for dot uniqe values only
  ## and then redo the input max and min to include all four examples for DOT input


  @insurance @maxCharacters @insuranceMaxChars
  Scenario: Validate that max input of 50 characters for insurance field
    When user inputs data "aaaaaaaaaaaaaaaaaaaaaafffffffffffffffffeeeeeeeeeeez" into the insurance field
    Then user identifies output expectation "aaaaaaaaaaaaaaaaaaaaaafffffffffffffffffeeeeeeeeeee" in insurance field

  @insurance @required @insuranceRequired
  Scenario: Validate that the insurance field is a required field
    When user inputs data "A" into the insurance field
    And user clears the insurance input field
    Then user validates error message "This field is required." appears

  @insurance @insuranceTextField
  Scenario: Validate that the insurance field is a text field
    When user inputs data "ABC" into the insurance field
    Then user validates data "ABC" appears in the insurance field

  @insurance @insuranceInvalidCharacters
  Scenario: Validate that an error message appears when using invalid characters as input for insurance field
    When user inputs data "@" into the insurance field
    Then user validates error message "Invalid input" appears

  @policyEffectiveDayIsSelect @insurance
  Scenario: Validate that the Policy effective day field is not a text field
    When user clicks on Policy effective day field and selects the day "1"
    Then user identifies the selected date "04/01/2024" appears in the Policy effective day field

  @typeOfInsuranceMaxChars @insurance
  Scenario: Validate that max input of 50 characters for type of insurance field
    When user inputs data "aaaaaaaaaaaaaaaaaaaaaafffffffffffffffffeeeeeeeeeeez" into the type of insurance field
    Then user identifies output expectation "aaaaaaaaaaaaaaaaaaaaaafffffffffffffffffeeeeeeeeeee" in type of insurance field

  @typeOfInsuranceInvalidInput @insurance
  Scenario: Validate that error message appears when inputting invalid characters into type of insurance field
    When user inputs data "@" into type of insurnace field
    Then user validates error message "Invalid input" appears












