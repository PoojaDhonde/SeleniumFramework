package gutenberg.Test;

import org.testng.annotations.Test;

public class FictionPageTest extends TestPage{
	
	@Test(priority = 1)
	public void verifyClickOnFictionCategory() {
		fictionPage = mainPage.clickFictionButton();
		String title = fictionPage.getFictionPageTitle();
		System.out.println(title);
		fictionPage.searchBook();
		fictionPage.countNoOfBooksDisplayed();
	}

}
