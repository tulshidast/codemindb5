package omayoblog.testcases;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codemind.b5_project.Utility;
import omayoblog.pages.DemoToursRegistration;

public class DemoToursRegistrationTestCase extends BaseTestCase {

	DemoToursRegistration demoToursRegistration;

	@Test(dataProvider = "registrationDataProvider", groups = { "sanity" })
	public void verifyRegistration(String firstName, String lastName, String phone, String email) {
		demoToursRegistration = new DemoToursRegistration(driver);
		demoToursRegistration.getFirstName().sendKeys(firstName);
		demoToursRegistration.getLastName().sendKeys(lastName);
		demoToursRegistration.getPhone().sendKeys(phone);
		demoToursRegistration.getEmail().sendKeys(email);
		assertTrue(true);

	}

	@DataProvider(name = "registrationDataProvider")
	public String[][] dataProviderForRegistration() {
		ArrayList<String> arrayList = Utility.readExcelData();
		String[][] array = new String[1][arrayList.size()];
		array[0][0] = arrayList.get(0);
		array[0][1] = arrayList.get(1);
		array[0][2] = arrayList.get(2);
		array[0][3] = arrayList.get(3);
		return array;

	}

}
