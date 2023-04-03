package omayoblog.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.codemind.b5_project.Utility;

import omayoblog.pages.HomePage;

public class HomePageTestCases extends BaseTestCase {

	HomePage homePage;

	@Test(groups = { "sanity" }, priority = 1,enabled=false)
	public void verifyBlogTitle() {
		assertEquals(driver.getTitle(), "omayo (QAFox.com)");
	}

	@Test(groups = { "sanity" }, priority = 2)
	public void verifyAlertTest() {
		homePage = new HomePage(driver);
		String alertText = homePage.getAlertText();
		assertTrue(alertText.equals("Hello"));
	}

}
