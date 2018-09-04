package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BkstMainpage {

	WebDriver driver;

	public BkstMainpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "ui-button-icon-primary")
	WebElement closeButton;

	public WebElement closeButton() {
		return closeButton;
	}

	// Top Advertisement
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/p[1]/a[1]/picture[1]/img[1]")
	 WebElement Top1;

	public WebElement Top1() {
		return Top1;
	}

			
	
	// Main Page - 6 Main Categories
	By ProdLine = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[1]/div[3]/a[1]/img[1]");
		
	public WebElement ProdLine() {
		return driver.findElement(ProdLine);
	}

	// Top Prod1
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	 WebElement Prod1;

	public WebElement Prod1() {
		return Prod1;
	}

	// Top Prod2
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement Prod2;

	public WebElement Prod2() {
		return Prod2;
	}

	// Top Prod3
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement Prod3;

	public WebElement Prod3() {
		return Prod3;
	}

	// Shopping Cart
	@FindBy(xpath = "//img[@class='cart']")
	WebElement Cart;

	public WebElement Cart() {
		return Cart;
	}

}
