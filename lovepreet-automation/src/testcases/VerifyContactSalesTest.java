package testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.Base;
import framework.Constants;
import framework.ExcelReader;
import pages.ContactSalesPage;
//import pages.HomePage;

public class VerifyContactSalesTest extends Base {
	@Test(description = "to verify contact sales element exist on the contact sales form")
	public void contactSalesFormTest() {

		/*
		 * HomePage homePage = new HomePage(driver);
		 * 
		 * homePage.clickContactSalesButton();
		 * 
		 * ContactSalesPage contactSalesPage = new ContactSalesPage(driver);
		 * 
		 * contactSalesPage.verifyContactSalesFormFields();
		 */

	}

	@Test(description = "to enter contact sales details on the contact sales form", dataProvider = "getContactSalesData")
	public void enterContactSalesFormTest(HashMap<String, String> testData) {

		/*
		 * HomePage homePage = new HomePage(driver);
		 * 
		 * homePage.clickContactSalesButton();
		 * 
		 * ContactSalesPage contactSalesPage = new ContactSalesPage(driver);
		 * 
		 * contactSalesPage.enterContactSalesForm(testData);
		 */

	}

	/*
	 * @DataProvider(name = "getContactSalesData") public Object[]
	 * getContactSalesData() { ExcelReader excelReader = new ExcelReader(); return
	 * excelReader.getTestData(Constants.TD_CONTACT_SALES,
	 * Constants.SHEET_CONTACT_SALES); }
	 */
}
