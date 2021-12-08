Feature: Log in

  @tag2
  Scenario: Standard login with invalid credentials
    Given User is on Login Page
    When User enters username <username> and password <password> User click submit button
      # Test for missing information
      | username   | password |
      |            | Test@153 |
      | testuser_1 |          |
      |            |          |
    # Test for invalid user name
    #|fakename             |testing         |
    # Test for invalid password
    #|testing              |fakepassword    |
    # Test for invalid user name and password
    # |fakename             |fakepassword    |
    Then Login show error

  @tag1
  Scenario: Successful Login with Valid Credentials
    Given User is on Login Page
    When User enters username <username> and password <password> User click submit button
      | username   | username |
      | krishna123 | kkkk1234 |
    Then User goes to feed page

  @tag3
  Scenario: Redirect to registration page
    Given User is on Login Page
    When Click the register button
    Then Go to the registration page
    When User enters Username <username>, First Name <first_name>, Last Name <last_name>, Email <email>, & Password <password>
      | username | first_name | last_name | email            | password |
      | chatty   | Chatita    | The Brave | chatty@email.com | catnip   |
    And Click the RevUp button
    Then User goes to login page
    When User enters username <username> and password <password> User click submit button
      | username | username |
      | chatty   | catnip   |
    Then User goes to feed page
    
