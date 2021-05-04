package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);

		ExtentTest test1 = extent.createTest("Google Search Test1","Test to validate google search functionality");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		test1.log(Status.INFO,"Starting TC");

		driver.get("https://google.com");

		test1.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Songs");

		test1.pass("Entered text in search box");

		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[3]/center/input[1]")).sendKeys(Keys.RETURN);

		test1.pass("Pressed keyboard enter key");

		ExtentTest test2 = extent.createTest("Google Search Test1","Test to validate google search functionality");

		test1.pass("Closed the browser");

		test1.info("Test completed");

		test2.log(Status.INFO,"Starting TC");

		driver.get("https://google.com");

		test2.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Songs");

		test2.pass("Entered text in search box");

		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[3]/center/input[1]")).sendKeys(Keys.RETURN);

		test2.fail("Pressed keyboard enter key");

		Thread.sleep(3000);

		driver.close();

		driver.quit();

		test2.pass("Closed the browser");

		test2.info("Test completed");

		extent.flush();
	}

}
