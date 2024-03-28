Feature: Testing of registration page

  Background: I am on the registration page
    Given Set up driver Selenide

  @Selenide
  Scenario Outline: Registration with correct data
    When I am on Registration page Selenide
    And I set '<firstName>'to FirstName field Selenide
    And I set '<lastName>'to LastName field Selenide
    And I set '<dateOfBirth>'to DateOfBirth field Selenide
    And I set '<email>'to Email field Selenide
    And I set '<password>'to Password field Selenide
    And I set '<confirmPassword>'to ConfirmPassword field Selenide
    Then I click on Submit button Selenide

    Examples:
      | firstName | lastName | dateOfBirth | email               | password   | confirmPassword |
      | Alexey    | Smirnov  | 09.01.2000  | smirnov00@gmail.com | uzbekistan | uzbekistan      |

  @Selenide
  Scenario Outline: Registration with date of birth from the future
    When I am on Registration page Selenide
    And I set '<firstName>'to FirstName field Selenide
    And I set '<lastName>'to LastName field Selenide
    And I set '<dateOfBirth>'to DateOfBirth field Selenide
    And I set '<email>'to Email field Selenide
    And I set '<password>'to Password field Selenide
    And I set '<confirmPassword>'to ConfirmPassword field Selenide
    Then I click on Submit button Selenide

    Examples:
      | firstName  | lastName | dateOfBirth | email            | password     | confirmPassword |
      | Oleksander | Petrenko | 07.05.2034  | petr34@gmail.com | polandpoland | polandpoland    |

  @Selenide
  Scenario Outline: Registration without matching passwords
    When I am on Registration page Selenide
    And I set '<firstName>'to FirstName field Selenide
    And I set '<lastName>'to LastName field Selenide
    And I set '<dateOfBirth>'to DateOfBirth field Selenide
    And I set '<email>'to Email field Selenide
    And I set '<password>'to Password field Selenide
    And I set '<confirmPassword>'to ConfirmPassword field Selenide
    And I click on Andersen logo Selenide
    Then I check passwords must match error message is displayed Selenide


    Examples:
      | firstName | lastName | dateOfBirth | email               | password   | confirmPassword |
      | Alexey    | Smirnov  | 03.01.1986  | smirnov86@gmail.com | uzbekistan | uzbekistan#%748 |
