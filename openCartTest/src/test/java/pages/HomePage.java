package pages;

import java.util.List;

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
	
	public int findAvailability(){
		String searchingAvailabilityValue = "2-3 Days";
		int availabilityPosition =0;
		int numOfFields =	availabilityFields.size();
		for(int i=0;i<numOfFields;i++){
			String availabilityValues = availabilityFields.get(i).getText();
				if(availabilityValues.contains(searchingAvailabilityValue)){
					availabilityPosition = i;
					System.out.println(availabilityPosition);	
					
			}	
				
		}
		return availabilityPosition;
	}
	
	public void ile(int availabilityPosition){
		int aaa = availabilityPosition;
		System.out.println(aaa);
	}
	
	public HomePage(WebDriver driver)
	
	{
		this.driver = driver;
 
		}

}
