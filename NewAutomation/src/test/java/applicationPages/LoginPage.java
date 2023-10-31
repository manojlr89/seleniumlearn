package applicationPages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testcases.TestBase;

public class LoginPage extends TestBase
{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=\"Forgot your password?\"]")
	WebElement forgotPasswordLink;
	
	@FindBy(name = "email")
	WebElement enterEmail;
	
	
	
	public void clickLink()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
		
		forgotPasswordLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterEmailTextbox(String email)
	{
		enterEmail.sendKeys(email);
		
		
	}
	
    
}
