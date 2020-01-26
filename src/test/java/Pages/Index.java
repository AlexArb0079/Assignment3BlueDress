package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Index {

	private By searchInputText;
	//private By searchButton;
	
	//private WebDriver driver;
	private WebDriverWait wait;
	
	public Index(WebDriver driver, WebDriverWait wait) {
		//this.driver = driver;
		this.wait = wait;
		searchInputText = By.id("search_query_top");
		//searchButton = By.name("submit_search");
	}

	public void search(String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputText)).sendKeys(text, Keys.ENTER);
	}
}
