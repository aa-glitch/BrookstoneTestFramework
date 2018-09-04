package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
