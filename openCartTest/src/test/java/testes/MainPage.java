package testes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.ComparePage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.TopNavigation;

public class MainPage {
	private static final String[] addToCompare = null;
	HomePage hp;
	TopNavigation topNav;
	ComparePage cp;
	SearchResultsPage srp;
	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
	WebDriver driver = new FirefoxDriver();
	driver.get("http://demo.opencart.com/");
	driver.manage().window().maximize();
	
	hp =  PageFactory.initElements(driver, HomePage.class);
	topNav = PageFactory.initElements(driver, TopNavigation.class);
	srp = PageFactory.initElements(driver, SearchResultsPage.class);
	cp = PageFactory.initElements(driver, ComparePage.class);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test(priority = 0)
	public void checkIsHomePage(){
		hp.isHomePage();
	}
	
	@Test
	public void changeCurrency(){
		topNav.clickButtonChangeCurrency();
		topNav.setCurrency();
	}
	@Test
	public void searchProducts(){
		hp.inputIntoSearch();
		hp.clickSearchButton();
	}

	@Test(dependsOnMethods = "searchProducts")
	public void addToCompare(){
		srp.compareItems();
	}
	
	@Test(dependsOnMethods = "addToCompare")
	public void goToComparePage(){
		srp.goToComparePage();
	}
	
	@Test(dependsOnMethods = "goToComparePage")
	public void usun(){
		cp.findAvailability();
		
	}
	
	@Test(dependsOnMethods = "usun")
	public void chooseRandomItemToCart(){
		cp.chooseRandomItem();
	}
	
/*	@AfterTest
	public void tearDown(){
		driver.close();
	}
*/
}
