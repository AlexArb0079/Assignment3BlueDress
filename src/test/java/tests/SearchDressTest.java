package tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Index;
import Pages.ItemDetails;
import Pages.SearchResults;

public class SearchDressTest {

	//Pages
	WebDriver driver;
	Index index;
	SearchResults searchResults;
	ItemDetails itemDetails;
	
	@BeforeMethod
	public void setUp() {
		//Set up driver
		
		//Windows
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		//Linux
		//System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		
		//Brave
		options.setBinary("K:\\Programas\\BraveSoftware\\Brave-Browser\\Application\\Brave.exe");

		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		//Go to site
		driver.navigate().to("http://automationpractice.com/index.php");
		
		//Set up Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//Set up Pages
		index = new Index(driver, wait);
		searchResults = new SearchResults(driver, wait);
		itemDetails = new ItemDetails(driver, wait);
	}
	
	@AfterMethod
	public void close () {
		driver.close();
		driver.quit();
	}
	
	
	
	@Test
	public void searchForDress() {
		
		index.search("DRESS");
		
		searchResults.changeViewToList();
		searchResults.sortByPriceAsc();
		searchResults.selectFirstItem();
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL.substring(currentURL.length() - 11) , "/color-blue");
		Assert.assertEquals(itemDetails.selectedColour(), "Blue");
		
	}
}
