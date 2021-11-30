package com.revature.myrev.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition {
	
	WebDriver driver = new ChromeDriver();

	@Given("^User is on Registration Page$")
	public void user_is_on_registration_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200/register");
		throw new io.cucumber.java.PendingException();
	}

	@When("^User enters Username \"(.*)\", First Name \"(.*)\", Last Name \"(.*)\", Email \"(.*)\", Password 1 \"(.*)\" & Password 2 \"(.*)\"$")
	public void user_enters_credentials_to_login(String username, String firstName, String lastName, String email, String password1, String password2) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password1")).sendKeys(password1);
        driver.findElement(By.name("password2")).sendKeys(password2);
		throw new io.cucumber.java.PendingException();
	}

	@When("^Click the RevUp button$") // Signing up button
	public void click_the_rev_up_button() {
		driver.findElement(By.name("btnRevUp")).click();
		throw new io.cucumber.java.PendingException();
	}

	@Then("^Message displayed registration Successfully$")
	public void message_displayed_registration_successfully(String username) {
		driver.findElement(By.name("sucess_popup")).findElement(By.name("btnOk")).click();
		driver.get("http://localhost:4200/" + username + "/home");
		throw new io.cucumber.java.PendingException();
	}

	@Then("^Registration show error$")
	public void registration_show_error() {
		driver.findElement(By.name("fail_popup")).findElement(By.name("btnOk")).click();
		throw new io.cucumber.java.PendingException();
	}

	@When("^Click the Log In button$")
	public void click_the_log_in_button() {
		driver.findElement(By.name("btnLogin")).click();
		throw new io.cucumber.java.PendingException();
	}
	
	@Then("^Go to the home page$")
	public void go_to_the_home_page() {
	    driver.get("http://localhost:4200/");
	    throw new io.cucumber.java.PendingException();
	}
}
