package UAT.BrookstoneTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class TestCase5 extends base {

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

	public void TC74() throws InterruptedException, IOException {
		BkstMainpage rd = new BkstMainpage(driver);
		rd.closeButton().click();
		rd.Gifts().click();
		// Thread.sleep(5000);
		rd.GiftsByPrice().click();
		// Thread.sleep(5000);
		rd.GiftsU25().click();

		BkstProductsOutline mg = new BkstProductsOutline(driver);
		mg.Prod1().click();

		BkstProduct pd = new BkstProduct(driver);
		pd.Add_to_cart().click();
		// Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(pd.Go_to_chkout()));
		pd.Go_to_chkout().click();

		BkstChkoutOptionstPage ck = new BkstChkoutOptionstPage(driver);

		ck.Guest_chkout().click();

		BkstChkoutShippingPage sh = new BkstChkoutShippingPage(driver);

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

		bl.Email().sendKeys(prop.getProperty("Email"));

		bl.GiftCardNumber().sendKeys(prop.getProperty("GiftCard"));
		bl.GiftCardPin().sendKeys(prop.getProperty("GiftPin"));
		bl.Apply().click();

//		bl.Ordertotal().getText();
//
//		Assert.assertEquals(bl.Ordertotal().getText(), "$0.00");
//
//		bl.ContinueChkout().click();
//
//		BkstSubmitOrder sb = new BkstSubmitOrder(driver);
//
//		sb.backToBrookstone().click();
//
//		rd.Search().sendKeys("311672");
//		rd.SearchB().click();
//
//		pd.Add_to_cart().click();
//		Thread.sleep(5000);
//		pd.Go_to_chkout().click();
//
//		ck.Guest_chkout().click();
//
//		sh.Continue().click();

	}

}