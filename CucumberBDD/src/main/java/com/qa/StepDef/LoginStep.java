package com.qa.StepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep {

	WebDriver driver;

	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page(){

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("^User enter username$")
	public void user_enter_username(){

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

	}

	@When("^User enters password$")
	public void user_enters_password(){

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	}

	@When("^Click on Login Button$")
	public void Click_on_Login_Button(){

		driver.findElement(By.name("Submit")).click();;
	}

	@Then("^User lands on Home Page$")
	public void user_lands_on_Home_Page(){
		
		System.out.println("User logged in");

	}

}
