package MyPractice;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainDemo{

	public WebDriver chrome = null;
	File scrFile = null;

	@BeforeTest	
	public void setup() {

		try {

			WebDriverManager.chromedriver().setup();
			chrome = new ChromeDriver();
			//chrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			chrome.manage().window().maximize();


		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void login() {

		try {

			chrome.get("https://opensource-demo.orangehrmlive.com/");
			LoginLogoutTest.username(chrome).sendKeys("Admin");
			LoginLogoutTest.password(chrome).sendKeys("admin123");
			// Code to capture the screenshot
			scrFile = ((TakesScreenshot)chrome).getScreenshotAs(OutputType.FILE);
			// Code to copy the screenshot in the desired location
			FileUtils.copyFile(scrFile, new File("C:\\Users\\A715914\\eclipse-workspace\\SeleniumFramework\\screenshots\\google.jpg"));
			LoginLogoutTest.loginButton(chrome).click();

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

//	@Test(dependsOnMethods = {"login"}, dataProvider = "EmployeeNameFile")
//	public void addEmployee(String firstName, String middleName, String lastName, String username, String password, String confirmPassword) {
//
//		try {
//
//			AddEmployee.selectPIMSEmployeeAdd(chrome);
//			AddEmployee.firstName(chrome, firstName);
//			AddEmployee.middleName(chrome, middleName);
//			AddEmployee.lastName(chrome, lastName);
//			AddEmployee.addPhotograph(chrome);
//			AddEmployee.chechbox(chrome);
//			AddEmployee.username(chrome, username);
//			AddEmployee.password(chrome, password);
//			AddEmployee.confirmPassword(chrome, confirmPassword);
//			AddEmployee.dropdownStatus(chrome);
//			AddEmployee.saveButton(chrome).click();
//			Thread.sleep(2000);
//
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

//	@DataProvider(name = "EmployeeNameFile")
//	public static Object employeeNameFileData() {
//
//		String excelPath = System.getProperty("user.dir");
//		Object[][] data =  testData(excelPath+"/excel/EmployeeNameInputFile.xlsx", "Sheet1");
//		return data;
//	}
	
	@DataProvider(name = "Book1")
	public static Object Book1() {

		String excelPath = System.getProperty("user.dir");
		Object[][] data =  testData(excelPath+"/excel/Book 1.xlsx", "Sheet1");

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
	
	@Test(dependsOnMethods = {"login"}, dataProvider = "Book1")
	public void addEmployee(String firstName, String middleName, String lastName, String username, String password, String confirmPassword, String gender, String martialStatus, String nationality, String dob) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) chrome;
			AddEmployee.selectPIMSEmployeeAdd(chrome);
			AddEmployee.firstName(chrome, firstName);
			AddEmployee.middleName(chrome, middleName);
			AddEmployee.lastName(chrome, lastName);
			AddEmployee.addPhotograph(chrome);
			AddEmployee.chechbox(chrome);
			AddEmployee.username(chrome, username);
			AddEmployee.password(chrome, password);
			AddEmployee.confirmPassword(chrome, confirmPassword);
			AddEmployee.dropdownStatus(chrome);
			AddEmployee.saveButton(chrome).click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].click()",PersonalDetails.editSaveButton(chrome));
			//PersonalDetails.editSaveButton(chrome).click();
			js.executeScript("arguments[0].click()",PersonalDetails.genderRadioButton(chrome, gender));
			//PersonalDetails.genderRadioButton(chrome, gender);
			Thread.sleep(2000);
			PersonalDetails.martialStatusDropdwon(chrome, martialStatus);
			Thread.sleep(2000);
			PersonalDetails.nationalityDropdwon(chrome, nationality);
//			PersonalDetails.datePicker(chrome).clear();
//			PersonalDetails.datePicker(chrome).sendKeys(dob);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click()",PersonalDetails.editSaveButton(chrome));
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//	@Test(dependsOnMethods = {"addEmployee"}, dataProvider = "EmployeePersonalDetailsFile")
//	public void editPersonalDetails(String gender, String martialStatus, String nationality, String dob) {
//
//		try {
//
//			PersonalDetails.editSaveButton(chrome).click();
//			PersonalDetails.genderRadioButton(chrome, gender).click();
//			PersonalDetails.martialStatusDropdwon(chrome, martialStatus);
//			PersonalDetails.nationalityDropdwon(chrome, nationality);
//			PersonalDetails.datePicker(chrome).clear();
//			PersonalDetails.datePicker(chrome).sendKeys(dob);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test(dependsOnMethods = {"login", "addEmployee"})
	@Parameters({"nameToType","nameToClick","nameToSearch"})
	public void searchEmployee(@Optional("Alice") String nameToType,  @Optional("Alice") String nameToClick,  @Optional("Alice")String nameToSearch) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) chrome;
			EmployeeSearch.clickPIMEmployeeList(chrome);
			EmployeeSearch.insertEmployeeName(chrome).clear();
			EmployeeSearch.insertEmployeeName(chrome).sendKeys(nameToType);
			EmployeeSearch.dropdownEmployeeName(chrome,nameToClick);
			EmployeeSearch.clickSearchButton(chrome).sendKeys(Keys.RETURN);
			js.executeScript("arguments[0].scrollIntoView()", EmployeeSearch.columnFirstMiddleName(chrome, nameToSearch));
			EmployeeSearch.columnFirstMiddleName(chrome, nameToSearch).click();
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = {"login","searchEmployee"})
	public void logout() {

		try {

			LoginLogoutTest.welcomeButton(chrome).click();
			LoginLogoutTest.logoutButton(chrome).click();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void close() {

		chrome.close();
		chrome.quit();
	}
}
