package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;

public class Utils {

	private static String projectPath;

	private static final String properties_file = "configuration.properties";

	private static Properties properties;

	public Utils() {

		projectPath = System.getProperty(Constants.USER_DIR);

		System.out.println("projectPath: " + projectPath);

		properties = new Properties();

		try {
			InputStream input = new FileInputStream(projectPath + "\\" + properties_file);
			properties.load(input);
		} catch (Exception e) {
			Reporter.log("Exception in Properties FileInputStream " + e.getMessage(), true);
		}

		System.out.println(properties.get(Constants.BROWSER_NAME));
	}

	public static String getProjectPath() {
		return projectPath;
	}

	public static Properties getProperties() {
		return properties;
	}

}
