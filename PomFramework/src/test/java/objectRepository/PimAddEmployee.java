package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PimAddEmployee {
	
	@FindBy(id = "firstName")
	WebElement firstName;
	
	@FindBy(id = "middleName")
	WebElement middleName;
	
	@FindBy(id = "lastName")
	WebElement lastName;
	
	@FindBy(id = "photofile")
	WebElement photograph;
	
	@FindBy(id = "chkLogin")
	WebElement createLoginDetailsCheckbox;
	
	@FindBy(id = "user_name")
	WebElement userName;
	
	@FindBy(id = "user_password")
	WebElement password;
	
	@FindBy(id ="re_password")
	WebElement confirmPassword;
	
	@FindBy(id = "status")
	WebElement status;
	
	@FindBy(id = "btnSave")
	WebElement saveButton;
	
	

}
