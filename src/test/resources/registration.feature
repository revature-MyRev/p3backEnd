Feature: Register new user
 
@tag1
Scenario: Successful Registration with Valid Credentials
Given User is on Registration Page
When User enters Credentials to Registration| testfname | testmname | testlastname | testage | testjob | testgender | Test@153.com | testuser_1 | testpassword | 
And User click submit button 
Then Message displayed Registration Successfully

@tag2
Scenario: Standard registration with invalid credentials
Given the user is on the Registration page
When the user enters a invalid Credentials
|           | testmname | testlastname | testage | testjob | testgender | Test@153.com | testuser_1 | testpassword | 
| testfname |           | testlastname | testage | testjob | testgender | Test@153.com | testuser_1 | testpassword | 
| testfname | testmname |              | testage | testjob | testgender | Test@153.com | testuser_1 | testpassword |
| testfname | testmname | testlastname | testage | testjob | testgender | Test@153.com |            | testpassword | 
| testfname | testmname | testlastname | testage | testjob | testgender | Test@153.com | testuser_1 |              | 
   
  And User click RevUp button
  Then Registration show error
  
 @tag3
 Scenario: Redirect to home page
 Given the user is on the registration page
 When Click the RevUp button 
 Then Go to the home page