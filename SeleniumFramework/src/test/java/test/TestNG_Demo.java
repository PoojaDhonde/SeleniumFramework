package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class TestNG_Demo {

	private static WebDriver driver = null;
	public static String browser = null;
	String projectPath = System.getProperty("user.dir");

	@BeforeTest
	public void setupTest() {//setup browser
		PropertiesFile.getProperties();

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("ignoreProtectedModeSettings", true);

			System.setProperty("webdriver.ie.driver", projectPath+"/drivers/IEDriver/IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver(caps);
		}
	}

	@Test
	public static void googleSearch() throws Exception {//google search test


		driver.get("https://google.com");

		GoogleSearchPage.textBox_search(driver).sendKeys("Songs");;

		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

		Thread.sleep(3000);		

	}

	@AfterTest
	public void tearDown() {//close browser

		driver.close();

		driver.quit();
	}


}
