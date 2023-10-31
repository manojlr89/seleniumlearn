package applicationPages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testcases.TestBase;

public class HomePage extends TestBase {
	
	
	
	
	@FindBy(xpath = "//span[text()=\"Log In\"]")
	WebElement logInButton;
	
	@FindBy(xpath = "//a[text()=\"CRM\"]")
	WebElement clickCRM;
	
	@FindBy(xpath = "// li//a[text()=\"Automotive CRM\"]")
	WebElement clickAutoCRM;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginbtnclick()
	{
		logInButton.click();
		
		
	}
	
	public String getPageTitle()
	{
		String gettitle=driver.getTitle();
		
		return gettitle;
	}
	
	public void clickAutoCRMs()
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(clickCRM).build().perform();
		clickAutoCRM.click();
		
		
		
		
	}
	
	
	
	
	
	

}
