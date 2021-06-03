package gutenberg.Test;

import org.testng.annotations.Test;

public class MainPageTest extends TestPage{

	@Test(priority = 1)
	public void verifyMainPageTitleTest() {
		String title = mainPage.getMainPageTitle();
		System.out.println(title);
	}
	
	@Test(priority = 2)
	public void verifyClickOnFictionCategory() {
		fictionPage = mainPage.clickFictionButton();
		String title = fictionPage.getFictionPageTitle();
		System.out.println(title);
	}

}
