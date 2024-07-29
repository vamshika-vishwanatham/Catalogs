package utilities;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseSource.BaseClass;
 
public class ExtentReportManager implements ITestListener { 
	public ExtentSparkReporter sparkReporter; 
	public ExtentReports extent; 
	public ExtentTest test;
 
	String repName;
	String timeStamp;
	@BeforeTest
	public void onStart(ITestContext testContext)
	{ 
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// Time stamp 
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\Reports\\" + repName);// Specify Location of the report
		sparkReporter.config().setDocumentTitle("NewHireOnboarding Automation Report"); // Title of report 
		sparkReporter.config().setReportName("NewHireOnboarding Smoke Testing"); // Name of the report 
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "JIRA-IT"); 
		extent.setSystemInfo("Module", "ONBOARDING"); 
		extent.setSystemInfo("Sub Module", "NEW HIRE"); 
		extent.setSystemInfo("Operating System", System.getProperty("os.name")); 
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA"); 
	}
 
	public void onTestSuccess(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result) { 
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		try 
		{
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
 
	public void onFinish(ITestContext testContext) {
		extent.flush();                           //Physical appearance of the report.
	}
 
}