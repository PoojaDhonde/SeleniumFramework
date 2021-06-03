package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "welcome")
	public WebElement welcomeMenu;
	
	@FindBy(partialLinkText = "Logout")
	public WebElement logoutButton;
	
	public void clickWelcomeMenu() {
		welcomeMenu.click();
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}

}
