Feature: Login Page KasirAja System
@Positive
  Scenario: User wants to log in using registered email and password
    Given Login Page kasirAja
    When Input email "malio@store.com"
    And Input Password "malio123"
    And Click login button
    Then User in on dashboard page
@Negative
  Scenario: User wants to log in using empty email and password
    Given Login Page kasirAja
    When Input email ""
    And Input Password ""
    And Click login button
    Then User get error message

  Scenario: User wants to log in using empty email
    Given Login Page kasirAja
    When Input email ""
    And Input Password "malio123"
    And Click login button
    Then User get error message

  Scenario: User wants to log in using empty password
    Given Login Page kasirAja
    When Input email "malio@store.com"
    And Input Password ""
    And Click login button
    Then User get error message

  Scenario: User wants to log in using invalid email
    Given Login Page kasirAja
    When Input email "malio123@store.com"
    And Input Password "malio123"
    And Click login button
    Then User get error message

  Scenario: User wants to log in using invalid password
    Given Login Page kasirAja
    When Input email "malio@store.com"
    And Input Password "malio129"
    And Click login button
    Then User get error message

  Scenario: User wants to log in using invalid format email
    Given Login Page kasirAja
    When Input email "malio.store.com"
    And Input Password "malio123"
    And Click login button
    Then User get error message
