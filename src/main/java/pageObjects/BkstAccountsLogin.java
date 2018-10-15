package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BkstAccountsLogin {

	WebDriver driver;

	public BkstAccountsLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// view cart in minicart
	@FindBy(xpath = "//img[@class='cart']")
	WebElement Cart;

	public WebElement Cart() {
		return Cart;
	}

	//title 
		public String title() {
		String title = driver.getTitle();
		return title;
		}
}


