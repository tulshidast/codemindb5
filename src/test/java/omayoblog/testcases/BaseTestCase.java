package omayoblog.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.codemind.b5_project.Utility;

public class BaseTestCase {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void initiateBrowser() {
		this.driver = new Utility().getDriver();
		driver.get(Utility.readProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.takeSnapshot(driver, result.getName());
		}
		driver.quit();
	}

}
