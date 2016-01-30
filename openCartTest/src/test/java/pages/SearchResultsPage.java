package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@data-original-title=\"Compare this Product\"]")
	List <WebElement> compareButton;
	
	@FindBy(partialLinkText = "Product Compare")
	WebElement urlComparePage;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	public void compareItems(){
		for(WebElement compareButtons: compareButton){
			compareButtons.click();
		}
	}

	public ComparePage goToComparePage(){
		urlComparePage.click();
		return PageFactory.initElements(driver, ComparePage.class);
	}
}
