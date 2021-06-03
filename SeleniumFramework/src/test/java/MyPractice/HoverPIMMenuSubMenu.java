package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverPIMMenuSubMenu {

	private static WebElement element;

	public static WebElement hoverPIM(WebDriver driver) {

		try {

			element = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));

		}catch(Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public static WebElement hoverAddEmployee(WebDriver driver) {

		try {

			element = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));

		}catch(Exception e) {
			e.printStackTrace();
		}

		return element;
	}

	public static WebElement hoverEmployeeList(WebDriver driver) {

		try {

			element = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewEmployeeList\"]"));

		}catch(Exception e) {
			e.printStackTrace();
		}

		return element;
	}

}
