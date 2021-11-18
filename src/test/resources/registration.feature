#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

 @tag1
 Feature: Registration feature
  I want to use this template for registration
  
  Scenario: Successful Registration with Valid Credentials
	Given User is on Registration Page
	When User enters Credentials to Registration
    | testfname | testmname | testlastname | testage | testjob | testgender | Test@153.com | testuser_1 | testpassword | 
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