package omayoblog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selenium143Page {

	WebDriver driver;
	WebElement whatIsSeleniumLink;

	public Selenium143Page(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWhatIsSeleniumLink() {
		setWhatIsSeleniumLink();
		return whatIsSeleniumLink;
	}

	public void setWhatIsSeleniumLink() {
		this.whatIsSeleniumLink = driver.findElement(By.xpath("//a[text()='What is Selenium?']"));
	}

}
