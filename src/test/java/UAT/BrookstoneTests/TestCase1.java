package UAT.BrookstoneTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BkstChkoutBillingPage;
import pageObjects.BkstChkoutOptionstPage;
import pageObjects.BkstChkoutShippingPage;
import pageObjects.BkstMainpage;
import pageObjects.BkstProduct;
import pageObjects.BkstProductsOutline;
import pageObjects.BkstSubmitOrder;
import resources.base;

public class TestCase1 extends base {
	
	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");

		// 1. Go to Brookstone.com.
		driver.get(prop.getProperty("urlstag"));
		driver.manage().window().maximize();
		log.info("Navigated to Home page");

	}

	@Test
	public void TC1() throws InterruptedException, IOException {

		BkstMainpage rd = new BkstMainpage(driver);
		rd.closeButton().click();
		rd.ProdLine().click();

		// 2. Navigate to any product detail page, select any applicable product options
		// (color, size, etc.), leave the default quantity at 1, and click to buy the
		// product.
		BkstProductsOutline mg = new BkstProductsOutline(driver);
		mg.Prod1().click();

		// 3. In the upper right corner of the page, in the mini cart, click the button
		// to go directly to checkout.
		BkstProduct pd = new BkstProduct(driver);
		pd.Add_to_cart().click();
		Thread.sleep(5000);
		pd.Go_to_chkout().click();

				
		BkstChkoutOptionstPage ck = new BkstChkoutOptionstPage(driver);
		Assert.assertEquals(ck.title(), "Brookstone Account Login");
		log.info("Verified 4. Verify that you are taken to the Secure Checkout landing page");
		
		// 4. click the button for the first checkout option, to check out as a guest.
		ck.Guest_chkout().click();

		// 5. Confirm that you are taken to the Shipping page of checkout.
		BkstChkoutShippingPage sh = new BkstChkoutShippingPage(driver);

		// 6. At the Shipping page, verify the following in the page header:
		// a. Brookstone logo/link - at left side of header
		// b. "Back to Cart" link - at upper right side of header, displays with a blue
		// back arrow
		// c. "Log In" link - displays below the "Back to Cart" link
		Assert.assertTrue(sh.login().isDisplayed());
		Assert.assertTrue(sh.BacktoCart().isDisplayed());
		Assert.assertTrue(sh.logo().isDisplayed());

		// 8. Leave the default shipping method selection.
		// 7. Populate the required address fields (those with no messaging stating
		// otherwise), and leave the default check mark to use the entered shipping
		// address as the billing address. Be sure to enter the test phone number
		// 603-577-0000 for all test order addresses.
		sh.First_Name().sendKeys(prop.getProperty("FirstName"));
		sh.Last_Name().sendKeys(prop.getProperty("LastName"));
		sh.Address1().sendKeys(prop.getProperty("Address1"));
		sh.City().sendKeys(prop.getProperty("City"));
		sh.Zipcode().sendKeys(prop.getProperty("Zipcode"));
		sh.Phone().sendKeys(prop.getProperty("Phone"));
		Thread.sleep(5000);

		// 9. Click to continue checkout.
		sh.Continue().click();

		// 10. At the Billing page, verify that the page header matches that from the
		// Shipping page.
		BkstChkoutBillingPage bl = new BkstChkoutBillingPage(driver);
		Assert.assertEquals(bl.getShipAddr1().getText(), prop.getProperty("Address1"));
				
		String FullName = prop.getProperty("FirstName") + " " + prop.getProperty("LastName");
		Assert.assertEquals(bl.getShipName().getText(), FullName);
		log.info("Verified 10. At the Billing page, verify that the page header matches that from the Shipping page");

		Assert.assertTrue(bl.login().isDisplayed());
		Assert.assertTrue(bl.BacktoCart().isDisplayed());
		Assert.assertTrue(bl.logo().isDisplayed());

		// 12. Below the billing address area, in the email field, enter a valid email
		// address (contains a "@" and a ".").
		bl.Email().sendKeys(prop.getProperty("Email"));

		// 13. Scroll down to the Payment Methods section of the page and enter the
		// information for any test credit card (see column D).
		bl.CardName().sendKeys(FullName);
		bl.CardNumber().sendKeys(prop.getProperty("VisaCardNo"));
		bl.CardCVV().sendKeys(prop.getProperty("VisaCardCvv"));
		bl.dropDown().click();
		bl.CardExpYear().click();

		// 14. Click to continue checkout.
		bl.ContinueChkout().click();

		// 15. At the Submit Order page, verify that the page header matches that from
		// the previous checkout pages.
		BkstSubmitOrder sb = new BkstSubmitOrder(driver);

/*		// 16. Click the button to submit the order.
		sb.submitOrder().click();
		sb.customerSurvey().click();
		sb.backToBrookstone().click();
*/
		// Assert.assertEquals(driver.getTitle(), expected);
		System.out.println(driver.getTitle());

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;

	}

}
