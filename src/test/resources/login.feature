@tag1
Scenario: Successful Login with Valid Credentials
Given User is on Login Page
When User enters Username and Password
| testuser_1 | Test@153 |
And User click submit button 
Then Message displayed Login Successfully

 @tag2
 Scenario: Standard login with invalid credentials
 Given User is on Login page
 When User enters invalid Username or Password
 |username             |password        |
 |user1                |00000aa         |
 |                     |Test@153        |
 |testuser_1           |                |
 And User click submit button
 Then Login show error
  
 @tag3
 Scenario: Redirect to registration page
 Given The user is on the login page
 When Click the RevUp button 
 Then Go to the registration page