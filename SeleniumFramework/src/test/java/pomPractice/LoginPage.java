package pomPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "txtUsername")
	public WebElement userNameBox;
	
	@FindBy(how = How.ID, using = "txtPassword")
	public WebElement passwordBox;
	
	@FindBy(how = How.NAME, using = "Submit" )
	public WebElement loginButton;
	
	public void enterUsername(String userName) {
		userNameBox.sendKeys(userName);		
	}
	
	public void enterPassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();		
	}


}
