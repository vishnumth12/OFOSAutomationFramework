package AdminModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilitiesPackage.DataProviderClass;
import GenericUtilitiesPackage.ExcelFileUtility;
import GenericUtilitiesPackage.FileUtility;
import GenericUtilitiesPackage.JavaUtility;
import GenericUtilitiesPackage.WebDriverUtility;
import ObjectRepository.OFOSAdminDashboardPage;
import ObjectRepository.OFOSAdminLoginPanelPage;

public class AdminAccontLoginTest {

	WebDriver driver;
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "adminLoginDataOFOS")
	public void adminLoginTC(String username, String password) throws IOException, InterruptedException {
		
		FileUtility fup = new FileUtility();
		ExcelFileUtility eup = new ExcelFileUtility();
		JavaUtility jup = new JavaUtility();
		WebDriverUtility wup = new WebDriverUtility();
		
	
		String BROWSER = fup.readDataFromPropertiesFile("browser");
		String URL = fup.readDataFromPropertiesFile("url2");
//		String USERNAME = fup.readDataFromPropertiesFile("adminusername");
//		String PASSWORD = fup.readDataFromPropertiesFile("adminpassword");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
	
		driver = new ChromeDriver();
		}
		
		wup.getUrl(driver, URL);
		wup.maximizeWindow(driver);
		
		OFOSAdminLoginPanelPage alpp = new OFOSAdminLoginPanelPage(driver);
		alpp.adminLoginToApplication(driver, username, password);
		
		Thread.sleep(3000);
		
		OFOSAdminDashboardPage adp = new OFOSAdminDashboardPage(driver);
		adp.adminLogout(driver);
		
		wup.quitBrowser(driver);
	}
}
