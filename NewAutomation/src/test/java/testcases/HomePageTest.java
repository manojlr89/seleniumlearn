package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import applicationPages.HomePage;
import applicationPages.LoginPage;

@Ignore
public class HomePageTest extends TestBase{
	HomePage homePage;
	public HomePageTest()
	{ 
		//It called the parent class constructor
		super();
	}	
	
	@BeforeMethod 
	public void setup()
	{
		initilization();
		
		homePage=new HomePage();
	}
	
	@AfterMethod 
	public void screencapture(ITestResult result) throws IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			
				String screenshotpath = null;
				screenshotpath= captureScreenshot(result.getTestContext().getName()+ ".png");
				
			
		}else if (result.getStatus()== ITestResult.SUCCESS)
		{
			
		}
		
	}
	
	@Test 
	public void verifyTitle()
	{
		String actualTitle= homePage.getPageTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualTitle, "#1 Free CRM Power Up your Entire Business Free Forever1");
		System.out.println("verify title correctly");
		soft.assertAll();
		//assertEquals(actualTitle, "#1 Free CRM Power Up your Entire Business Free Forever");
		
	}
	
	@Test (enabled = false)
	public void btnClick()
	{
		homePage.loginbtnclick();
		//assertEquals(actualTitle, "#1 Free CRM Power Up your Entire Business Free Forever");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("verify title correctly");
	}
	@Test
	public void btnmenu() {
	    homePage.clickAutoCRMs();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod (groups="smoke")
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	
	

}
