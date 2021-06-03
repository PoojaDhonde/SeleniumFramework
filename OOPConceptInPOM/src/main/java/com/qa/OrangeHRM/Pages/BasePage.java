package com.qa.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element =  driver.findElement(locator);
			return element;
		}catch (Exception e) {
			System.out.println("Error occured while finding element" + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementToVisible(WebElement locator) {
		try {
			wait.until(ExpectedConditions.visibilityOf(locator));
		}catch (Exception e) {
			System.out.println("Error occured while wait for element to be visible" + locator.toString());
			e.printStackTrace();
		}

	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch (Exception e) {
			System.out.println("Error occured while wait for element to be visible" + title);
			e.printStackTrace();
		}
	}

	public String getURL() {
		String url = prop.getProperty("url");
		return url;
	}

	public static String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}

	public static String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	
	public static String getInvalidPassword() {
		String invalidPassword = prop.getProperty("invalidPassword");
		return invalidPassword;
	}
}
