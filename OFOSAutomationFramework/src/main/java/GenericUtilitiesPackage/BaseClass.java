package GenericUtilitiesPackage;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.OFOSHomePage;
import ObjectRepository.OFOSLoginPage;
import ObjectRepository.OFOSWelcomePage;

public class BaseClass {

	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public DatabaseUtility dUtil = new DatabaseUtility();
	public WebDriver driver;
	
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void connectDB() throws SQLException {
		dUtil.connectDB();
		
		Reporter.log("------DB connected-----", true);
	}
	
//	@BeforeClass(alwaysRun = true)
//	public void launchBrowser() throws IOException {
//		String BROWSER = fUtil.readDataFromPropertiesFile("browser");
//		String URL = fUtil.readDataFromPropertiesFile("url");
//		driver = wUtil.launchBrowserAndLoadURL(BROWSER, URL);
//		wUtil.waitForPageToLoad(driver, 20);
//		wUtil.maximizeWindow(driver);
//		
//		Reporter.log("------Launched the Browser-----", true);
//	}
	
	//@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void loginToApplication(/* String BROWSER */) throws IOException, InterruptedException {
		
		//String BROWSER = System.getProperty("browser");
		String BROWSER = fUtil.readDataFromPropertiesFile("browser");
		String URL = fUtil.readDataFromPropertiesFile("url");
		driver = wUtil.launchBrowserAndLoadURL(BROWSER, URL);
		sDriver = driver;
		wUtil.waitForPageToLoad(driver, 20);
		wUtil.maximizeWindow(driver);
		
		Reporter.log("------Launched the Browser-----", true);
		
		String USERNAME = fUtil.readDataFromPropertiesFile("username");
		String PASWORD = fUtil.readDataFromPropertiesFile("password");
		
		OFOSWelcomePage wp = new OFOSWelcomePage(driver);
		wp.navigateToLoginPageAndValidate(driver);
		
		OFOSLoginPage lp = new OFOSLoginPage(driver);
		lp.loginToApplication(driver, USERNAME, PASWORD);
		
		Reporter.log("------Logged in to Application-----", true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutOfApplication() {
	
		OFOSHomePage hp = new OFOSHomePage(driver);
		hp.logoutFromApplication(driver);
		
		Reporter.log("------Logged out of the Application-----", true);
		
		wUtil.quitBrowser(driver);
		
		Reporter.log("------Browser Closed-----", true);
	}
	
//	@AfterClass(alwaysRun = true)
//	public void closeBrowser() throws InterruptedException {
//		wUtil.quitBrowser(driver);
//		
//		Reporter.log("------Browser Closed-----", true);
//	}
	
	@AfterSuite(alwaysRun = true)
	public void disconnectDB() throws SQLException {
		dUtil.closeDB();
		
		Reporter.log("------Closed DB conection-----", true);
	}
}
