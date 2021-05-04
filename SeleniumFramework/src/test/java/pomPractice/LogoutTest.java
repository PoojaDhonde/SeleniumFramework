package pomPractice;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase{
	
	@Test
	public void init() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickLoginButton();

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.clickWelcomeMenu();
		homePage.clickLogoutButton();
	}

}
