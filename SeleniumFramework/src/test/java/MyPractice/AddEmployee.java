package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AddEmployee {

	static WebElement element = null;
	static Actions action = null;
	static Select dropdownStatus = null;

	public static void selectPIMSEmployeeAdd(WebDriver driver) {

		action = new Actions(driver);
		action.moveToElement(HoverPIMMenuSubMenu.hoverPIM(driver)).perform();
		action.moveToElement(HoverPIMMenuSubMenu.hoverAddEmployee(driver)).click().perform();
	}

	public static void firstName(WebDriver driver, String firstName) {

		try {

			driver.findElement(By.id("firstName")).sendKeys(firstName);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void middleName(WebDriver driver, String middleName) {

		try {

			driver.findElement(By.id("middleName")).sendKeys(middleName);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void lastName(WebDriver driver, String lastName) {

		try {

			driver.findElement(By.id("lastName")).sendKeys(lastName);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void addPhotograph(WebDriver driver) {

		try {

			element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("photofile"))));
			element.click();
			//System.out.println("Clicked on photofile");
			Runtime.getRuntime().exec("C:/Users/A715914/Pictures/PhotoUploadScript.exe");
			System.out.println("Uploaded photofile");

		}catch (Exception e) {
			e.getCause();
			e.getClass();
			e.getMessage();
		}
	}

	public static void chechbox(WebDriver driver) {

		element = driver.findElement(By.id("chkLogin"));
		boolean isSelected = element.isSelected();
		if(isSelected == false) {
			element.click();
		}

	}

	public static void username(WebDriver driver, String username) {

		driver.findElement(By.id("user_name")).sendKeys(username);;
		
	}

	public static void password(WebDriver driver, String password) {

		driver.findElement(By.id("user_password")).sendKeys(password);;
		
	}

	public static void confirmPassword(WebDriver driver, String confirmPassword) {

		driver.findElement(By.id("re_password")).sendKeys(confirmPassword);;
		
	}

	public static void dropdownStatus(WebDriver driver) {

		element = driver.findElement(By.id("status"));
		dropdownStatus =  new Select(element);
		dropdownStatus.selectByValue("Enabled");
	}

	public static WebElement saveButton(WebDriver driver) {

		try {

			element = driver.findElement(By.id("btnSave"));

		}catch(Exception e) {
			e.printStackTrace();
		}

		return element;
	}

}
