Feature: Registration Page KasirAja System

  Scenario: User registers with correct credentials
    Given the user opens the web and navigates to the URL
    When the user clicks on the register page
    And the user enters "ateez store" in the nama field
    And the user enters "ateeez@store.com" in the email field
    And the user enters "ateez123" in the password field
    And the user submits the registration form
    Then a success message appears

  Scenario: User wants to register with existing email
    Given the user opens the web and navigates to the URL
    When the user clicks on the register page
    And the user enters "berkah store" in the nama field
    And the user enters "ateeez@store.com" in the email field
    And the user enters "berkah123" in the password field
    And the user submits the registration form
    Then a error message appears

  Scenario: User wants to register with invalid format email
    Given the user opens the web and navigates to the URL
    When the user clicks on the register page
    And the user enters "berkah store" in the nama field
    And the user enters "berkah.store.com" in the email field
    And the user enters "berkah123" in the password field
    And the user submits the registration form
    Then a error message appears

  Scenario: User wants to register with empty nama toko
    Given the user opens the web and navigates to the URL
    When the user clicks on the register page
    And the user enters "" in the nama field
    And the user enters "berkah@store.com" in the email field
    And the user enters "berkah123" in the password field
    And the user submits the registration form
    Then a error message appears

  Scenario: User wants to register with empty email
    Given the user opens the web and navigates to the URL
    When the user clicks on the register page
    And the user enters "berkah store" in the nama field
    And the user enters "" in the email field
    And the user enters "berkah123" in the password field
    And the user submits the registration form
    Then a error message appears

  Scenario: User wants to register with empty password
    Given the user opens the web and navigates to the URL
    When the user clicks on the register page
    And the user enters "berkah store" in the nama field
    And the user enters "berkah@store.com" in the email field
    And the user enters "" in the password field
    And the user submits the registration form
    Then a error message appears



