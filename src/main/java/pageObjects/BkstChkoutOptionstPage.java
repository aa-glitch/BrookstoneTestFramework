package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BkstChkoutOptionstPage {

	WebDriver driver;

	public BkstChkoutOptionstPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Guest_chkout = By.xpath("//button[@value='Checkout']");

	public WebElement Guest_chkout() {
		return driver.findElement(Guest_chkout);
	}
	
	//title 
		public String title() {
		String title = driver.getTitle();
		return title;
		}

}
