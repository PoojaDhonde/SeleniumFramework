package gutenberg.Pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	static WebDriver driver;
	static WebDriverWait wait;
	static Properties prop;

	public Page(WebDriver driver) {
		Page.driver = driver;
		Page.wait = new WebDriverWait(Page.driver,30);
		try {
			prop = new Properties();
			String projpath = System.getProperty("user.dir");
			FileInputStream input = new FileInputStream(projpath+"/src/main/config/Config.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getURL() {
		String url = prop.getProperty("url");
		return url;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element =  driver.findElement(locator);
			return element;
		}catch (Exception e) {
			System.out.println("Error occured while finding element" + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	public void waitForElementToVisible(WebElement locator) {
		try {
			wait.until(ExpectedConditions.visibilityOf(locator));
		}catch (Exception e) {
			System.out.println("Error occured while wait for element to be visible" + locator.toString());
			e.printStackTrace();
		}

	}

	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch (Exception e) {
			System.out.println("Error occured while wait for element to be visible" + title);
			e.printStackTrace();
		}
	}

}
