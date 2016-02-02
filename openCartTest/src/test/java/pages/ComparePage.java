package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.host.css.CSS;

public class ComparePage extends BasePage {

	public String PAGE_TITLE = "Product Comparison";

	@FindBy(xpath = "//td[contains(text(), \"Availability\")]/following-sibling::*")
	List<WebElement> availabilityFields;

	@FindBy(xpath = "//input[@value = \"Add to Cart\"]")
	List<WebElement> addToCartButtons;
	
	@FindBy(id = "cart-total")
	WebElement priceFromCart;

	public ComparePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String isComparePage() {
		return driver.getTitle();
	}

	public void findAvailability() {

		String searchingAvailabilityValue = "Out Of Stock";
		int availabilityPosition = 0;
		int firstColWithRemoveButton = 2;
		for (int i = 0; i < availabilityFields.size(); i++) {
			String availabilityValues = availabilityFields.get(i).getText();
			if (availabilityValues.equalsIgnoreCase(searchingAvailabilityValue)) {
				availabilityPosition = i + firstColWithRemoveButton;
				WebElement removeButton = driver.findElement(
						By.xpath("//*[@id='content']/table/tbody[2]/tr/td[" + availabilityPosition + "]/a"));
				removeButton.click();
			}

		}

	}

	public void chooseRandomItem() {

		/*List<WebElement> links = driver.findElements(By.xpath("//input[@value = \"Add to Cart\"]"));
		Random gen = new Random();
		WebElement link = links.get(gen.nextInt(links.size()));
		WebElement price = link.findElement(By.xpath("preceding::td[. = 'Price']/following-sibling::td"));
		link.click();
		String dupa = price.getText();

		System.out.println("link jest takie duzy " + links.size() + " a numer urządzenia to " + dupa);*/
	}
	
	public String putRandomItemToCartAndReturnPrice(){
	int availableTdOfProductInTable = addToCartButtons.size() + 1;
	Random random = new Random();
	int randomProductNumber = random.nextInt((availableTdOfProductInTable - 2) + 1) + 2;
	WebElement CartButton = driver.findElement(By.
			xpath("//table[@class='table table-bordered']/tbody[2]/tr/td[" + randomProductNumber +"]/input/self::*"));
	CartButton.click();
	WebElement productPrice= driver.findElement(By.
			xpath("//table[@class='table table-bordered']/tbody[1]/tr[3]/td[" + randomProductNumber +"]/self::*"));
	String getPriceAddedToCartProduct = productPrice.getText();

	System.out.println("wylosowana liczba to - " + randomProductNumber + " numer ceny " +productPrice.toString() + "numer buttona " + CartButton.toString() );
	
	return getPriceAddedToCartProduct;
	}
	
	public String getPriceFromCart(){
		return priceFromCart.getText();
	}

}
