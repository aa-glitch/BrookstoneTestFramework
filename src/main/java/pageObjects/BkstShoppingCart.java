package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BkstShoppingCart {

	WebDriver driver;

	public BkstShoppingCart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Secure Checkout
	@FindBy(xpath = "//*//button[@value='Secure Checkout']")
	WebElement Checkout;

	public WebElement Checkout() {
		return Checkout;
	}

	
	//title 
		public String title() {
		String title = driver.getTitle();
		return title;
		}
}
