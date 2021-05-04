
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Google_Search {

	static WebDriver driver;

	public static void main(String[] args) throws Exception{

		//		String projectPath = System.getProperty("user.dir");
		//		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromeDriver/chromedriver.exe");
		//		WebDriver driver = new ChromeDriver();

		//		WebDriverManager.chromedriver().setup();
		//		driver = new ChromeDriver();

		//		String projectPath = System.getProperty("user.dir");
		//		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/IEDriver/IEDriverServer.exe");
		//		WebDriver driver = new InternetExplorerDriver();

		googleSearch();

		driver.close();
	}

	public static void googleSearch() throws Exception {

		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Songs");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		Thread.sleep(3000);
	}

}
