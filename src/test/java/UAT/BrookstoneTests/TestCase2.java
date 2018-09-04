package UAT.BrookstoneTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BkstAccountsLogin;
import pageObjects.BkstChkoutBillingPage;
import pageObjects.BkstChkoutOptionstPage;
import pageObjects.BkstChkoutShippingPage;
import pageObjects.BkstMainpage;
import pageObjects.BkstProduct;
import pageObjects.BkstProductsOutline;
import pageObjects.BkstShoppingCart;
import pageObjects.BkstSubmitOrder;

public class TestCase2 {
// Login page class implemented in normal page object pattern style
	
	// Home page class implemented in Page object factory methdos
	@Test
	public void Login() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://work//selenium//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.manage().deleteAllCookies();
		
		//1. Go to Brookstone.com.
		driver.get("https://dev05-us-brookstone.demandware.net/on/demandware.store/Sites-Brookstone-Site");
		//driver.get("https://www.brookstone.com");
		driver.manage().window().maximize();
		
		//2. Navigate to any product detail page, select any applicable product options (color, size, etc.), leave the default quantity at 1, and click to buy the product.
		BkstMainpage rd=new BkstMainpage(driver);
		rd.closeButton().click();
		rd.Top1().click();
		
		BkstProductsOutline ol = new BkstProductsOutline(driver);
		ol.Prod1().click();
		
		//3. In the upper right corner of the page, in the mini cart, click the button to go directly to checkout.
		BkstProduct pd =  new BkstProduct(driver);
		pd.Add_to_cart().click();
		Thread.sleep(5000);
		pd.Go_to_chkout().click();
		
		//4. At the Secure Checkout landing page, click the button to check out as a guest.
		BkstChkoutOptionstPage ck =  new BkstChkoutOptionstPage(driver);
		ck.Guest_chkout().click();
		
		//5. At the Shipping page of checkout, in the page header, click the Brookstone logo/link.
		//6. Verify that you are taken to the site home page.
		BkstChkoutShippingPage sh = new BkstChkoutShippingPage(driver);
		sh.logo().click();
		
		//7. In the upper right corner of the page, click either the "Shopping Cart" icon in the page header or the "View Cart" button in the mini cart.
		rd.Cart().click();
		
		//8. Back at the Shopping Cart page, click the button to check out.
		BkstShoppingCart sc = new BkstShoppingCart(driver);
		sc.Checkout().click();
		
		//9. At the Secure Checkout landing page, click the button to check out as a guest.
		ck.Guest_chkout().click();
		
		//10. Again at the Shipping page, in the page header, click the "Back to Cart" link.
		sh.BacktoCart().click();
		
		//11. Verify that you are taken back to the Shopping Cart page.
		//12. At the Shopping Cart page, click the button to check out.
		sc.Checkout().click();
		
		
		//13. At the Secure Checkout landing page, click the button to check out as a guest.
		ck.Guest_chkout().click();
		
		//14. Again at the Shipping page, in the page header, click the "Log In" link.
		sh.login().click();
		
		//15. Verify that you are taken to the My Account Login page.
		//16. In the upper right corner of the page, click either the "Shopping Cart" icon in the page header or the "View Cart" button in the mini cart.
		
		BkstAccountsLogin ac = new BkstAccountsLogin(driver);
		Actions action=new Actions(driver);
		action.moveToElement(ac.Cart()).click().perform();
		//ac.Cart().click();
		
		
		//driver.findElement(By.xpath("//img[@class='cart']")).click();
		
		//17. At the Shopping Cart page, click the button to check out.
		sc.Checkout().click();
		
		//18. At the Secure Checkout landing page, click the button to check out as a guest.
		ck.Guest_chkout().click();
		
		//19. Again at the Shipping page, in the page header, hover your mouse pointer over the Customer Care phone number to confirm it is not a link.
		// to be done 
		
				
		//Assertions
		Assert.assertTrue(sh.login().isDisplayed());
		Assert.assertTrue(sh.BacktoCart().isDisplayed());
		Assert.assertTrue(sh.logo().isDisplayed());
		
		sh.First_Name().sendKeys("Anshul");
		sh.Last_Name().sendKeys("Anand");
		sh.Address1().sendKeys("81 Pine Street");
		sh.City().sendKeys("Rochester");
		sh.Zipcode().sendKeys("03867");
		sh.Phone().sendKeys("6035770000");
		Thread.sleep(5000);
		sh.Continue().click();
		
		BkstChkoutBillingPage bl = new BkstChkoutBillingPage(driver);
		
		Assert.assertTrue(bl.login().isDisplayed());
		Assert.assertTrue(bl.BacktoCart().isDisplayed());
		Assert.assertTrue(bl.logo().isDisplayed());
		
		bl.Email().sendKeys("ansh.anand@gmail.com");
		bl.CardName().sendKeys("Anshul Anand");
		bl.CardNumber().sendKeys("4111111111111111");
		bl.CardCVV().sendKeys("123");
		bl.dropDown().click();
		bl.CardExpYear().click();
		
		bl.ContinueChkout().click();
		
		
		BkstSubmitOrder sb = new BkstSubmitOrder(driver);
		sb.submitOrder().click();	
		sb.customerSurvey().click();
		sb.backToBrookstone().click();
		
		//Assert.assertEquals(driver.getTitle(), expected);
		System.out.println(driver.getTitle());
		
	
		
	}
	
	
	
}
