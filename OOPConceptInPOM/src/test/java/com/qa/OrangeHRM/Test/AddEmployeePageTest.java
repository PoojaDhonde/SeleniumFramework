package com.qa.OrangeHRM.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.OrangeHRM.Pages.AddEmployeePage;
import com.qa.OrangeHRM.Pages.BasePage;
import com.qa.OrangeHRM.Pages.EmployeeDetailsPage;
import com.qa.OrangeHRM.Pages.HomePage;
import com.qa.OrangeHRM.Pages.LoginPage;
import com.qa.OrangeHRM.Testdata.ExcelInput;


public class AddEmployeePageTest extends BaseTest{
	
	@DataProvider(name = "TestDataWith6Coln")
	public static Object TestDataWith6Coln() {

		String excelPath = System.getProperty("user.dir");
		Object[][] data =  testData(excelPath+"/src/main/testdata/EmployeeNameInputFile.xlsx", "Sheet1");

		return data;
	}
	
	@DataProvider(name = "TestDataWith3Coln")
	public static Object TestDataWith3Coln() {

		String excelPath = System.getProperty("user.dir");
		Object[][] data =  testData(excelPath+"/src/main/testdata/Book2.xlsx", "Sheet1");

		return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {

		ExcelInput excel = new ExcelInput(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object[][] data =  new Object[rowCount-1][colCount];

		for (int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				data[i-1][j] = cellData;
			}
		}
		return(data);
	}

	@Test(priority = 1, dataProvider = "TestDataWith3Coln")
	public void verifyAddEmployeeTest(String firtsName, String middleName, String lastName){
		
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		page.getInstance(HomePage.class).clickOnAddEmployee();
		EmployeeDetailsPage employeeDetailsPage = page.getInstance(AddEmployeePage.class).addNewEmployee(firtsName, middleName, lastName);
		String employeeDetailsPageHeaderText = employeeDetailsPage.verifyEmployeeDetailsPageHeader();
		String employeeName = employeeDetailsPage.verifyEmployeeName();
		System.out.println("Employee Details Page Header is: " + employeeDetailsPageHeaderText);
		System.out.println("Employee Name is: " + employeeName);
		Assert.assertEquals(employeeDetailsPageHeaderText, "Personal Details");
		Assert.assertEquals(employeeName, firtsName + " " + middleName + " " + lastName);
	}
	
	@Test(priority = 2, dataProvider = "TestDataWith6Coln")
	public void verifyAddEmployeeWithLoginCredTest(String firtsName, String middleName, String lastName,
			String userName, String pwd, String confirmPwd){
		
		page.getInstance(LoginPage.class).doLogin(BasePage.getUsername(), BasePage.getPassword());
		page.getInstance(HomePage.class).clickOnAddEmployee();
		EmployeeDetailsPage employeeDetailsPage = page.getInstance(AddEmployeePage.class).
				addNewEmployee(firtsName, middleName, lastName, userName, pwd, confirmPwd);
		String employeeDetailsPageHeaderText = employeeDetailsPage.verifyEmployeeDetailsPageHeader();
		String employeeName = employeeDetailsPage.verifyEmployeeName();
		System.out.println("Employee Details Page Header is: " + employeeDetailsPageHeaderText);
		System.out.println("Employee Name is: " + employeeName);
		Assert.assertEquals(employeeDetailsPageHeaderText, "Personal Details");
		Assert.assertEquals(employeeName, firtsName + " " + middleName + " " + lastName);
	}

	

}
