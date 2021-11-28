package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeDemoPage {
	private WebDriver driver;

	public FreeDemoPage(WebDriver driver) {
		this.driver = driver;
	}

	By TXT_FIRST_NAME = By.name("FirstName");

	By TXT_LAST_NAME = By.name("LastName");

	By TXT_EMAIL = By.name("Email");

	By LST_COUNTRY = By.name("Country");

	public void verifyFreeDemoFormFields() {

		driver.findElement(TXT_FIRST_NAME).isDisplayed();

		driver.findElement(TXT_LAST_NAME).isDisplayed();

		driver.findElement(TXT_EMAIL).isDisplayed();

		driver.findElement(LST_COUNTRY).isDisplayed();

	}

}
