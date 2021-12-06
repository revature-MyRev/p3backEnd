package com.revature.myrev.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefinition {
	WebDriver driver = new ChromeDriver();

	@Given("User is on Login Page$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
		
	}
	@When("User enters username and password")
	public void user_enters_username_username_and_password_password() {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		driver.findElement(By.name("username")).sendKeys("krishna123");
	    driver.findElement(By.name("password")).sendKeys("kkkk1234");
	    driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
	}

	//@When("User enters Username \"([^\"]*)\" and Password \"([^\"]*)\"")
	//public void user_enters_credentials_to_login(String username, String password) {
//	    driver.findElement(By.name("username")).sendKeys(username);
//	    System.out.println("username"+ driver.findElement(By.name("username")).toString());
//	    driver.findElement(By.name("password")).sendKeys(password);
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//	}

	@When("User click submit button")
	public void user_click_submit_button () {
		driver.findElement(By.name("btnSubmit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
//	@Then("Go to the home page")
//	public void go_to_the_home_page() {
//		driver.get("http://localhost:4200/feed" );
//	}
	@Then("User goes to feed page")
	public void user_goes_to_feed_page() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assertions.assertTrue(driver.getCurrentUrl().equals("http://localhost:4200/feed"), "Actual value was " + driver.getCurrentUrl());
	}
	

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully (String username) {
		//driver.findElement(By.name("success_popup")).findElement(By.name("btnOk")).click(); //????
		//driver.get("http://localhost:4200/feed" );
		
	}

	@Then("Login show error")
	public void login_show_error() {
		driver.findElement(By.name("fail_popup")).findElement(By.name("btnOk")).click(); //?????
		
	}
//
//	@When("Click the RevUp button")
//	public void click_the_rev_up_button() {
//		driver.findElement(By.name("btnRevUp")).click();
//		
//	}
//
//	@Then("Go to the registration page")
//	public void go_to_the_registration_page() {
//		driver.get("http://localhost:4200/register");
//	   
//	}
}
