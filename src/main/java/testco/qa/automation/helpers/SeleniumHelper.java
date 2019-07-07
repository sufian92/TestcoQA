package testco.qa.automation.helpers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumHelper {

	public WebDriver driver;

	String hubUrl = System.getenv("HUB_URL");

	/*
	 * Method used to instantiate
	 * 
	 * @return Driver
	 */
	public WebDriver initDriver() throws MalformedURLException {

		switch (System.getenv("BROWSER_CONFIG")) {

		case "local":

			switch (System.getenv("BROWSER")) {

			case "chrome":

				driver = new ChromeDriver();

				return driver;
			}

		case "grid":

			switch (System.getenv("BROWSER")) {

			case "chrome":

				DesiredCapabilities capabilities = new DesiredCapabilities();
				System.out.println("Starting chrome on grid");

				capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());

				return driver = (new RemoteWebDriver(new URL(hubUrl), capabilities));
			}
		}

		return null;
	}

	/*
	 * Method used to navigate to the application under test 
	 * @param Driver
	 */
	public void goToApplication(WebDriver driver) {

		driver.get(System.getenv("APP_URL"));

	}

}
