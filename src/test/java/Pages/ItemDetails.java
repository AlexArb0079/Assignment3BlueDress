package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetails {
	
	private By colourList;
	
	//private WebDriver driver;
	private WebDriverWait wait;
	
	public ItemDetails(WebDriver driver, WebDriverWait wait) {
		//this.driver = driver;
		this.wait = wait;
		colourList = By.id("color_to_pick_list");

	}

	public String selectedColour() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(colourList)).findElement(By.className("selected")).findElement(By.className("color_pick")).getAttribute("title");
	}
	
	
}
