package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchResultsPage extends BasePage {

	public String PAGE_TITLE = "Search - ";
	
	@FindBy(xpath = "//*[@data-original-title=\"Compare this Product\"]")
	List <WebElement> compareButton;
	
	@FindBy(partialLinkText = "Product Compare")
	WebElement urlComparePage;
	
	@FindBy(id = "compare-total")
	WebElement numberOfProductToCompare;
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}	

	public String isSearchResoultsPage(){
		 return	driver.getTitle();
	}
	
	public void compareAllItems(){
		for(WebElement compareButtons: compareButton){
			compareButtons.click();
		}
	}
	
	public void areAllItemsClickedCompare(){
		//new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(By.id("compare-total"), ""));
		/*//new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementValue(By.id("compare-total"), "Product Compare (4)"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		int numCompItems = compareButton.size();
		String dupa = numberOfProductToCompare.getText().replaceAll("[^\\.0123456789]","");
		WebElement numberOfProductToCompare = driver.findElement(By.id("compare-total"));
		System.out.println(numberOfProductToCompare.getText() + "  dsadjasnhfjadehnfuaeh");///"dsadasdasdasdasdasdasdas " + dupa);
*/	}

	public ComparePage goToComparePage(){
		urlComparePage.click();
		return PageFactory.initElements(driver, ComparePage.class);
	}
}
