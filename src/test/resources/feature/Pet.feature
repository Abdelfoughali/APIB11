Feature: Test all pet operations
  Scenario: Create pet
    Given i have a valid url to create a pet
    When  i send POST request to create a pet
    Then status code should be 200
    And response should be json format


    Scenario:  Get a pet
      Given  i have a valid url to get a pet
      When i send a GET request to retireive a pet with 223344 id
      Then  status code 200
    And response body should cpntain 223344 id

      Scenario: Update a pet
        Given i have a valid url to update a pet
        When I send PUT request to update a pet
        Then  the status code should 200
        And response should be application_json


      Scenario: Delete a pet
        Given i have a valid url to delete a pet
        When I send delete request to delete a pet with id 3436462
        Then   status code should 200
        And pet id 435290 should not exist