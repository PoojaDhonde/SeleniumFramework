package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {

	WebDriver driver = null;

	@BeforeTest
	public void setupTest() {//setup browser
		PropertiesFile.getProperties();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}


	@Test(dataProvider = "testData")
	public void test1(String username, String password) throws Exception {

		System.out.println("Username:"+username+" | Password:"+password);

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);

	}

	@DataProvider(name = "testData")
	public Object getData() {

		String excelPath = System.getProperty("user.dir");
		Object[][] data =  testData(excelPath+"/excel/InputFile.xlsx", "Sheet1");

		return data;

	}

	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object[][] data =  new Object[rowCount-1][colCount];

		for (int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");		
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return(data);

	}
	@AfterTest
	public void tearDown() {//close browser

		driver.close();

		driver.quit();
	}
}
