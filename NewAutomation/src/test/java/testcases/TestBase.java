package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static String screenshotsubfolderName;
	
	
	public TestBase()
	{
		
		try {
			prop=new Properties();
			FileInputStream ip;
			ip = new FileInputStream("C:/Users/USER/eclipse-workspace/NewAutomation/src/main/java/config/config.properties");
			prop.load(ip);
			System.out.println("testing");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void initilization()
	{
		String browserName=prop.getProperty("browser");
		System.out.println("testing2");
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver= new ChromeDriver();
			System.out.println("testing3");
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver= new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicitly_wait));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public String captureScreenshot(String testName) throws IOException
	{
		if (screenshotsubfolderName==null) {
		//screenshotsubfolderName= new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		LocalDateTime myDateObj = LocalDateTime.now();	   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	     screenshotsubfolderName = myDateObj.format(myFormatObj);
		}
		// driver object typecast into Takescreenshot interface, Getscreenshotas method to create image file
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest= new File("./ScreenShot/"+ screenshotsubfolderName+"/"+testName);

		//copy file to destination
		FileUtils.copyFile(screenshot, dest);

		return dest.getAbsolutePath();
		
	}
	
	
	
	
	
	
	

}
