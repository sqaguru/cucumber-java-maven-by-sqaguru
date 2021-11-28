package pages;

import java.util.HashMap;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import framework.Constants;

public class PrivilegePayment {

	private WebDriver driver;

	public PrivilegePayment(WebDriver driver) {
		this.driver = driver;
	}

	By LNK_HOME_TAB = By.xpath("//span[@id='lblHomeLink']");

	By TXT_MORTAGAGE_AMOUNT = By.xpath("//input[@name='MORTAMT']");

	By TXT_INTEREST_RATE = By.xpath("//input[@name='RATE']");

	By TXT_MORTAGAGE_PAYMENT = By.xpath("//input[@name='MAINPAY']");

	By LST_PAYMENT_FREQUENCY = By.xpath("//select[@name='PFREQ']");

	By LST_ACCELERATED = By.xpath("//select[@name='ACCSEL']");

	By TXT_LUM_SUM_PAYMENT = By.xpath("//input[@name='LUMPAMT']");

	By TXT_LUM_SUM_PAYMENT_PERIOD = By.xpath("//input[@name='LUMPYRS']");

	By TXT_MORTAGAGE_PAYMENT_INCREASE = By.xpath("//input[@name='INCPAY']");

	By LST_MORTAGAGE_PAYMENT_INCREASE_TYPE = By.xpath("//select[@name='INCTYPE']");

	By TXT_MORTAGAGE_PAYMENT_INCREASE_PERIOD = By.xpath("//input[@name='INCYEARS']");

	By BTN_CALCULATE = By.xpath("//button[@id='btnCalculate']");

	By TXT_REVISED_AMORTIZATION_PERIOD_YEARS = By.xpath("//input[@name='AMNEWY']");

	By TXT_REVISED_AMORTIZATION_PERIOD_MONTHS = By.xpath("//input[@name='AMNEWM']");

	By TXT_REVISED_AMORTIZATION_PERIOD_AMOUNT_SAVED = By.xpath("//input[@name='AMINTSAVE']");

	public void calculatePrivilegePayment(HashMap<String, String> testData) {

		driver.findElement(LNK_HOME_TAB).isDisplayed();

		driver.findElement(TXT_MORTAGAGE_AMOUNT).sendKeys(testData.get("Mortagage_Amount"));

		driver.findElement(TXT_INTEREST_RATE).sendKeys(testData.get("Interest_Rate"));

		driver.findElement(TXT_MORTAGAGE_PAYMENT).sendKeys(testData.get("Mortagage_Payment"));

		selectDropDown(LST_PAYMENT_FREQUENCY, testData.get("Payment_Frequency"));

		selectDropDown(LST_ACCELERATED, testData.get("Accelerated"));

		if (testData.get("Accelerated").equals("Yes")) {
			Alert alert = driver.switchTo().alert();

			String alertMessage = driver.switchTo().alert().getText();
			System.out.println("alertMessage : " + alertMessage);
			Assert.assertEquals(alertMessage, Constants.ALERT_MESSAGE);

			alert.accept();
		}

		driver.findElement(TXT_LUM_SUM_PAYMENT).clear();
		driver.findElement(TXT_LUM_SUM_PAYMENT).sendKeys(testData.get("Lum_Sum_Payment"));

		driver.findElement(TXT_LUM_SUM_PAYMENT_PERIOD).clear();
		driver.findElement(TXT_LUM_SUM_PAYMENT_PERIOD).sendKeys(testData.get("Lum_Sum_Payment_Period"));

		driver.findElement(TXT_MORTAGAGE_PAYMENT_INCREASE).clear();
		driver.findElement(TXT_MORTAGAGE_PAYMENT_INCREASE).sendKeys(testData.get("Mortagage_Payment_Increase"));
		// System.out.println("Mortagage_Payment_Increase step executed");
		String strIncreaseType = "";
		if (testData.get("Mortagage_Payment_Increase_Type").equals("Percentage")) {
			strIncreaseType = "% ";
		} else if (testData.get("Mortagage_Payment_Increase_Type").equals("Dollar")) {
			strIncreaseType = " $ ";
		}

		selectDropDown(LST_MORTAGAGE_PAYMENT_INCREASE_TYPE, strIncreaseType);

		driver.findElement(TXT_MORTAGAGE_PAYMENT_INCREASE_PERIOD).clear();
		driver.findElement(TXT_MORTAGAGE_PAYMENT_INCREASE_PERIOD)
				.sendKeys(testData.get("Mortagage_Payment_Increase_Period"));

		driver.findElement(BTN_CALCULATE).click();

	}

