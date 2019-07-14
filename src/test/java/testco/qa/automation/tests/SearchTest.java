package testco.qa.automation.tests;

import org.testng.annotations.Test;

import testco.qa.automation.helpers.SeleniumHelper;
import testco.qa.automation.pageobjects.AutomationPracticeHomePage;
import testco.qa.automation.pageobjects.AutomationPracticeResultsPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class SearchTest {

	public WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		
		driver  = SeleniumHelper.initDriver();
		
		SeleniumHelper.goToApplication(driver);
	}

	@Test
	public void searchForItemTest() {
		
		AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(driver);
		
		AutomationPracticeResultsPage resultsPage = homePage.searchForItem("dresses");
	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}

}
