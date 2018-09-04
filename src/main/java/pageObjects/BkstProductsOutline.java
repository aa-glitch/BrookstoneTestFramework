package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BkstProductsOutline {

	WebDriver driver;

	public BkstProductsOutline(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Prod1 = By
			.xpath("/html[1]/body[1]/div[2]/main[1]/div[4]/div[5]/ul[1]/li[1]/div[1]/div[1]/a[1]/picture[1]/img[1]");

	public WebElement Prod1() {
		return driver.findElement(Prod1);
	}

}
