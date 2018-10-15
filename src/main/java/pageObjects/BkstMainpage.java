package pageObjects;

import org.openqa.selenium.By;
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

	// close pop-up signup message
	public WebElement closeButton() {
		// dev05 or production
		try {
			By closeButton = By.className("ui-button-icon-primary");
			return driver.findElement(closeButton);
		}
		// staging
		catch (Exception e) {
			By closeButton = By.xpath("//button[@title='Close']");
			return driver.findElement(closeButton);
		}

	}

	// ==========================================dev05===========================================================

	// ==========================================staging=========================================================

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
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]")
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

	// ==========================================staging=========================================================

	// Shopping Cart
	@FindBy(xpath = "//img[@class='cart']")
	WebElement Cart;

	public WebElement Cart() {
		return Cart;
	}

	// title
	public String title() {
		String title = driver.getTitle();
		return title;
	}

	// ==============================================dev05==============================================
	// ProdLine
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[5]/div[1]/div[1]/div[1]/a[1]/img[1]")
	WebElement ProdC;

	public WebElement ProdC() {
		return ProdC;
	}

	@FindBy(xpath = "//div[@class='header-search not-logged-in']//input[@id='q']")
	WebElement Search;

	public WebElement Search() {
		return Search;
	}

	@FindBy(xpath = "//div[@class='header-search not-logged-in']//input[@type='image']")
	WebElement SearchB;

	public WebElement SearchB() {
		return SearchB;
	}

	By Gifts = By.linkText("GIFTS");

	public WebElement Gifts() {
		return driver.findElement(Gifts);
	}

	@FindBy(xpath = "/html//div[@id='primary']//a[@href='https://staging-us-brookstone.demandware.net/s/Brookstone/gifts-by-price']/img[@alt='Shop by Category']")
	WebElement GiftsByPrice;

	public WebElement GiftsByPrice() {
		return GiftsByPrice;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[4]/div[2]/div[1]/a[1]/img[1]")
	WebElement GiftsU25;

	public WebElement GiftsU25() {
		return GiftsU25;
	}

}
