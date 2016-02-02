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
	// @FindBy(className = "btn.btn-primary.btn-block")
	List<WebElement> addToCartButtons;

	public ComparePage(WebDriver driver) {
		super(driver);
		// this.driver = driver;
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

		List<WebElement> links = driver.findElements(By.xpath("//input[@value = \"Add to Cart\"]"));
		Random gen = new Random();
		WebElement link = links.get(gen.nextInt(links.size()));
		WebElement price = link.findElement(By.xpath("preceding::td[. = 'Price']/following-sibling::td"));
		link.click();
		String dupa = price.getText();

		System.out.println("link jest takie duzy " + links.size() + " a numer urządzenia to " + dupa);
	}

}
