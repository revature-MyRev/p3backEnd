package com.revature.myrev.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "cucumbertests")
public class CucumberTestsRunner {

}
