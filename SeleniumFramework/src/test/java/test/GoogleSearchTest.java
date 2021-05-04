package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver;

	public static void main(String[] args) throws Exception{

		googleSearch();
	}

	public static void googleSearch() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://google.com");

		GoogleSearchPage.textBox_search(driver).sendKeys("Songs");;
		
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		Thread.sleep(3000);
		
		driver.close();
		
	}


}
