package com.qa.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmployeePage extends BasePage{

	public AddEmployeePage(WebDriver driver) {
		super(driver);
	}
	
	private By headerText = By.xpath("//div[@class = 'head']//h1");
	private By firstName = By.id("firstName");
	private By middleName = By.id("middleName");
	private By lastName = By.id("lastName");
	private By addPhotograph = By.id("photofile");
	private By createLoginDetailscheckbox = By.id("chkLogin");
	private By userName = By.id("user_name");
	private By pwd = By.id("user_password");
	private By confirmPwd = By.id("re_password");
	private By saveBtn = By.id("btnSave");
	
	//getter method
	
	public WebElement getHeaderText() {
		return getElement(headerText);
	}
	
	public WebElement getFirstName() {
		return getElement(firstName);
	}

	public WebElement getMiddleName() {
		return getElement(middleName);
	}

	public WebElement getLastName() {
		return getElement(lastName);
	}

	public WebElement getAddPhotograph() {
		return getElement(addPhotograph);
	}

	public WebElement getCreateLoginDetailscheckbox() {
		return getElement(createLoginDetailscheckbox);
	}

	public WebElement getUserName() {
		return getElement(userName);
	}

	public WebElement getPwd() {
		return getElement(pwd);
	}

	public WebElement getConfirmPwd() {
		return getElement(confirmPwd);
	}

	public WebElement getSaveBtn() {
		return getElement(saveBtn);
	}

	//action method
	
	public String getAddEmployeePageHeader() {
		return getHeaderText().getText();
	}
	
	public EmployeeDetailsPage addNewEmployee(String firtsName, String middleName, String lastName) {
		getFirstName().sendKeys(firtsName);
		getMiddleName().sendKeys(middleName);
		getLastName().sendKeys(lastName);
		getSaveBtn().click();
		
		return getInstance(EmployeeDetailsPage.class);
	}
	
	public EmployeeDetailsPage addNewEmployee(String firtsName, String middleName, String lastName,
			String userName, String pwd, String confirmpwd) {
		getFirstName().sendKeys(firtsName);
		getMiddleName().sendKeys(middleName);
		getLastName().sendKeys(lastName);
		getCreateLoginDetailscheckbox().click();
		getUserName().sendKeys(userName);
		getPwd().sendKeys(pwd);
		getConfirmPwd().sendKeys(confirmpwd);
		getSaveBtn().click();
		return getInstance(EmployeeDetailsPage.class);
	}
}
