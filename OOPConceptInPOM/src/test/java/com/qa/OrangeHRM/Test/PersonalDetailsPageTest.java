package com.qa.OrangeHRM.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OrangeHRM.Pages.AddEmployeePage;
import com.qa.OrangeHRM.Pages.BasePage;
import com.qa.OrangeHRM.Pages.EmployeeDetailsPage;
import com.qa.OrangeHRM.Pages.HomePage;
import com.qa.OrangeHRM.Pages.LoginPage;

public class PersonalDetailsPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void verifyEditGenderTest(){
		
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		page.getInstance(HomePage.class).clickOnAddEmployee();
		EmployeeDetailsPage employeeDetailsPage = page.getInstance(AddEmployeePage.class).addNewEmployee("Miya","A.","Sen");
		employeeDetailsPage.selectRadiobutton();
		System.out.println("Employee details updated");
		//Assert.assertEquals(employeeDetailsPageHeaderText, "Personal Details");
	}
	
	@Test(priority = 1)
	public void verifyEditDobTest(){
		
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		page.getInstance(HomePage.class).clickOnAddEmployee();
		EmployeeDetailsPage employeeDetailsPage = page.getInstance(AddEmployeePage.class).addNewEmployee("Geet","H.","Sen");
		employeeDetailsPage.selectDob("1996-5-11");
		System.out.println("Employee details updated");
		//Assert.assertEquals(employeeDetailsPageHeaderText, "Personal Details");
	}

}
