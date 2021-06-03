package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PimHoverMenu {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]")
	WebElement hoverPIM;

	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	WebElement hoverandclickAddEmployee;
	
	public void hoverPIM() {
		
	}

}
