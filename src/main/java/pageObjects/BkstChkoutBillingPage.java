package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BkstChkoutBillingPage {

	WebDriver driver;

	public BkstChkoutBillingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='svg2']")
	WebElement logo;

	public WebElement logo() {
		return logo;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[2]/span[2]")
	WebElement ShipAddress1;
	public WebElement getShipAddr1() {
		return ShipAddress1;
		
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[2]/span[1]")
	WebElement ShipName;
	public WebElement getShipName() {
		return ShipName;
		
	}
	
	
	
	By BacktoCart = By.xpath("//div[@class='back-to-cart']//a");

	public WebElement BacktoCart() {
		return driver.findElement(BacktoCart);
	}

	By login = By.xpath("//div[@class='link-label login']//a[@title='Log In'][contains(text(),'Log In')]");

	public WebElement login() {
		return driver.findElement(login);
	}

	By Email = By.xpath("//input[@id='dwfrm_billing_billingAddress_email_emailAddress']");

	public WebElement Email() {
		return driver.findElement(Email);
	}

	By CardName = By.xpath("//input[@id='dwfrm_billing_paymentMethods_creditCard_owner']");

	public WebElement CardName() {
		return driver.findElement(CardName);
	}

	By CardNumber = By.xpath("//input[@id='dwfrm_billing_paymentMethods_creditCard_number']");

	public WebElement CardNumber() {
		return driver.findElement(CardNumber);
	}

	By CardCVV = By.cssSelector("#dwfrm_billing_paymentMethods_creditCard_cvn");

	public WebElement CardCVV() {
		return driver.findElement(CardCVV);
	}

	By dropDown = By.xpath(
			"/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[1]/fieldset[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/p[1]");

	public WebElement dropDown() {
		return driver.findElement(dropDown);
	}

	By CardExpYear = By.xpath("//li[contains(text(),'2022')]");

	public WebElement CardExpYear() {
		return driver.findElement(CardExpYear);
	}

	By ContinueChkout = By.xpath(
			"//div[@class='form-row form-row-button hide-on-mobile']//span[contains(text(),'Continue Checkout')]");

	public WebElement ContinueChkout() {
		return driver.findElement(ContinueChkout);
	}
	
	//title 
		public String title() {
		String title = driver.getTitle();
		return title;
		}
}
