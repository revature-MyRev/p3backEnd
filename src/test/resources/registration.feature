Feature: Register new user
 
@tag1
Scenario: Successful Registration with Valid Credentials
Given User is on Registration Page
When User enters Username <username>, First Name <first_name>, Last Name <last_name>, Email <email>, & Password 1 <password_1>   
|username   |first_name   |last_name     |email              |password_1   |password_2   | 
|chatty     |Chatita      |The Brave     |chatty@email.com   |catnip       |catnip       | 
And Click the RevUp button
Then Message displayed Registration Successfully

@tag2
Scenario: Standard registration with invalid credentials
Given User is on Registration Page
When User enters Username <username>, First Name <first_name>, Last Name <last_name>, Email <email>, & Password 1 <password_1> 
And Click the RevUp button 
# Test for missing 1 piece of information
|username   |first_name   |last_name     |email              |password_1   | 
|           |Edgar        |The Old Man   |edgrrr@email.com   |tuna123      | 
|edgrrr     |             |The Old Man   |edgrrr@email.com   |tuna123      |
|edgrrr     |Edgar        |              |edgrrr@email.com   |tuna123      |
|edgrrr     |Edgar        |The Old Man   |                   |tuna123      |
|edgrrr     |Edgar        |The Old Man   |edgrrr@email.com   |tuna123      |
|edgrrr     |Edgar        |The Old Man   |edgrrr@email.com   |             |
# Test for missing 2 pieces of information
|           |             |The Old Man   |edgrrr@email.com   |tuna123      |  
|           |Edgar        |              |edgrrr@email.com   |tuna123      |
|           |Edgar        |The Old Man   |                   |tuna123      |
|           |Edgar        |The Old Man   |edgrrr@email.com   |             |
|edgrrr     |             |The Old Man   |                   |tuna123      |
|edgrrr     |             |The Old Man   |edgrrr@email.com   |             |
|edgrrr     |Edgar        |              |                   |tuna123      |
|edgrrr     |Edgar        |              |edgrrr@email.com   |             |
|edgrrr     |Edgar        |The Old Man   |                   |             |

    
# Test for missing 3 pieces of information
|           |             |              |edgrrr@email.com   |tuna123      |
|           |             |The Old Man   |                   |tuna123      |
|           |             |The Old Man   |edgrrr@email.com   |             |
|           |Edgar        |              |                   |tuna123      |
|           |Edgar        |              |edgrrr@email.com   |             |
|           |Edgar        |The Old Man   |                   |             |
|edgrrr     |             |              |                   |tuna123      |
|edgrrr     |             |              |edgrrr@email.com   |             |
|edgrrr     |             |The Old Man   |                   |             |
|edgrrr     |Edgar        |              |                   |             |
# Test for missing 4 pieces of information
|           |             |              |                   |tuna123      |
|           |             |              |edgrrr@email.com   |             |
|           |             |The Old Man   |                   |             |
|           |Edgar        |              |                   |             |
|edgrrr     |             |              |                   |             |
# Test for missing all  information
|           |             |              |                   |             |
# Test for already existing account
|chatty     |Chatita      |The Brave     |chatty@email.com   |catnip       |
# Test for password mismatch
|edgrrr     |Edgar        |The Old Man   |edgrrr@email.com   |tuna123      |
And User click RevUp button
Then Registration show error
  
 @tag3
 Scenario: Redirect to home page
 Given User is on Registration Page
 When Click the Log In button 
 Then Go to the home page