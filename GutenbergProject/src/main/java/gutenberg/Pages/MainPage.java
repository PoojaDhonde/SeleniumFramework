package gutenberg.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends Page{
	
	public MainPage() {
		super(driver);
	}
	
	//page locators
	
	private By pageHeader = By.className("headingDiv");
	private By fictionButton = By.xpath("//span[text()='FICTION']");
	private By dramaButton = By.xpath("//span[text()=' DRAMA']");
	private By humorButton = By.xpath("//span[text()=' HUMOR']");
	private By politicsButton = By.xpath("//span[text()=' POLITICS']");
	private By philosophyButton = By.xpath("//span[text()=' PHILOSOPHY']");
	private By historyButton = By.xpath("//span[text()=' HISTORY']");
	private By adventureButton = By.xpath("//span[text()=' ADVENTURE']");
	
	//getter methods
	
	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}
	public WebElement getFictionButton() {
		return getElement(fictionButton);
	}
	public WebElement getDramaButton() {
		return getElement(dramaButton);
	}
	public WebElement getHumorButton() {
		return getElement(humorButton);
	}
	public WebElement getPoliticsButton() {
		return getElement(politicsButton);
	}
	public WebElement getPhilosophyButton() {
		return getElement(philosophyButton);
	}
	public WebElement getHistoryButton() {
		return getElement(historyButton);
	}
	public WebElement getAdventureButton() {
		return getElement(adventureButton);
	}
	
	//action methods
	
	public String getMainPageTitle() {
		return getPageHeader().getText();
	}
	
	public FictionPage clickFictionButton() {
		getFictionButton().click();
		return new FictionPage();	
	}

}
