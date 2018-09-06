package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BkstProduct {

	WebDriver driver;

	public BkstProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Add_to_cart = By.xpath("//button[@id='add-to-cart']");

	public WebElement Add_to_cart() {
		return driver.findElement(Add_to_cart);
	}

	By Go_to_chkout = By.xpath("//a[@title='Go Directly to Checkout']");

	public WebElement Go_to_chkout() {

		return driver.findElement(Go_to_chkout);
	}

	//title 
		public String title() {
		String title = driver.getTitle();
		return title;
		}
}
