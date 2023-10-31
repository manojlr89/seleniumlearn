package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testcases.TestBase;


public class ExtentReportListener extends TestBase  implements ITestListener {

	ExtentSparkReporter HTMLReporter;
	ExtentReports reports;
	ExtentTest test;
	String timestamp;

	public void configureReport() {

		
			//screenshotsubfolderName= new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			LocalDateTime myDateObj = LocalDateTime.now();	   
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		    timestamp = myDateObj.format(myFormatObj);
			
		//String timestamp= new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String reportname= "Report"+ timestamp+ ".html";
		HTMLReporter = new ExtentSparkReporter("./Reports/"+timestamp+"/"+ reportname);

		reports = new ExtentReports();

		reports.attachReporter(HTMLReporter);

		// configuration of looks in reports

		HTMLReporter.config().setDocumentTitle("Automation Report");
		HTMLReporter.config().setTheme(Theme.DARK);

	}
	
	public void onStart(ITestContext context)
	{
		configureReport();
	}
	

	public void onTestStart(ITestResult result)
	{
		
	}
	

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Name of test method Passed : " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Name of test method Fail : " + result.getName());
		test = reports.createTest(result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		try {
			String screenshots=null;
			screenshots=captureScreenshot(result.getName()+ ".jpg");
			test.addScreenCaptureFromPath(screenshots);
			test.fail(result.getThrowable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String screenshots= System.getProperty("user.dir")+"\\ScreenShot\\"+result.getName()+ ".png";
//		
//		File screenshotfile= new File(screenshots);
//		
//		if (screenshotfile.exists())
//		{
//			test.fail("Captured screenshot is below :"+ test.addScreenCaptureFromPath(screenshots));
//			
//		}
		
		
		
		
		
		
		
	}

	
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Name of test method Skipped : " + result.getName());
		test = reports.createTest(result.getName());//create entry in html report
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
	}
	

	
	

	public void onFinish(ITestContext context)
	{
		reports.flush();
	}
	

	public void onTestFailedWithTimeout(ITestResult result)
	{
		onTestFailure(result);
	}
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// not implemented
	}

}
