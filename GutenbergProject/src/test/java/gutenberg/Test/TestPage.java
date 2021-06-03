package gutenberg.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import gutenberg.Pages.FictionPage;
import gutenberg.Pages.MainPage;
import gutenberg.Pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPage {
	
	WebDriver driver;
	public Page page;
	public MainPage mainPage;
	public FictionPage fictionPage;

	@BeforeMethod
	public void setup(){

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page = new Page(driver);
		driver.get(page.getURL());
		mainPage = new MainPage();
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();

	}

}
