package com.qa.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportsPage extends BasePage{

	public ReportsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By headerText = By.xpath("//div[@class = 'head']//h1");
	
	//getter method
	
	public WebElement getHeaderText() {
		return getElement(headerText);
	}
	
	//action method
	
	public String getReportsPageHeader() {
		return getHeaderText().getText();
	}
	


}
