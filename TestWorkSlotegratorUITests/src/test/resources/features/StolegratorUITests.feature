Feature: Test work in Stolegrator

  Scenario: Authorization in admin page
    Given I go to auth page
    And I login as "admin1" with password "[9k<k8^z!+$$GkuP"
    Then User Successfully authorized, the admin panel has loaded

  Scenario: Open list of players
    Given I go to auth page
    And I login as "admin1" with password "[9k<k8^z!+$$GkuP"
    And Click on the list of players button
    Then Checking if there is a table with players on the page

  Scenario: Checking sorting by column Date of registration
    Given I go to auth page
    And I login as "admin1" with password "[9k<k8^z!+$$GkuP"
    And Click on the list of players button
    And Click on a column 'Registration Date' name to sort
    Then Checking that the table is correctly sorted by the 'Registration Date' column

