package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLogoutTest{

	static WebElement element = null;

	public static WebElement username(WebDriver driver) {

		try {

			element = driver.findElement(By.id("txtUsername"));

		}catch(Exception e) {
			e.printStackTrace();
		}

		return element;		
	}

	public static WebElement password(WebDriver driver) {

		try {

			element = driver.findElement(By.id("txtPassword"));

		}catch(Exception e) {
			e.printStackTrace();
		}

		return element;		
	}

	public static WebElement loginButton(WebDriver driver) {

		try {

			element = driver.findElement(By.name("Submit"));

		}catch(Exception e) {
			e.printStackTrace();
		}

		return element;		
	}

	public static WebElement welcomeButton(WebDriver driver) {

		try {

			element = driver.findElement(By.id("welcome"));

		}catch(Exception e) {
			e.printStackTrace();
		}

		return element;		
	}

	public static WebElement logoutButton(WebDriver driver) {

		try {

			element = driver.findElement(By.partialLinkText("Logout"));

		}catch(Exception e) {
			e.printStackTrace();
		}

		return element;		
	}

}
