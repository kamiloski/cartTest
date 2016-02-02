package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultsPage extends BasePage {
	
	//jaki tytul?????????????
	public String PAGE_TITLE = "Search - ";
	
	@FindBy(xpath = "//*[@data-original-title=\"Compare this Product\"]")
	List <WebElement> compareButton;
	
	@FindBy(partialLinkText = "Product Compare")
	WebElement urlComparePage;
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}	
	
	// ---------------- sprawdzenie czy strona z wynikami???
	public String isSearchResoultsPage(){
		 return	driver.getTitle();
	}
	
	public void compareAllItems(){
		for(WebElement compareButtons: compareButton){
			compareButtons.click();
		}
	}
	
	//----------------------- sprawzenie czy wszystkie są wrzucone do porównania
	public void areAllItemsClickedCompare(){
		int numCompItems = compareButton.size();
		//------liczba itemow do porownania
		//czy się równaja ilościa lub czy pokazuje się alert ze dodano 4!
	}

	public ComparePage goToComparePage(){
		urlComparePage.click();
		return PageFactory.initElements(driver, ComparePage.class);
	}
}
