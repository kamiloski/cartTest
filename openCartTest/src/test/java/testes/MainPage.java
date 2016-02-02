package testes;

import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import components.TopNavigation;
import pages.BasePage;
import pages.ComparePage;
import pages.HomePage;
import pages.SearchResultsPage;

public class MainPage {
	HomePage homepage;
	TopNavigation topnavigation;
	ComparePage comparepage;
	SearchResultsPage searchresultspage;
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.opencart.com/");
		driver.manage().window().maximize();
		homepage = PageFactory.initElements(driver, HomePage.class);
		topnavigation = PageFactory.initElements(driver, TopNavigation.class);
		searchresultspage = PageFactory.initElements(driver, SearchResultsPage.class);
		comparepage = PageFactory.initElements(driver, ComparePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void checkIsHomePage() {
		Assert.assertEquals(homepage.PAGE_TITLE, homepage.isHomePage());
	}

	@Test
	public void changeCurrency() {
		String curr = "eur";
		topnavigation.clickCurrencyDropDown();
		char newCurrencyToSet = topnavigation.setCurrency(curr);
		char currencyAfterSet = topnavigation.getCurrentCurrencySymbol();
		Assert.assertEquals(currencyAfterSet,
							newCurrencyToSet);
	}

	@Test
	public void searchomepageroducts() {
		homepage.inputIntoSearch("ipod");
		homepage.clickSearchButton();
	}

	@Test(dependsOnMethods = "searchomepageroducts")
	public void isSearchResultsPage() {
		Assert.assertTrue(searchresultspage.isSearchResoultsPage().
				 contains(searchresultspage.PAGE_TITLE));
	}

	@Test(dependsOnMethods = "searchomepageroducts")
	public void addToCompare() {
		searchresultspage.compareAllItems();
		searchresultspage.areAllItemsClickedCompare();
	}
		
	@Test(dependsOnMethods = "addToCompare")
	public void goToComparePage() {
		searchresultspage.goToComparePage();
	}

	@Test(dependsOnMethods = "goToComparePage")
	public void isComparePage() {
		Assert.assertEquals(comparepage.isComparePage(), 
							comparepage.PAGE_TITLE);
	}

	@Test(dependsOnMethods = "goToComparePage")
	public void usun() {
		comparepage.findAvailability();

	}

	@Test(dependsOnMethods = "goToComparePage")
	public void chooseRandomItemToCart() {
/*		String aaa = comparepage.putRandomItemToCartAndReturnPrice();
		String sss = comparepage.getPriceFromCart();*/
		
		//System.out.println("put random to " + aaa + " cena z kosza to " + sss);
		Assert.assertTrue(comparepage.putRandomItemToCartAndReturnPrice().
				contains(comparepage.getPriceFromCart()));
		
	}
	
	/*
	 * @AfterTest public void tearDown(){ driver.quit(); driver.close(); }
	 */

}
