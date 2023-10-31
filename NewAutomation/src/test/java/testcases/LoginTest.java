package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicationPages.HomePage;
import applicationPages.LoginPage;

public class LoginTest extends TestBase
{
	public LoginPage lp;
	public HomePage hp;
	
	public LoginTest()
	{ 
		super();	
		
	}
	
	@BeforeMethod	
	public void setup()
	{
		initilization();
		hp= new HomePage();
		lp=new LoginPage();
		
		hp.loginbtnclick();				
	}
	
	@Test(priority = 1)
	public void clickForgotPasswordLink()
	{		
		
		lp.clickLink();
		lp.enterEmailTextbox(prop.getProperty("email"));
		
	}
	
	
   
}
