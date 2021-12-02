Feature: Follow button
  Scenario: Pressing Follow button
    Given I am on a user profile
      When I press the follow button
      Then I should be following that user