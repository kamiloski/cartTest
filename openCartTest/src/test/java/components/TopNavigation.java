package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;

import pages.BasePage;

public class TopNavigation extends BasePage {

	private int newCurrencySymbol;
	
	@FindBy(id = "currency")
	WebElement currencyDropDown;

	@FindBy(css = "dropdown-menu")
	List<WebElement> currences;
	
	@FindBy(xpath = ".//*[@id='currency']//button/strong")
	WebElement currentCurrencySymbol;
	
	public TopNavigation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickCurrencyDropDown() {
		currencyDropDown.click();
	}

	public char setCurrency(String currencyToSet) {
		WebElement currencyVal = driver.findElement(By.name(currencyToSet.toUpperCase()));
		String currencyName = currencyVal.getText();
		System.out.println("Currency Name:" + currencyName);
		currencyVal.click();
		char[] currencyNameArray = currencyName.toCharArray();
		char newCurrencySymbol = currencyNameArray[0];
		System.out.println(newCurrencySymbol);
		return newCurrencySymbol;
	}

	public char[] getCurrentCurrencySymbol(){
		return currentCurrencySymbol.getText().toCharArray();//string??
	}
	
}
