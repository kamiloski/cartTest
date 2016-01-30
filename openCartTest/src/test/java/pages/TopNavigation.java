package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavigation {
	WebDriver driver;
	
	@FindBy(id = "currency")
	WebElement buttonCurrency;
	
	@FindBy(css = "dropdown-menu li")
	List<WebElement> currences;
	
	public TopNavigation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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

	
}
