package gutenberg.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FictionPage extends Page{

	public FictionPage() {
		super(driver);
	}
	
	//page locators

	private By pageHeader = By.className("headerClr");
	private By searchBox = By.name("query");
	private By searchButton = By.xpath("//span[contains(text(),'Search')]");
	//private By countNoOfBook = By.xpath("//*[@id='root']/div/div/div[1]/div[2]/div/div[");
	
	//*[@id="root"]/div/div/div[1]/div[2]/div/div[1]/div/a/h5
	//*[@id="root"]/div/div/div[1]/div[2]/div/div[2]/div/a/h5
	
	//getter methods
	
	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}
	
	public WebElement getSearchBox() {
		return getElement(searchBox);
	}
	
	public WebElement getSearchButton() {
		return getElement(searchButton);
	}
	
//	public WebElement getCountNoOfBook() {
//		return getElement(countNoOfBook);
//	}
	
	//page actions
	
	public String getFictionPageTitle() {
		return getPageHeader().getText();
	}
	
	public void searchBook() {
		getSearchBox().sendKeys("Harry");
		getSearchButton().click();
	}
	
	public void countNoOfBooksDisplayed() {
		
		String beforePath = "//*[@id='root']/div/div/div[1]/div[2]/div/div[";
		String afterPath = "]/div/a/h5";
		List <WebElement> count = driver.findElements(By.xpath("//*[@id='root']/div/div/div[1]/div[2]/div/div"));
		String nameOfBook;
		
		System.out.println("No. of Books: " + count.size());
				
		for(int i = 1; i <= count.size(); i++) {
			nameOfBook = driver.findElement(By.xpath(beforePath + i + afterPath)).getText();
			System.out.println(i + ". " + nameOfBook);
		}
	}
}
