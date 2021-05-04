package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultibrowserTestNG {

	WebDriver driver = null;
	String projPath =System.getProperty("user.dir");

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {

		System.out.println("Browser name is:"+ browserName);
		System.out.println("Current thread is:"+ Thread.currentThread().getId());

		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", projPath+"/drivers/chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", projPath+"/drivers/IEDriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {

			System.setProperty("webdriver.edge.driver", projPath+"./drivers/microsoftEdge/msedgedriver.exe");
			driver = new EdgeDriver();
		}

	}

	@Test
	public void test1() throws Exception {

		driver.get("https://google.com");
		Thread.sleep(5000);

	}

	@AfterTest
	public void teardown() {

		driver.close();
		System.out.println("Test completed");
	}

}
