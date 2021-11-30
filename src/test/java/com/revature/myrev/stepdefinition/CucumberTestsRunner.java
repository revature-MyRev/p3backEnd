package com.revature.myrev.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/"}, 
//		plugin = {"pretty",
//        "json:target/cucumber-report.json"},
		glue={"src/test/java/com/revature/myrev/stepdefinition"}
        )
public class CucumberTestsRunner {

}
