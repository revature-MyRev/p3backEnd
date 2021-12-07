package com.revature.myrev.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	WebDriver driver;
	// Users users = new Users();

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mekri\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	@Given("User is on Login Page")
	public void user_is_on_login_page() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");

	}

	@When("User enters username <username> and password <password> User click submit button")
	public void user_enters_username_username_and_password_password_user_click_submit_button(DataTable table) {
		// List<String> data = table.row();
		List<List<String>> datas = table.asLists();
		System.out.println("Datatable" + datas.toString());
//		System.out.println(datas.get(0).toString());
//		System.out.println(datas.get(1).toString());
		for (int i = 1; i < datas.size(); i++) {
			if (datas.get(i).get(0) != null) {
				System.out.println(datas.get(0).toString());
				driver.findElement(By.name("username")).sendKeys(datas.get(i).get(0));
				System.out.println("data "+i+" " + datas.get(i).get(0).toString());
			}
			if (datas.get(i).get(1) != null) {
				driver.findElement(By.name("password")).sendKeys(datas.get(i).get(1));
				System.out.println("data "+i +" " + datas.get(i).get(1).toString());
			}
			driver.findElement(By.tagName("button")).click();
			// driver.findElement(By.name("password")).sendKeys(datas.get(i).get(1));
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		}

	}

	// @When("User enters Username \"([^\"]*)\" and Password \"([^\"]*)\"")
	// public void user_enters_credentials_to_login(String username, String
	// password) {
//	    driver.findElement(By.name("username")).sendKeys(username);
//	    System.out.println("username"+ driver.findElement(By.name("username")).toString());
//	    driver.findElement(By.name("password")).sendKeys(password);
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//	}

	@When("User click submit button")
	public void user_click_submit_button() {
		//driver.findElement(By.tagName("button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
//	@Given("User is on Login page")
//	public void user_is_on_login_Page() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		driver.get("http://localhost:4200");
//
//	}

//	@Then("Go to the home page")
//	public void go_to_the_home_page() {
//		driver.get("http://localhost:4200/feed" );
//	}
	@Then("User goes to feed page")
	public void user_goes_to_feed_page() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assertions.assertTrue(driver.getCurrentUrl().equals("http://localhost:4200/feed"),
				"Actual value was " + driver.getCurrentUrl());
	}

//	@When("User enters <username> and <password>")
//	public void user_enters_username_and_password(DataTable table) {
//		List<List<String>> datas = table.asLists();
////		System.out.println(datas.get(0));
////		System.out.println(datas.get(1));
//		try {
//			for (List<String> columns : datas) {
//				if (columns.get(0)!=null) {
//					driver.findElement(By.name("username")).sendKeys(columns.get(0));
//				}
//
//				driver.findElement(By.name("password")).sendKeys(columns.get(1));
//			}
//
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//		} finally {
//			driver.quit();
//		}
//
//	}

	@Then("Login show error")
	public void login_show_error() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assertions.assertTrue(driver.getCurrentUrl().equals("http://localhost:4200/"),
				"Actual value was " + driver.getCurrentUrl());
		// driver.close();
	}

//	@Then("Message displayed Login Successfully")
//	public void message_displayed_login_successfully (String username) {
//		//driver.findElement(By.name("success_popup")).findElement(By.name("btnOk")).click(); //????
//		//driver.get("http://localhost:4200/feed" );
//		
//	}
//
//	@Then("Login show error")
//	public void login_show_error() {
//		driver.findElement(By.name("fail_popup")).findElement(By.name("btnOk")).click(); //?????
//		
//	}
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
