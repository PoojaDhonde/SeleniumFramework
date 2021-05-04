package MyPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeSearch {

	public static WebElement element =null;
	public static Actions action = null;
	public static WebDriverWait wait = null;
	public static List<WebElement> myList = null;
	public static Select dropdownEmployeeName = null;

	public static void clickPIMEmployeeList(WebDriver driver) {

		try {

			action = new Actions(driver);
			action.moveToElement(HoverPIMMenuSubMenu.hoverPIM(driver)).perform();
			action.moveToElement(HoverPIMMenuSubMenu.hoverEmployeeList(driver)).click().perform();
			
		}catch(Exception e) {
			//e.printStackTrace();
			e.getCause();
			e.getClass();
			e.getMessage();
		}

	}


	public static WebElement insertEmployeeName(WebDriver driver) {

		try {

			element = driver.findElement(By.id("empsearch_employee_name_empName"));
		}catch(Exception e) {
			//e.printStackTrace();
			e.getCause();
			e.getClass();
			e.getMessage();
		}
		return element;

	}

	//	public static WebElement dropdownEmployeeName(WebDriver driver) {
	//		
	//		try {
	//			
	//			myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(insertEmployeeName(driver)));
	//			for (WebElement element:myList)
	//			    if(element.getText().contains("Kiran"));
	//			        element.click();
	//		}catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//		return element;
	//	}

	public static void dropdownEmployeeName(WebDriver driver, String nameToClick) {

		try {
			element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(insertEmployeeName(driver)));
			dropdownEmployeeName = new Select(element);
			dropdownEmployeeName.selectByValue(nameToClick);
		}catch (Exception e) {
			//e.printStackTrace();
			e.getCause();
			e.getClass();
			e.getMessage();
		}

	}

	public static WebElement clickSearchButton(WebDriver driver) {

		try {

			element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("searchBtn"))));
			}catch(Exception e) {
			//e.printStackTrace();
			e.getCause();
			e.getClass();
			e.getMessage();
		}

		return element;
	}


	public static WebElement columnFirstMiddleName(WebDriver driver, String nameToSearch) {

		try {
			element =  new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'"+nameToSearch+"')]"))));
			}catch (Exception e) {
			//e.printStackTrace();
			e.getCause();
			e.getClass();
			e.getMessage();
		}
		return element;


	}

}
