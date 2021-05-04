package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class TestNG_Demo2 {

	private static WebDriver driver = null;

	@BeforeTest
	public void setupTest() {//setup browser

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public static void googleSearch3() throws Exception {//google search test


		driver.get("https://google.com");

		GoogleSearchPage.textBox_search(driver).sendKeys("Songs");;

		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

		Thread.sleep(3000);

	}

	public static void googleSearch2() throws Exception {//google search test


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
