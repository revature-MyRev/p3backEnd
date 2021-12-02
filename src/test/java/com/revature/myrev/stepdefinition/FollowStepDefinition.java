package com.revature.myrev.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FollowStepDefinition {
	
    @Given("^I am on a user profile$")
    public void search() throws Throwable {
        System.out.println("on user profile");
    }
    
    @When("^I press the follow button$") 
    public void enterIntoSearch() throws Throwable{
        System.out.println("pressed follow");
    }
    
    @Then("^I should be following that user$")
    public void checkSearch() throws Throwable{
        System.out.println("user is followed");
    }

}
