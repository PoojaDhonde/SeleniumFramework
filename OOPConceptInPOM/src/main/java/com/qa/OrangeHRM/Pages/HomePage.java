package com.qa.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By welcomebtn = By.xpath("//a[@id='welcome']");
	private By logoutbtn = By.xpath("//a[contains(text(),'Logout')]");
	private By aboutbtn = By.id("aboutDisplayLink");
	private By aboutWindow = By.xpath("//div[@id = 'welcome-menu']//a[@class = 'close']");
	private By aboutWindowText = By.xpath("//div[@id = 'welcome-menu']//h3");
	private By PIMMenu = By.xpath("//a[@id = 'menu_pim_viewPimModule']");
	private By addEmployeeMenu = By.xpath("//a[@id = 'menu_pim_addEmployee']");
	private By employeeListMenu = By.xpath("//a[@id = 'menu_pim_viewEmployeeList']");
	private By reportsMenu = By.xpath("//a[@id = 'menu_core_viewDefinedPredefinedReports']");

	//getter method

	public WebElement getWelcomebtn() {
		return getElement(welcomebtn);
	}

	public WebElement getLogoutbtn() {
		return getElement(logoutbtn);
	}

	public WebElement getAboutbtn() {
		return getElement(aboutbtn);
	}

	public WebElement getAboutWindow() {
		return getElement(aboutWindow);
	}
	
	public WebElement getAboutWindowText() {
		return getElement(aboutWindowText);
	}

	public WebElement getPIMMenu() {
		return getElement(PIMMenu);
	}

	public WebElement getAddEmployeeMenu() {
		return getElement(addEmployeeMenu);
	}

	public WebElement getEmployeeListMenu() {
		return getElement(employeeListMenu);
	}

	public WebElement getReportsMenu() {
		return getElement(reportsMenu);
	}

	//action method
	public String verifyLoggedInUserName() {
		return getWelcomebtn().getText();
	}

	public void clickOnWelcomeBtn() {
		getWelcomebtn().click();
	}
	
	public String clickOnAboutBtn(){
		clickOnWelcomeBtn();
		waitForElementToVisible(getAboutbtn());
		getAboutbtn().click();
		dismissAboutWindow();
		return getAboutText();
	}
	
	public String getAboutText() {
		return getAboutWindowText().getText();
		
	}
	
	public void dismissAboutWindow() {
		getAboutbtn().click();
	}
	
	public LoginPage clickOnLogouBtn() {
		clickOnWelcomeBtn();
		waitForElementToVisible(getLogoutbtn());
		getLogoutbtn().click();
		
		return getInstance(LoginPage.class);
	}

	public AddEmployeePage clickOnAddEmployee() {
		Actions action = new Actions(driver);
		action.moveToElement(getPIMMenu()).build().perform();
		action.moveToElement(getAddEmployeeMenu()).click().perform();
		
		return getInstance(AddEmployeePage.class);
	}
	
	public EmployeeListPage clickOnEmployeeListMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(getPIMMenu()).perform();
		action.moveToElement(getEmployeeListMenu()).click().perform();
		
		return getInstance(EmployeeListPage.class);
	}
	
	public ReportsPage clickOnReportsMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(getPIMMenu()).build().perform();
		action.moveToElement(getEmployeeListMenu()).click().perform();
		
		return getInstance(ReportsPage.class);
	}
}
