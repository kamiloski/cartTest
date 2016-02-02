package pages;

import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage{
	
	public String PAGE_TITLE = "Your Store";

	@FindBy(className = "input-lg")
	WebElement inputSearch;	
	
	@FindBy(className = "btn-lg")
	WebElement searchButton;		
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String isHomePage(){
		return driver.getTitle();	
	}
	
	public void inputIntoSearch(String searchingItemName ){
		inputSearch.sendKeys(searchingItemName);
	}
	
	public  SearchResultsPage clickSearchButton(){
		searchButton.click();
		return PageFactory.initElements(driver, SearchResultsPage.class);
	}

}
