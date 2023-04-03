package com.codemind.b5_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static void waitForAlert(WebDriver driver, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToWindow(WebDriver driver) {
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowsHandles = driver.getWindowHandles();
		for (String handle : allWindowsHandles) {
			if (!(handle.equals(currentWindowHandle))) {
				driver.switchTo().window(handle);
			}
		}
	}

	public WebDriver getDriver() {
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static String readProperty(String key) {
		File file = new File("src/test/resources/data.properties");
		FileInputStream fileInputStream = null;
		Properties properties;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties.getProperty(key);
	}

	public static void switchToFrame(WebDriver driver, WebElement frameLocator) {
		driver.switchTo().frame(frameLocator);
	}

	public static void switchToMainPageFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void takeSnapshot(WebDriver driver, String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("src/test/resources/screenshots/" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<String> readExcelData() {
		FileInputStream fileInputStream = null;
		HSSFWorkbook hssfWorkbook = null;
		ArrayList<String> data = new ArrayList<String>();

		File file = new File("src/test/resources/registrationData.xls");
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

		int lastRowNum = hssfSheet.getLastRowNum();

		for (int i = 1; i <= lastRowNum; i++) {
			HSSFRow hssfRow = hssfSheet.getRow(i);
			int lastCellNumber = hssfRow.getLastCellNum();
			for (int j = 0; j < lastCellNumber; j++) {

				data.add(hssfRow.getCell(j).getStringCellValue());

			}
		}

		return data;

	}

}
