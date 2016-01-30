package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage{
	WebDriver driver;
	@FindBy(xpath = "//td[contains(text(), \"Availability\")]/following-sibling::*")
	List <WebElement> availabilityFields;
	
	@FindBy(xpath = "//input[@value = \"Add to Cart\"]")
	//@FindBy(className = "btn.btn-primary.btn-block")
	List<WebElement> addToCartButtons;	
	
	
	public ComparePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void findAvailability(){
		
		String searchingAvailabilityValue = "Out Of Stock";
		int availabilityPosition =0;
		
		for(int i=0;i<availabilityFields.size();i++){
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
				
				/*for(WebElement linkss: links){
					System.out.println(linkss);
				}*/
					
				
				Random gen = new Random();
				WebElement link = links.get(gen.nextInt(links.size()));

				link.click();
				
				System.out.println("link jest takie duzy " + links.size());
	}
	
}
