package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BkstChkoutShippingPage {

	WebDriver driver;

	public BkstChkoutShippingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By logo = By.xpath("//*[@id='svg2']");

	public WebElement logo() {
		return driver.findElement(logo);
	}

	By ChkOutHeading = By.xpath("//h1[@class='hide-on-mobile']");

	public WebElement ChkOutHeading() {
		return driver.findElement(ChkOutHeading);
	}

	By ShipColor = By.xpath("//div[@class='step-1 active']");

	public WebElement ShipColor() {
		return driver.findElement(ShipColor);
	}

	By BillColor = By.xpath("//div[@class='step-2 inactive']");

	public WebElement BillColor() {
		return driver.findElement(BillColor);
	}

	By SubmitColor = By.xpath("//div[@class='step-3 inactive']");

	public WebElement SubmitColor() {
		return driver.findElement(SubmitColor);
	}

	By ShipProgress = By.xpath("//span[@class='text'][contains(text(),'Shipping')]");

	public WebElement ShipProgress() {
		return driver.findElement(ShipProgress);
	}

	By BillProgress = By.xpath("//span[@class='text'][contains(text(),'Billing')]");

	public WebElement BillProgress() {
		return driver.findElement(BillProgress);
	}

	By SubmitProgress = By.xpath("//span[contains(text(),'Submit Order')]");

	public WebElement SubmitProgress() {
		return driver.findElement(SubmitProgress);
	}

	By BacktoCart = By.xpath("//div[@class='back-to-cart']//a");

	public WebElement BacktoCart() {
		return driver.findElement(BacktoCart);
	}

	By login = By.xpath("//div[@class='link-label login']//a[@title='Log In'][contains(text(),'Log In')]");

	public WebElement login() {
		return driver.findElement(login);
	}

	By First_Name = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']");

	public WebElement First_Name() {
		return driver.findElement(First_Name);
	}

	By Last_Name = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']");

	public WebElement Last_Name() {
		return driver.findElement(Last_Name);
	}

	By Address1 = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']");

	public WebElement Address1() {
		return driver.findElement(Address1);
	}

	By Address2 = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address2']");

	public WebElement Address2() {
		return driver.findElement(Address2);
	}

	By Zipcode = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_zip']");

	public WebElement Zipcode() {
		return driver.findElement(Zipcode);
	}

	By City = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']");

	public WebElement City() {
		return driver.findElement(City);
	}

	By Select_State = By.xpath("//p[contains(text(),'Select State')]");

	public WebElement Select_State() {
		return driver.findElement(Select_State);
	}

	By State = By.xpath("//li[contains(text(),'New Hampshire')]");

	public WebElement State() {
		return driver.findElement(State);
	}

	By SsState = By.xpath("//li[contains(text(),'Colorado')]");

	public WebElement SsState() {
		return driver.findElement(SsState);
	}

	By Phone = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']");

	public WebElement Phone() {
		return driver.findElement(Phone);
	}

	By Continue = By.xpath("//div[@id='bottomcheckoutbutton']//span[contains(text(),'Continue Checkout')]");

	public WebElement Continue() {
		return driver.findElement(Continue);
	}

	By TwodayShip = By.xpath("//fieldset//div[2]//div[1]//ins[1]");

	public WebElement TwodayShip() {
		return driver.findElement(TwodayShip);
	}

	By NextdayShip = By.xpath("//fieldset//div[3]//div[1]//ins[1]");

	public WebElement NextdayShip() {
		return driver.findElement(NextdayShip);
	}

	// title
	public String title() {
		String title = driver.getTitle();
		return title;
	}

}
