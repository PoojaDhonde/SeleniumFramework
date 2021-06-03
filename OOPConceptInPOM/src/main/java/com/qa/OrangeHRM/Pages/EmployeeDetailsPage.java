package com.qa.OrangeHRM.Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EmployeeDetailsPage extends BasePage{

	public EmployeeDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By employeeDetailsPageheaderText = By.xpath("//div[@id = 'pdMainContainer']//h1");
	private By employeeName = By.xpath("//div[@id= 'profile-pic']//h1");
	private By editBtn = By.id("btnSave");
	private By maleRadioBtn = By.id("personal_optGender_1");
	private By femaleRadioBtn = By.id("personal_optGender_2");
	private By martialStatusDropdown = By.id("personal_cmbMarital");
	private By nationalityDropdown = By.id("personal_cmbNation");
	private By dob = By.id("personal_DOB");
	private By selectMonth = By.className("ui-datepicker-month");
	private By selectYear = By.className("ui-datepicker-year");


	//getter methods

	public WebElement getEmployeeDetailsPageheaderText() {
		return getElement(employeeDetailsPageheaderText);
	}
	public WebElement getEmployeeName() {
		return getElement(employeeName);
	}

	public WebElement getEditBtn() {
		return getElement(editBtn);
	}
	public WebElement getMaleRadioBtn() {
		return getElement(maleRadioBtn);
	}
	public WebElement getFemaleRadioBtn() {
		return getElement(femaleRadioBtn);
	}
	public WebElement getMartialStatusDropdown() {
		return getElement(martialStatusDropdown);
	}
	public WebElement getNationalityDropdown() {
		return getElement(nationalityDropdown);
	}
	public WebElement getDob() {
		return getElement(dob);
	}

	public WebElement getSelectMonth() {
		return getElement(selectMonth);
	}
	public WebElement getSelectYear() {
		return getElement(selectYear);
	}

	//action methods


	public String verifyEmployeeDetailsPageHeader(){
		waitForElementToVisible(getEmployeeDetailsPageheaderText());
		return getEmployeeDetailsPageheaderText().getText();
	}

	public String verifyEmployeeName() {
		waitForElementToVisible(getEmployeeName());
		return getEmployeeName().getText();
	}

	public void selectRadiobutton() {
		getEditBtn().click();
		getFemaleRadioBtn().click();
		getEditBtn().click();
	}

	public void selectMartialStatusDropdown() {
		getEditBtn().click();
		Select dropdown = new Select(getMartialStatusDropdown());
		dropdown.selectByVisibleText("Single");
		getEditBtn().click();
	}

	public void selectNationalityDropdown() {
		getEditBtn().click();
		Select dropdown = new Select(getMartialStatusDropdown());
		dropdown.selectByVisibleText("Indian");
		getEditBtn().click();
	}

	//	Javascript Date selector
	//	public void selectDob(String date) {
	//		getEditBtn().click();
	//		JavascriptExecutor js = ((JavascriptExecutor)driver);
	//		js.executeScript("arguments[0].setAttribute('value','"+date+"');", getDob());
	//		getEditBtn().click();
	//	}
	
	//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[1]

	public void selectDob(String date) {

		getEditBtn().click();
		getDob().click();

		String dateArr[] = date.split("-");
		String dd = dateArr[2];
		String mm = dateArr[1];
		String yyyy = dateArr[0];

		Select month = new Select(getSelectMonth());
		month.selectByValue(mm);
		Select year = new Select(getSelectYear());
		year.selectByValue(yyyy);
		
		String beforexpath = "//div[@id='ui-datepicker-div']/table/tbody/tr[";
		String afterxpath = "]/td[";
		final int totalWeekDays = 7;
		boolean flag = false;
		String day = null;

		for(int rowNum = 1; rowNum<=6; rowNum++) {
			for (int colNum = 1; colNum<=totalWeekDays; colNum++) {

				try {			
					day = driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).getText();
					
				} catch (NoSuchElementException e) {
					System.out.println("Incorrect date");
					flag = false;
					break;
				}
				if(day.equals(dd)) {
					driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).click();
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		getEditBtn().click();
	}

}
