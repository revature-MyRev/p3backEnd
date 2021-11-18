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
 Feature: Login feature
  I want to use this template for login
  
  Scenario: Successful Login with Valid Credentials
	Given User is on Login Page
	When User enters Credentials to Login
    | testuser_1 | Test@153 |
   And User click submit button 
	Then Message displayed Login Successfully

  @tag2
  Scenario: Standard login with invalid credentials
  Given the user is on the Login page
  When the user enters a invalid Credentials
  |     username        |  00000aa       |
  |                     |  Test@153       |
  |   testuser_1        |                 |
  And User click submit button
  Then Login show error
 @tag3
 Scenario: Redirect to registration page
 Given the user is on the login page
 When Click the RevUp button 
 Then Go to the registration page