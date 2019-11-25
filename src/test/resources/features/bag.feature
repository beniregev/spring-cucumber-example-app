Feature: Bag Functionality

  Scenario: Putting one thing in the bag
    Given the bag is empty
    When I put 2 potato in the bag
    Then the bag should contain only 2 potato

  Scenario: Putting few things in the bag
    Given the bag is empty
    When I put 5 potato in the bag
    And I put 4 carrot in the bag
    And I put 2 cucumber in the bag
    Then the bag should contain 5 potato
    And the bag should contain 4 carrot
    And the bag should contain 2 cucumber