package com.qa.OrangeHRM.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OrangeHRM.Pages.AddEmployeePage;
import com.qa.OrangeHRM.Pages.BasePage;
import com.qa.OrangeHRM.Pages.EmployeeListPage;
import com.qa.OrangeHRM.Pages.HomePage;
import com.qa.OrangeHRM.Pages.LoginPage;
import com.qa.OrangeHRM.Pages.ReportsPage;

public class HomePageTest extends BaseTest{
	
	@Test(priority = 1)
	public void verifyLogoutTest() {
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		LoginPage loginpage = page.getInstance(HomePage.class).clickOnLogouBtn();
		String header = loginpage.getLoginPageHeader();
		System.out.println("Login Page header is: "+header);
		Assert.assertEquals(header, "( Username : Admin | Password : admin123 )");		
	}
	
	@Test(priority = 2)
	public void verifyAboutWindowIsDisplayedTest(){
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		String aboutWindowHeader = page.getInstance(HomePage.class).clickOnAboutBtn();
		//page.getInstance(HomePage.class).clickOnAboutBtn();
		System.out.println("About Window header is: " + aboutWindowHeader);
		Assert.assertEquals(aboutWindowHeader, "About");
	}
	
	@Test(priority = 3)
	public void verifyClickOnAddEmployeeTest(){
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		AddEmployeePage addEmployeePage = page.getInstance(HomePage.class).clickOnAddEmployee();
		String addEmployeePageHeader = addEmployeePage.getAddEmployeePageHeader();
		System.out.println("Add Employee Page header: " + addEmployeePageHeader);
		Assert.assertEquals(addEmployeePageHeader, "Add Employee");
	}
	
	@Test(priority = 4)
	public void verifyClickOnEmployeeListTest(){
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		EmployeeListPage employeeListPage = page.getInstance(HomePage.class).clickOnEmployeeListMenu();
		String employeeListPageHeader = employeeListPage.getEmployeeListPageHeader();
		System.out.println("Add Employee Page header: " + employeeListPageHeader);
		Assert.assertEquals(employeeListPageHeader, "Employee Information");
	}
	
	@Test(priority = 5)
	public void verifyClickOnReportsTest(){
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		ReportsPage reportsPage = page.getInstance(HomePage.class).clickOnReportsMenu();
		String reportsPageHeader = reportsPage.getReportsPageHeader();
		System.out.println("Add Employee Page header: " + reportsPageHeader);
		Assert.assertEquals(reportsPageHeader, "Employee Reports");
	}

}
