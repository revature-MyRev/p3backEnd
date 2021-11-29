package com.revature.myrev.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\anjali\\Documents\\GitHub\\p3backEnd\\src\\test\\resources\\login.feature", 
		plugin = {"pretty",
        "json:target/cucumber-report.json"},
		glue={"classpath:com.revature.myrev.stepdefiniton.LoginStepDefinition.java"}
        )
public class CucumberTestsRunner {

}
