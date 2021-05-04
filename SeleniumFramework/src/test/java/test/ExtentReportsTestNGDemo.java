package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTestNGDemo {

	ExtentReports extent;
	ExtentSparkReporter spark;

	@BeforeSuite
	public void setup() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);

	}
	@Test
	public void test1() {

		ExtentTest test = extent.createTest("Google Search Test1","Test to validate google search functionality");

		test.log(Status.INFO,"Starting TC");
		test.info("Test completed");
		test.fail("Pressed keyboard enter key",MediaEntityBuilder.createScreenCaptureFromPath("Screenshot.png").build());
		test.addScreenCaptureFromPath("Screenshot.png");

	}
	@Test
	public void test2() {

		ExtentTest test = extent.createTest("Google Search Test1","Test to validate google search functionality");

		test.log(Status.INFO,"Starting TC");
		test.info("Test completed");
		test.pass("Pressed keyboard enter key",MediaEntityBuilder.createScreenCaptureFromPath("Screenshot.png").build());
		test.addScreenCaptureFromPath("Screenshot.png");

	}
	@AfterSuite
	public void teardown() {

		extent.flush();

	}

}
