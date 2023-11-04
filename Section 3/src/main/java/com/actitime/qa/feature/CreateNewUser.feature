Feature: As the admin I should be able to create a new user in Actitime

  @TC_002
  Scenario Outline: Successfully creating a new user
    Given User is logged in as an admin
    And User in the Actitime Users Page
    When User clicks the new user button
    And User Enter the First Name as  "<firstName>"
    And User Enter the Last Name as  "<lastName>"
    And User Enter the Email as  "<email>"
    And User clicks the Save & Send Invitation button
    Then User should be created successfully with first name "<firstName>" and last name "<lastName>"
    Examples:
      | firstName | lastName | email |
      | Saroja | Pathirana | nethmi.pathirana@aiesec.net |