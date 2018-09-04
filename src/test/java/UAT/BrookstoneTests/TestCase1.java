package UAT.BrookstoneTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BkstChkoutBillingPage;
import pageObjects.BkstChkoutOptionstPage;
import pageObjects.BkstChkoutShippingPage;
import pageObjects.BkstMainpage;
import pageObjects.BkstProduct;
import pageObjects.BkstProductsOutline;
import pageObjects.BkstSubmitOrder;

public class TestCase1 {
// Login page class implemented in normal page object pattern style
	
	// Home page class implemented in Page object factory methdos
	@Test
	public void Login() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://work//selenium//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		//1. Go to dev.Brookstone.com.
		driver.get("https://www.brookstone.com");
		driver.manage().window().maximize();
		
		BkstMainpage rd=new BkstMainpage(driver);
		rd.closeButton().click();
		rd.ProdLine().click();
		
		//2. Navigate to any product detail page, select any applicable product options (color, size, etc.), leave the default quantity at 1, and click to buy the product.
		BkstProductsOutline mg =  new BkstProductsOutline(driver);
		mg.Prod1().click();
		
		//3. In the upper right corner of the page, in the mini cart, click the button to go directly to checkout.
		BkstProduct pd =  new BkstProduct(driver);
		pd.Add_to_cart().click();
		Thread.sleep(5000);
		pd.Go_to_chkout().click();
		
		//4. Verify that you are taken to the Secure Checkout landing page, and there, click the button for the first checkout option, to check out as a guest.
		BkstChkoutOptionstPage ck =  new BkstChkoutOptionstPage(driver);
		ck.Guest_chkout().click();
		
		//5. Confirm that you are taken to the Shipping page of checkout.
		BkstChkoutShippingPage sh = new BkstChkoutShippingPage(driver);
		
		//6. At the Shipping page, verify the following in the page header:
		//a. Brookstone logo/link - at left side of header
        //b. "Back to Cart" link - at upper right side of header, displays with a blue back arrow
        //c. "Log In" link - displays below the "Back to Cart" link
		Assert.assertTrue(sh.login().isDisplayed());
		Assert.assertTrue(sh.BacktoCart().isDisplayed());
		Assert.assertTrue(sh.logo().isDisplayed());
		
		
		//8. Leave the default shipping method selection.
		//7. Populate the required address fields (those with no messaging stating otherwise), and leave the default check mark to use the entered shipping address as the billing address. Be sure to enter the test phone number 603-577-0000 for all test order addresses.
		sh.First_Name().sendKeys("Anshul");
		sh.Last_Name().sendKeys("Anand");
		sh.Address1().sendKeys("81 Pine Street");
		sh.City().sendKeys("Rochester");
		sh.Zipcode().sendKeys("03867");
		sh.Phone().sendKeys("6035770000");
		Thread.sleep(5000);
		
		//9. Click to continue checkout.
		sh.Continue().click();
		
		//10. At the Billing page, verify that the page header matches that from the Shipping page.
		BkstChkoutBillingPage bl = new BkstChkoutBillingPage(driver);
		
		Assert.assertTrue(bl.login().isDisplayed());
		Assert.assertTrue(bl.BacktoCart().isDisplayed());
		Assert.assertTrue(bl.logo().isDisplayed());
		
		//12. Below the billing address area, in the email field, enter a valid email address (contains a "@" and a ".").
		bl.Email().sendKeys("ansh.anand@gmail.com");
		
		//13. Scroll down to the Payment Methods section of the page and enter the information for any test credit card (see column D).
		bl.CardName().sendKeys("Anshul Anand");
		bl.CardNumber().sendKeys("4111111111111111");
		bl.CardCVV().sendKeys("123");
		bl.dropDown().click();
		bl.CardExpYear().click();
		
		//14. Click to continue checkout.
		bl.ContinueChkout().click();
		
		//15. At the Submit Order page, verify that the page header matches that from the previous checkout pages.
		BkstSubmitOrder sb = new BkstSubmitOrder(driver);
		
		//16. Click the button to submit the order.
		sb.submitOrder().click();	
		sb.customerSurvey().click();
		sb.backToBrookstone().click();
		
		//Assert.assertEquals(driver.getTitle(), expected);
		System.out.println(driver.getTitle());
				
		
			
	}
	
	
	
}
