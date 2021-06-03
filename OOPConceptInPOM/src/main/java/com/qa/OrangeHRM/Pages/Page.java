package com.qa.OrangeHRM.Pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	WebDriver driver;
	WebDriverWait wait;
	static Properties prop;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,30);
		try {
			prop = new Properties();
			String projpath = System.getProperty("user.dir");
			FileInputStream input = new FileInputStream(projpath+"/src/main/config/TestData.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//abstract methods

	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract void waitForElementToVisible(WebElement locator);

	public abstract void waitForPageTitle(String title);
	
	public abstract String getURL();

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
