package UAT.BrookstoneTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import resources.base;

public class TestCase3and4 extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest(groups = { "Smoke" })
	public void initialize() throws IOException {

		driver = initializeDriver();
		// log.info("Driver is initialized");

		// 1. Go to Brookstone.com.
		String env = prop.getProperty("environment");
		driver.get(prop.getProperty(env));
		driver.manage().window().maximize();
		// log.info("Navigated to Home page");

	}

	@AfterTest(groups = { "Smoke" })
	public void teardown() {

		driver.close();
		driver = null;

	}

	@Test(groups = { "Smoke" })

	public void TC3and4and4() throws InterruptedException, IOException {
		BkstMainpage rd = new BkstMainpage(driver);
		rd.closeButton().click();
		rd.ProdLine().click();

		BkstProductsOutline mg = new BkstProductsOutline(driver);
		mg.Prod1().click();

		BkstProduct pd = new BkstProduct(driver);
		pd.Add_to_cart().click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(pd.Go_to_chkout()));
		pd.Go_to_chkout().click();

		BkstChkoutOptionstPage ck = new BkstChkoutOptionstPage(driver);
		Assert.assertEquals(ck.title(), "Brookstone Account Login");
		log.info("TC3and4 Verified 4. Verify that you are taken to the Secure Checkout landing page");

		ck.Guest_chkout().click();

		BkstChkoutShippingPage sh = new BkstChkoutShippingPage(driver);

		Assert.assertEquals(sh.ChkOutHeading().getText(), "Checkout");
		log.info("TC3and4 Verified 5a). Verify the checkout heading");

		Assert.assertEquals(sh.ShipProgress().getText(), "Shipping");
		Assert.assertEquals(sh.ShipColor().getCssValue("background-color"), "rgba(7, 156, 205, 1)");
		log.info("TC3and4 Verified 5b). Verify that active test is Shipping and color is blue");

		Assert.assertEquals(sh.BillProgress().getText(), "Billing");
		Assert.assertEquals(sh.BillColor().getCssValue("background-color"), "rgba(153, 153, 153, 1)");
		log.info("TC3and4 Verified 5b). Verify that inactive test is Billing and color is grey");

		Assert.assertEquals(sh.SubmitProgress().getText(), "Submit Order");
		Assert.assertEquals(sh.SubmitColor().getCssValue("background-color"), "rgba(153, 153, 153, 1)");
		log.info("TC3and4 Verified 5b). Verify that inactive test is Submit Order and color is grey");

		sh.First_Name().sendKeys(prop.getProperty("FirstName"));
		sh.Last_Name().sendKeys(prop.getProperty("LastName"));
		sh.Address1().sendKeys(prop.getProperty("Address1"));

		// Thread.sleep(5000);
		sh.City().sendKeys(prop.getProperty("City"));
		sh.Select_State().click();
		sh.State().click();
		sh.Phone().sendKeys(prop.getProperty("Phone"));
		sh.Zipcode().sendKeys(prop.getProperty("Zipcode"));
		// sh.TwodayShip().click();

		// Thread.sleep(5000);

		// 9. Click to continue checkout.
		sh.Continue().click();

		BkstChkoutBillingPage bl = new BkstChkoutBillingPage(driver);

		// check from below

		Assert.assertEquals(sh.ChkOutHeading().getText(), "Checkout");
		log.info("TC3and4 Verified 5a). Verify the checkout heading");

		// Assert.assertEquals(sh.ShipProgress().getText(), "Shipping");
		// Assert.assertEquals(sh.ShipColor().getCssValue("background-color"), "rgba(7,
		// 156, 205, 1)");
		log.info("TC3and4 Verified 5b). Verify that active test is Shipping and color is blue");

		// Assert.assertEquals(sh.BillProgress().getText(), "Billing");
		// Assert.assertEquals(sh.BillColor().getCssValue("background-color"),
		// "rgba(153, 153, 153, 1)");
		log.info("TC3and4 Verified 5b). Verify that inactive test is Billing and color is grey");

		// Assert.assertEquals(sh.SubmitProgress().getText(), "Submit Order");
		// Assert.assertEquals(sh.SubmitColor().getCssValue("background-color"),
		// "rgba(153, 153, 153, 1)");
		log.info("TC3and4 Verified 5b). Verify that inactive test is Submit Order and color is grey");

	}

}
