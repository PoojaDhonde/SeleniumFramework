package Demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpAuth {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/drivers/chromeDriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Basic Auth')]")).click();
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
		

	}

}
