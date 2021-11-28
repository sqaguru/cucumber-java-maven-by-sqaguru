package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactSalesPage {
	private WebDriver driver;

	public ContactSalesPage(WebDriver driver) {
		this.driver = driver;
	}

	By TXT_FIRST_NAME = By.xpath("//input[@name='FirstName']");

	By TXT_LAST_NAME = By.xpath("//input[@name='LastName']");

	By TXT_COMPANY_NAME = By.xpath("//input[@name='CompanyName']");

	By LST_NUMBER_OF_EMPLOYEES = By.xpath("//select[@name='NoOfEmployees']");

	public void verifyContactSalesFormFields() {

		driver.findElement(TXT_FIRST_NAME).isDisplayed();

		driver.findElement(TXT_LAST_NAME).isDisplayed();

		driver.findElement(TXT_COMPANY_NAME).isDisplayed();

	}

	public void enterContactSalesForm(HashMap<String, String> testData) {

		driver.findElement(TXT_FIRST_NAME).sendKeys(testData.get("FirstName"));

		driver.findElement(TXT_LAST_NAME).sendKeys(testData.get("LastName"));

		driver.findElement(TXT_COMPANY_NAME).sendKeys(testData.get("CompanyName"));

	}
}
