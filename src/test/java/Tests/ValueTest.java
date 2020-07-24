package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webpage.qa.base.Base;
import webpage.qa.pages.HomePage;
import webpage.qa.pages.ValuesPage;

public class ValueTest extends Base {
	HomePage homepage;
	ValuesPage valuepage;

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = PageFactory.initElements(driver, HomePage.class);
		valuepage = PageFactory.initElements(driver, ValuesPage.class);

	}

	@Test(description = "Test verifies that correct values gives 'True' message")
	public void verifyAcceptedValuesTest() {
		// navigate to testing page
		homepage.doClickonFindTab();

		// pass values to test
		valuepage.doPassVals("jeqj1 ch 2 kjjk 3 dkln");

		// get text once message appears
		String msg = valuepage.getText("True:");
		System.out.println("The current message is : " + msg);
		// Test actual vs expected
		Assert.assertTrue(msg.contains("True:"), "Message doesnt match expected result");

	}

	@Test(description = "Test verifies that incorrect values gives 'False' message")
	public void verifyFailingValuesTest() {
		// navigate to testing page
		homepage.doClickonFindTab();

		// pass values to test
		valuepage.doPassVals("1 2");

		// get text once message appears
		String msg = valuepage.getText("False:");
		System.out.println("The current message is : " + msg);
		// Test actual vs expected
		Assert.assertTrue(msg.contains("False:"), "Message doesnt match expected result");

	}

	@Test(description = "Test verifies that passing no value gives message to enter a String")
	public void verifyEmptyValuesTest() {
		// navigate to testing page
		homepage.doClickonFindTab();

		// pass values to test
		valuepage.doPassVals("");

		// get text once message appears
		String msg = valuepage.getText("Please");
		System.out.println("The current message is : " + msg);
		// Test actual vs expected
		Assert.assertTrue(msg.contains("Please"), "Message doesnt match expected result");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