	public void calculatedResult(HashMap<String,String> testData) {

		String strYears = driver.findElement(TXT_REVISED_AMORTIZATION_PERIOD_YEARS).getAttribute("value");

		System.out.println("Revized Amortization Period Years : " + strYears);
		
		Assert.assertEquals(strYears, testData.get("Year"),"Year validations");

		String strMonths = driver.findElement(TXT_REVISED_AMORTIZATION_PERIOD_MONTHS).getAttribute("value");

		System.out.println("Revized Amortization Period Months : " + strMonths);
		
		Assert.assertEquals(strMonths, testData.get("Months"),"Months validations");
		

		String strAmountSaved = driver.findElement(TXT_REVISED_AMORTIZATION_PERIOD_AMOUNT_SAVED).getAttribute("value");

		
		Assert.assertEquals(strAmountSaved, testData.get("SavedAmount"),"Saved Amount validations");
		
		System.out.println("Revized Amortization Period Amount Saved : " + strAmountSaved);

	}
	
	public void verifyTextAfterSave(HashMap<String,String> testData) {
		
		String actualMortagageAmount = driver.findElement(TXT_MORTAGAGE_AMOUNT).getAttribute("value");
		
		Assert.assertEquals(actualMortagageAmount, testData.get("Mortagage_Amount"),"Mortagage Amount validation");

		String actualInterestRate = driver.findElement(TXT_INTEREST_RATE).getAttribute("value");
		
		Assert.assertEquals(actualInterestRate, testData.get("Interest_Rate"),"Interest Rate validation");

		String actualMortagagePayment = driver.findElement(TXT_MORTAGAGE_PAYMENT).getAttribute("value");
		
		Assert.assertEquals(actualMortagagePayment, testData.get("Mortagage_Payment"),"Mortagage Payment validation");
		
		String actualPaymentFrequency = getSelectDropDown(LST_PAYMENT_FREQUENCY);
		
		Assert.assertEquals(actualPaymentFrequency, testData.get("Payment_Frequency"),"Payment Frequency validation");
		
        String actualAccelerated = getSelectDropDown(LST_ACCELERATED);
		
		Assert.assertEquals(actualAccelerated, "No","Accelerated validation");

		
		String actualLum_Sum_Payment=  driver.findElement(TXT_LUM_SUM_PAYMENT).getAttribute("value");
		
		Assert.assertEquals(actualLum_Sum_Payment, testData.get("Lum_Sum_Payment"),"Lum Sum Payment validation");

		
		String actualLum_Sum_Payment_Period = driver.findElement(TXT_LUM_SUM_PAYMENT_PERIOD).getAttribute("value");
		
		Assert.assertEquals(actualLum_Sum_Payment_Period, testData.get("Lum_Sum_Payment_Period"),"Lum Sum Payment Period validation");

		
		String actualMortagage_Payment_Increase= driver.findElement(TXT_MORTAGAGE_PAYMENT_INCREASE).getAttribute("value");
		Assert.assertEquals(actualMortagage_Payment_Increase, testData.get("Mortagage_Payment_Increase"),"Mortagage Payment Increase validation");
		
        String actualIncreaseType = getSelectDropDown(LST_MORTAGAGE_PAYMENT_INCREASE_TYPE);
        String strIncreaseType = "";
		if (testData.get("Mortagage_Payment_Increase_Type").equals("Percentage")) {
			strIncreaseType = "%";
		} else if (testData.get("Mortagage_Payment_Increase_Type").equals("Dollar")) {
			strIncreaseType = " $ ";
		}
		
		Assert.assertEquals(actualIncreaseType, strIncreaseType,"Accelerated validation");
		

		
		String actualMortagage_Payment_Increase_Period =driver.findElement(TXT_MORTAGAGE_PAYMENT_INCREASE_PERIOD).getAttribute("value");
				
		Assert.assertEquals(actualMortagage_Payment_Increase_Period, testData.get("Mortagage_Payment_Increase_Period"),"Mortagage Payment Increase Period validation");
		
		
	}

	public void selectDropDown(By strelement, String expectedText) {

		Select selElement = new Select(driver.findElement(strelement));

		selElement.selectByVisibleText(expectedText);

	}
	
	public String getSelectDropDown(By strelement) {
		
		

		Select selElement = new Select(driver.findElement(strelement));
		
		System.out.println("get value : "+ selElement.getAllSelectedOptions().get(0).getText());

		return selElement.getAllSelectedOptions().get(0).getText();

	}

}
