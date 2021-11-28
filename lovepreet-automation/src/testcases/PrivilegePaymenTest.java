package testcases;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.Constants;
import framework.Base;
import framework.ExcelReader;
import pages.FreeDemoPage;

import pages.PrivilegePayment;

public class PrivilegePaymenTest extends Base {
	@Test(description = "to verify Calculate Saved Amount on Privilege Payment", dataProvider = "getPrivilegePayment")
	public void calculatePrivilegePaymentTab(HashMap<String, String> testData) {

		PrivilegePayment privilegePayment = new PrivilegePayment(driver);

		privilegePayment.calculatePrivilegePayment(testData);

		privilegePayment.calculatedResult(testData);
		
		privilegePayment.verifyTextAfterSave(testData);

	}

	@DataProvider(name = "getPrivilegePayment")
	public Object[] getContactSalesData() {
		ExcelReader excelReader = new ExcelReader();
		return excelReader.getTestData(Constants.TD_CALCULATE_PAYMENT, Constants.SHEET_CALCULATE_PAYMENT);
	}
}
