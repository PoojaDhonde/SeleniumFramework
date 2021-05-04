package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetails {

	private static WebElement element;
	private static Select dropdownMartialStatus;
	private static Select dropdownNationality;
		
	public static WebElement editSaveButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@id = 'btnSave']"));
		System.out.println("Button clicked");
		return element;
	}

	public static WebElement genderRadioButton(WebDriver driver, String gender) {

		
		if (gender == "male"){
			element = driver.findElement(By.id("personal_optGender_1"));
			System.out.println("Male selcted");
		}
		else if(gender == "female") {
			element = driver.findElement(By.id("personal_optGender_2"));
			System.out.println("Female selcted");
		}
		return element;
	}

	public static void martialStatusDropdwon(WebDriver driver, String martialStatus) {

		element = driver.findElement(By.id("personal_cmbMarital"));
		dropdownMartialStatus = new Select(element);
		dropdownMartialStatus.selectByValue(martialStatus);
		System.out.println("martial Status selcted");
		}

	public static void nationalityDropdwon(WebDriver driver, String nationality) {

		element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("personal_cmbNation"))));
		dropdownNationality = new Select(element);
		dropdownNationality.selectByVisibleText(nationality);
		System.out.println("nationality selcted");
	}
	
	public static WebElement datePicker(WebDriver driver) {
		
		element = driver.findElement(By.name("personal[DOB]"));
		System.out.println("dob selcted");
		return element;
		
	}

}
