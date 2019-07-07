package testco.qa.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeBasePage {
	
	protected WebDriver driver;
	
	@FindBy(how = How.CSS, using = ".header_user_info a")
    private WebElement lnkSignIn;
	
	
	public AutomationPracticeBasePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

}
