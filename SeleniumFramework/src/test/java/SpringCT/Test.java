package SpringCT;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A715914\\eclipse-workspace\\SeleniumFramework\\drivers\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Test case 1
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//a[@class = 'login']")).click();
		
		//Test case 2		
		driver.findElement(By.id("email")).sendKeys("scttestdrive@grr.la");
		driver.findElement(By.id("passwd")).sendKeys("Spring@123");
	
		driver.findElement(By.xpath(("//i[@class='icon-lock left']"))).click();
		
		driver.findElement(By.xpath("//a[@class = 'logout']")).click();
		
		//Test case 3
		driver.get("http://automationpractice.com/index.php");
		
		String beforeXpath = "//*[@id='homefeatured']/li[";
		String afterXpath = "]/div/div[2]/h5/a";
		
		String beforeXpathofPrice = "//*[@id=\"homefeatured\"]/li[";
		String afterXpathofPrice = "]/div/div[2]/div/span";	
		
		List<WebElement> tags = driver.findElements(By.xpath("//*[@id='homefeatured']/li"));
				
		for(int i = 1; i < tags.size(); i++) {
			String productName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			System.out.println(productName);
			
			String productPrice = driver.findElement(By.xpath(beforeXpathofPrice + i +afterXpathofPrice)).getText();
			System.out.println(productPrice);
		}		
		
		driver.close();
		driver.quit();
		

	}

}
