package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Base extends Utils {
	protected WebDriver driver;

	private final String CHROME_DRIVER_EXE = "chromedriver.exe";
	private final String FIREFOX_DRIVER_EXE = "geckodriver.exe";
	private final String EDGE_DRIVER_EXE = "edge.exe";

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("Utils.getProperties().getProperty(\"browser_name\"): "
				+ Utils.getProperties().getProperty(Constants.BROWSER_NAME));

		if (Utils.getProperties().getProperty(Constants.BROWSER_NAME).equalsIgnoreCase(Constants.BROWSER_TYPE_CHROME)) {
			System.setProperty("webdriver.chrome.driver",
					getProjectPath() + Constants.PATH_DRIVERS + CHROME_DRIVER_EXE);
		} else if (Utils.getProperties().getProperty(Constants.BROWSER_NAME)
				.equalsIgnoreCase(Constants.BROWSER_TYPE_EDGE)) {
			System.setProperty("webdriver.edge.driver", getProjectPath() + Constants.PATH_DRIVERS + EDGE_DRIVER_EXE);
		} else {
			System.setProperty("webdriver.firefox.driver",
					getProjectPath() + Constants.PATH_DRIVERS + FIREFOX_DRIVER_EXE);
		}
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(Utils.getProperties().getProperty(Constants.URL));

	}

	@AfterMethod

	public void afterMethod() {
		driver.close();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}
