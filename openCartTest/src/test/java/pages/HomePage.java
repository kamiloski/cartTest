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

public class HomePage {
	WebDriver driver;	
	
	public String PAGE_TITLE = "Your Store";

	@FindBy(className = "input-lg")
	WebElement inputSearch;	
	
	@FindBy(className = "btn-lg")
	WebElement searchButton;		
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void isHomePage(){
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, PAGE_TITLE);
	}
	
	public void inputIntoSearch( ){
		String itemName = "ipod";
		inputSearch.sendKeys(itemName);
	}
	
	public  SearchResultsPage clickSearchButton(){
		searchButton.click();
		return PageFactory.initElements(driver, SearchResultsPage.class);
	}

}
