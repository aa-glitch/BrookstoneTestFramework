package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BkstProductsOutline {

	WebDriver driver;

	public BkstProductsOutline(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	/*
	 * By Prod1 = By .xpath(
	 * "/html[1]/body[1]/div[2]/main[1]/div[4]/div[5]/ul[1]/li[1]/div[1]/div[1]/a[1]/picture[1]/img[1]"
	 * );
	 * 
	 * public WebElement Prod1() { return driver.findElement(Prod1); }
	 */

	// Product Outline Page
	public WebElement Prod1() {
		// dev05 or production
		try {
			By Prod1 = By.xpath(
					"/html[1]/body[1]/div[2]/main[1]/div[4]/div[5]/ul[1]/li[1]/div[1]/div[1]/a[1]/picture[1]/img[1]");
			return driver.findElement(Prod1);
		}
		// development
		catch (Exception e) {
			// By Prod1 =
			// By.xpath("/html[1]/body[1]/div[2]/main[1]/div[4]/div[5]/ul[1]/li[1]/div[1]/div[3]/div[1]/h2[1]/a[1]");
			By Prod1 = By
					.xpath("/html[1]/body[1]/div[2]/main[1]/div[4]/div[5]/ul[1]/li[1]/div[1]/div[3]/div[1]/h2[1]/a[1]");

			return driver.findElement(Prod1);
		}

	}

	// title
	public String title() {
		String title = driver.getTitle();
		return title;
	}

}
