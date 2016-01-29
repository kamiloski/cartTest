package testes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;

public class MainPage {

WebDriver driver;
HomePage hp;
	
	@BeforeTest
	public void setUp(){
	driver = new FirefoxDriver();
	driver.get("http://demo.opencart.com/");
	driver.manage().window().maximize();
	hp = PageFactory.initElements(driver, HomePage.class);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void isHomePage(){
		hp.isHomePage();
	}
	
	@Test(dependsOnMethods = { "isHomePage" })
	public void changeCurrency(){
		hp.clickButtonChangeCurrency();
		hp.setCurrency();
	}
	@Test
	public void searchProducts(){
		hp.inputIntoSearch();
		hp.clickSearchButton();
	}
	@Test(dependsOnMethods = { "searchProducts" })
	public void addToCompare(){
		hp.compareItems();
	}
	
	@Test(dependsOnMethods = { "addToCompare" })
	public void goToComparePage(){
		hp.goToComparePage();
	
		
	}
/*	@Test(dependsOnMethods = { "goToComparePage" })
	public void usun(){
		hp.findAvailability();
		
	}
*/	
	@Test
	public void chooseRandomItemToCart(){
		hp.chooseRandomItem();
	}
	
/*	@AfterTest
	public void tearDown(){
		driver.close();
	}
*/
}
