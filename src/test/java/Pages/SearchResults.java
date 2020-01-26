package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {

	private By viewAsList;
	private By sortBy;
	private By firstBlue;
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SearchResults(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		viewAsList = By.id("list");
		sortBy = By.id("selectProductSort");
		firstBlue = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div/div[2]/div[2]/ul/li[2]/a");
	}
	
	public void changeViewToList() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(viewAsList));
		
		//Porque la mayoria de las veces con un solo click no funciona
		while(!driver.findElement(viewAsList).getAttribute("class").equals("selected")) {
			driver.findElement(viewAsList).click();
		}
		
	}
	
	public void sortByPriceAsc() {
		new Select(driver.findElement(sortBy)).selectByValue("price:asc");
	}
	
	public void selectFirstItem() {
		wait.until(ExpectedConditions.elementToBeClickable(firstBlue)).click();
	}
}
