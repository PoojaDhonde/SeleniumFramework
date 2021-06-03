package com.qa.OrangeHRM.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OrangeHRM.Pages.BasePage;
import com.qa.OrangeHRM.Pages.HomePage;
import com.qa.OrangeHRM.Pages.LoginPage;

public class LoginPageTest extends BaseTest {
	
	private static Logger log = LogManager.getLogger(LoginPageTest.class);
	
	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("Login Page title is: "+ title);
		Assert.assertEquals(title, "OrangeHRM");
		log.info("Title verified");
	}

	@Test(priority = 2)
	public void verifyLoginPageHeader() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println("Login Page header is: "+header);
		Assert.assertEquals(header, "( Username : Admin | Password : admin123 )");
	}

	@Test(priority = 3)
	public void verifyLoginTest() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(),BasePage.getPassword());
		String loggedInUserName = homePage.verifyLoggedInUserName();
		System.out.println("Logged In Username: "+ loggedInUserName);
		//Assert.assertEquals(loggedInUserName, "Welcome Pooja");
	}
	
	@Test(priority = 4)
	public void verifyInvalidCredentialsErrorMsgTest() {
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(),BasePage.getInvalidPassword());
		String errorMsg = page.getInstance(LoginPage.class).getErrorMsg().getText();
		Assert.assertEquals(errorMsg, "Invalid credentials");
	}
	
	@Test(priority = 5)
	public void verifyPassworCannotBeEmptyErrorMsgTest() {
		String errorMsg = page.getInstance(LoginPage.class).doLogin(BasePage.getUsername());
		Assert.assertEquals(errorMsg, "Password cannot be empty");
	}

	@Test(priority = 6)
	public void verifyUsernameCannotBeEmptyErrorMsgTest() {
		String errorMsg = page.getInstance(LoginPage.class).doLogin();
		Assert.assertEquals(errorMsg, "Username cannot be empty");
		
	}









}
