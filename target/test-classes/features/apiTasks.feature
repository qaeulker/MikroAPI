
Feature: Test API


  Scenario: 1. Task: get/pet/findByStatus
    When send GET request to api and verify status code

  Scenario: 2. Task: post/pet
    When send POST request to api and verify status code

  Scenario: 3. Task: put/user/{username}
    When send PUT request to api and verify status code and updatedID "100"

  Scenario: 4. Task: delete/user/{username}
    Given create user "williamlily" via api and send DELETE request to api verify status code


  @nur
  Scenario: 5. Task: get/pet/findByStatus Negative Case
    When send wrong GET request to api and verify status code
  @nur
  Scenario: 6. Task: post/pet Negative Case
    When send wrong POST request to api and verify status code
  @nur
  Scenario: 7. Task: put/user/{username} Negative Case
    When send wrong PUT request to api and verify status code and updatedID "100"
  @nur
  Scenario: 8. Task: delete/user/{username} Negative Case
    Given create user "williamloves" via api and send wrong DELETE request to api verify status code


