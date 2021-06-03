package com.qa.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeListPage extends BasePage{

	public EmployeeListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By headerText = By.xpath("//div[@class ='head']//h1");
	
	//getter method
	
	public WebElement getHeaderText() {
		return getElement(headerText);
	}
	
	//action method
	
	public String getEmployeeListPageHeader() {
		return getHeaderText().getText();
	}
	


}
