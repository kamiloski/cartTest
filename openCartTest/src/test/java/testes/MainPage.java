package testes;

import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
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
	HomePage hp;
	TopNavigation topNav;
	ComparePage cp;
	SearchResultsPage srp;
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.opencart.com/");
		driver.manage().window().maximize();
		hp = PageFactory.initElements(driver, HomePage.class);
		topNav = PageFactory.initElements(driver, TopNavigation.class);
		srp = PageFactory.initElements(driver, SearchResultsPage.class);
		cp = PageFactory.initElements(driver, ComparePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void checkIsHomePage() {
		Assert.assertEquals(hp.PAGE_TITLE, hp.isHomePage());
	}

	@Test
	public void changeCurrency() {
		String curr = "eur";
		topNav.clickCurrencyDropDown();
		char nowa = topNav.setCurrency(curr);

		Assert.assertEquals(topNav.getCurrentCurrencySymbol(), nowa);
	}

	@Test
	public void searchProducts() {
		hp.inputIntoSearch("ipod");
		hp.clickSearchButton();
	}

	@Test(dependsOnMethods = "searchProducts")
	public void isSearchResultsPage() {
		Assert.assertTrue(srp.isSearchResoultsPage().contains(srp.PAGE_TITLE));
	}

	@Test(dependsOnMethods = "searchProducts")
	public void addToCompare() {
		srp.compareAllItems();
	}

	@Test(dependsOnMethods = "addToCompare")
	public void goToComparePage() {
		srp.goToComparePage();
	}

	@Test(dependsOnMethods = "goToComparePage")
	public void isComparePage() {
		Assert.assertEquals(cp.isComparePage(), cp.PAGE_TITLE);
	}

	@Test(dependsOnMethods = "goToComparePage")
	public void usun() {
		cp.findAvailability();

	}

	@Test(dependsOnMethods = "usun")
	public void chooseRandomItemToCart() {
		cp.chooseRandomItem();
	}

	/*
	 * @AfterTest public void tearDown(){ driver.quit(); driver.close(); }
	 */

}
