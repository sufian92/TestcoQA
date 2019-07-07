package testco.qa.automation.helpers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {

	public WebDriver driver;
	
	public static WebDriverWait wait;

	static String hubUrl = System.getenv("HUB_URL");

	/*
	 * Method used to instantiate the web driver
	 * 
	 * @return Driver
	 */
	public static WebDriver initDriver() throws MalformedURLException {

		switch (System.getenv("BROWSER_CONFIG")) {

		case "local":

			switch (System.getenv("BROWSER")) {

			case "chrome":

				return new ChromeDriver();
			}

		case "grid":

			switch (System.getenv("BROWSER")) {

			case "chrome":

				DesiredCapabilities capabilities = new DesiredCapabilities();
				System.out.println("Starting chrome on grid");

				capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());

				return (new RemoteWebDriver(new URL(hubUrl), capabilities));
			}
		}

		return null;
	}

	/*
	 * Method used to navigate to the application under test
	 * 
	 * @param Driver
	 */
	public static void goToApplication(WebDriver driver) {

		driver.get(System.getenv("APP_URL"));

	}

	/*
	 * Method used that waits until the page loads
	 * 
	 * @param Driver, element
	 */
	public static void waitForPageLoad(WebDriver driver, WebElement element) {
		
		wait = new WebDriverWait(driver,100);
		
		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
