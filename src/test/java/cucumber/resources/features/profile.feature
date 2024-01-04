Feature: Profile Management on KasirAja Dashboard

  Scenario: User successfully edits profile account

    Given the user is logged into KasirAja with "malio@store.com" in email field and "malio123" in password field
    And is on the KasirAja dashboard
    When navigat e to edit profile account page
    And the user clear all the fields
    And updates the profile with "malio store" in the nama field and "malio@store.com" in email field
    And the user click "simpan" button
    Then the users navigate to user management page

  Scenario: User accesses the profile editing page without making changes

    Given user logged into KasirAja with "malio@store.com" in email field and "malio123" in password field
    And is on the KasirAja dashboard
    And navigate to edit profile account page
    When the user click "simpan" button
    And the message should not be "success toko berhasil diubah"
    Then the system should display error message

  Scenario: User edits profile account with invalid format email

    Given user logged into KasirAja with "malio@store.com" in email field and "malio123" in password field
    And is on the KasirAja dashboard
    And navigate to edit profile account page
    When the user clear all the fields
    And updates the profile with "malio store" in the nama field and "compose.store.com" in email field
    And the user click "simpan" button
    Then the system should display error message

  Scenario: User edits profile account with empty email

    Given user logged into KasirAja with "malio@store.com" in email field and "malio123" in password field
    And is on the KasirAja dashboard
    And navigate to edit profile account page
    When the user clear all the fields
    And updates the profile with "compose store" in the nama field and "" in email field
    And the user click "simpan" button
    Then the system should display error message

  Scenario: User edits profile account with empty nama

    Given user logged into KasirAja with "malio@store.com" in email field and "malio123" in password field
    And is on the KasirAja dashboard
    And navigate to edit profile account page
    When the user clear all the fields
    And updates the profile with "" in the nama field and "compose@store.com" in email field
    And the user click "simpan" button
    Then the system should display error message




