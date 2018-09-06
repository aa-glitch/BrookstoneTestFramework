package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BkstSubmitOrder {

	WebDriver driver;

	public BkstSubmitOrder(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='form-row submit-container']//span[contains(text(),'submit order')]")
	WebElement submitOrder;

	public WebElement submitOrder() {
		return submitOrder;
	}

	@FindBy(xpath = "//div[@class='brdialog-close invitation-navigation-element']")
	WebElement customerSurvey;

	public WebElement customerSurvey() {
		return customerSurvey;
	}

	@FindBy(xpath = "//a[@href='/s/Brookstone/index']")
	WebElement backToBrookstone;

	public WebElement backToBrookstone() {
		return backToBrookstone;
	}

	//title 
		public String title() {
		String title = driver.getTitle();
		return title;
		}
}
