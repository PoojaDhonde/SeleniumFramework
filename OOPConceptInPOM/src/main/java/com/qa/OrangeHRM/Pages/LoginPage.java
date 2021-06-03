package com.qa.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	//page locators:

	private By userNameBox = By.id("txtUsername");
	private By passwordBox = By.id("txtPassword");
	private By loginButton = By.name("Submit");
	private By headerText = By.xpath("//div[@id = 'content']//span[text()='( Username : Admin | Password : admin123 )']");
	private By errorMsg = By.xpath("//span[@id = 'spanMessage']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//getter method

	public WebElement getUserNameBox() {
		return getElement(userNameBox);
	}

	public WebElement getPasswordBox() {
		return getElement(passwordBox);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	public WebElement getHeaderText() {
		return getElement(headerText);
	}
	
	public WebElement getErrorMsg() {
		return getElement(errorMsg);
	}

	//action methods

	public String getLoginPageTitle() {
		return getPageTitle();
	}

	public String getLoginPageHeader() {
		return getPageHeader(headerText);
	}

	public HomePage doLogin(String username, String password) {
		getUserNameBox().sendKeys(username);
		getPasswordBox().sendKeys(password);
		getLoginButton().click();

		return getInstance(HomePage.class);
	}

	public String doLogin(String username) {
		getUserNameBox().sendKeys(username);
		getLoginButton().click();
		return getErrorMsg().getText();
		
	}
		
	public String doLogin() {
		getLoginButton().click();
		return getErrorMsg().getText();
		
	}


}
