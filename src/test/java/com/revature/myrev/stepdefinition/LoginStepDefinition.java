package com.revature.myrev.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	WebDriver driver = new ChromeDriver();

	@Given("^User is on Login Page$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200/");
		throw new io.cucumber.java.PendingException();
	}

	@When("^User enters Username \"(.*)\" and Password \"(.*)\"$")
	public void user_enters_credentials_to_login(String username, String password) {
	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
		throw new io.cucumber.java.PendingException();
	}

	@When("^User click submit button$")
	public void user_click_submit_button (String username) {
		driver.findElement(By.name("btnSubmit")).click();
		throw new io.cucumber.java.PendingException();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_login_successfully (String username) {
		driver.findElement(By.name("success_popup")).findElement(By.name("btnOk")).click(); //????
		driver.get("http://localhost:4200/" + username + "/home");
		throw new io.cucumber.java.PendingException();
	}

	@Then("^Login show error$")
	public void login_show_error() {
		driver.findElement(By.name("fail_popup")).findElement(By.name("btnOk")).click(); //?????
		throw new io.cucumber.java.PendingException();
	}

	@When("^Click the RevUp button$")
	public void click_the_rev_up_button() {
		driver.findElement(By.name("btnRevUp")).click();
		throw new io.cucumber.java.PendingException();
	}

	@Then("Go to the registration page")
	public void go_to_the_registration_page() {
		driver.get("http://localhost:4200/register");
	    throw new io.cucumber.java.PendingException();
	}
}
