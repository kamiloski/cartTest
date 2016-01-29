package pages;

import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;

	 

	
	@FindBy(id = "currency")
	WebElement buttonCurrency;
	
	@FindBy(css = "dropdown-menu li")
	List<WebElement> currences;

	@FindBy(className = "input-lg")
	WebElement inputSearch;
	
	@FindBy(className = "btn-lg")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@data-original-title=\"Compare this Product\"]")
	List <WebElement> compareButton;
	
	@FindBy(partialLinkText = "Product Compare")
	WebElement urlComparePage;
	
	/*@FindBy(className = "")
	WebElement ;
	*/
	@FindBy(xpath = "//td[contains(text(), \"Availability\")]/following-sibling::*")
	List <WebElement> availabilityFields;
	
	@FindBy(xpath = "//input[@value = \"Add to Cart\"]")
	//@FindBy(className = "btn.btn-primary.btn-block")
	List<WebElement> addToCartButtons;
	
	public String PAGE_TITLE = "Your Store";
	
	
	public void isHomePage(){
		String pageTitle = driver.getTitle();
		//Assert.assertEquals(pageTitle, PAGE_TITLE);
	}
	
	public void clickButtonChangeCurrency(){
		Actions clickCurrencyButton= new Actions(driver);
		clickCurrencyButton.moveToElement(buttonCurrency).click().perform();	
	
	}
	public void setCurrency(){
		String currency = "GBP";
		WebElement currencyVal= driver.findElement(By.name(currency));
		currencyVal.click();
	//assertaassertEquals(actual, expected);
	}
	
	public void inputIntoSearch(){
		String itemName = "ipod";
		inputSearch.sendKeys(itemName);
	}
	
	public void clickSearchButton(){
		searchButton.click();
	}
	
	public void compareItems(){
		for(WebElement compareButtons: compareButton){
			compareButtons.click();
		}
	}
	
	public void goToComparePage(){
		urlComparePage.click();
		
	}
	
	public void findAvailability(){
		
		String searchingAvailabilityValue = "Out Of Stock";
		int availabilityPosition =0;
		int numOfFields =	availabilityFields.size();

		for(int i=0;i<numOfFields;i++){
			String availabilityValues = availabilityFields.get(i).getText();
				if(availabilityValues.contains(searchingAvailabilityValue)){
					availabilityPosition = i+2;
					WebElement removeButton = driver.findElement(By.xpath("//*[@id='content']/table/tbody[2]/tr/td["+availabilityPosition+"]/a"));
					removeButton.click();							
			}	
				
		}
		
		
		
	}
	public void chooseRandomItem(){

		List <WebElement> links = driver.findElements(By.xpath("//input[@value = \"Add to Cart\"]"));
				Random gen = new Random();
				WebElement link = links.get(gen.nextInt(links.size()));

				link.click();
	}
	
	public HomePage(WebDriver driver)
	
	{
		this.driver = driver;
 
		}

}
