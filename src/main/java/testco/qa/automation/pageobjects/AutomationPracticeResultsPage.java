package testco.qa.automation.pageobjects;

import testco.qa.automation.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeResultsPage extends AutomationPracticeBasePage {

	@FindBy(how = How.CSS, using = ".page-heading.product-listing")
	private WebElement lblHeading;


	public AutomationPracticeResultsPage(WebDriver driver) {

		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
		
		SeleniumHelper.waitForPageLoad(this.driver,lblHeading);
	}


}
