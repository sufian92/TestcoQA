package testco.qa.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeHomePage extends AutomationPracticeBasePage {

	@FindBy(how = How.ID, using = "searchbox")
	private WebElement formSearch;

	@FindBy(how = How.ID, using = "search_query_top")
	private WebElement txtSearchBox;

	public AutomationPracticeHomePage(WebDriver driver) {

		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	/*
	 * Method used to search for an item
	 * 
	 * @return Driver
	 */
	public void searchForItem(String item) {

		txtSearchBox.sendKeys(item);

		formSearch.submit();

	}

}
