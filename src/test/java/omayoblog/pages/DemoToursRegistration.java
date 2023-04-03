package omayoblog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoToursRegistration {

	WebDriver driver;
	WebElement firstName;
	WebElement lastName;
	WebElement phone;
	WebElement email;

	public DemoToursRegistration(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstName() {
		setFirstName();
		return firstName;
	}

	public void setFirstName() {
		this.firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
	}

	public WebElement getLastName() {
		setLastName();
		return lastName;
	}

	public void setLastName() {
		this.lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement getPhone() {
		setPhone();
		return phone;
	}

	public void setPhone() {
		this.phone = driver.findElement(By.xpath("//input[@name='phone']"));
	}

	public WebElement getEmail() {
		setEmail();
		return email;
	}

	public void setEmail() {
		this.email = driver.findElement(By.xpath("//input[@id='userName']"));
	}

}
