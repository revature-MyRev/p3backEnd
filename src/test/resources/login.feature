Feature: Log in

@tag1
Scenario: Successful Login with Valid Credentials
Given User is on Login Page
When User enters Username <username> and Password <password>
|username    |password  |
| testuser_1 | Test@153 |
And User click submit button 
Then Message displayed Login Successfully

 @tag2
 Scenario: Standard login with invalid credentials
 Given User is on Login page
 When User enters Username <username> and Password <password>
 # Test for missing information
 |username             |password        |
 |                     |Test@153        |
 |testuser_1           |                |
 |                     |                |
 # Test for invalid user name
 |fakename             |testing         |
 # Test for invalid password
 |testing              |fakepassword    |
 # Test for invalid user name and password
 |fakename             |fakepassword
 And User click submit button
 Then Login show error
  
 @tag3
 Scenario: Redirect to registration page
 Given The user is on the login page
 When Click the RevUp button 
 Then Go to the registration page