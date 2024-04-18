package GenericUtilitiesPackage;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".//ExtentReports//Report "+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("OFOSReport");
		htmlReport.config().setReportName("SDET-S3");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Platform", "Windows");
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		report.setSystemInfo("Reporter-Name", "Vishnu");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log("execution starts from here", true);	
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"-----Sucess");
		Reporter.log(methodName+"----------------Executed Sucessfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		try {
			String screenshot = new WebDriverUtility().getScreenshot(BaseClass.sDriver, methodName + new JavaUtility().getSystemDateInFormat());
			test.log(Status.FAIL, methodName+" ----------Failed");
			test.log(Status.FAIL, result.getThrowable());
			
			test.addScreenCaptureFromPath(screenshot);
			
			Reporter.log(methodName+"-----------------Execution failed");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" ----------Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
	
}
