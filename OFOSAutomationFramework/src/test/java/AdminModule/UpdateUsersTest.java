package AdminModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilitiesPackage.ExcelFileUtility;
import GenericUtilitiesPackage.FileUtility;
import GenericUtilitiesPackage.WebDriverUtility;
import ObjectRepository.OFOSAdminDashboardPage;
import ObjectRepository.OFOSAdminLoginPanelPage;
import ObjectRepository.OFOSAllUsersPage;
import ObjectRepository.OFOSWelcomePage;

public class UpdateUsersTest {
	
	WebDriverUtility wu = new WebDriverUtility();
	ExcelFileUtility eu = new ExcelFileUtility();
	FileUtility fiu = new FileUtility();
	
	@Test(dataProvider = "getData")
	public void adminUpdateUsersTC(String username, String firstname, String lastname, String email) throws IOException, InterruptedException {

	
	String BROWSER = fiu.readDataFromPropertiesFile("browser");
	String URL = fiu.readDataFromPropertiesFile("url2");
	String USERNAME = fiu.readDataFromPropertiesFile("adminusername");
	String PASSWORD = fiu.readDataFromPropertiesFile("adminpassword");
	
	WebDriver driver = wu.launchBrowserAndLoadURL(BROWSER, URL);
	
	wu.maximizeWindow(driver);
	
	OFOSAdminLoginPanelPage alpp = new OFOSAdminLoginPanelPage(driver);
	alpp.adminLoginToApplication(driver, USERNAME, PASSWORD);
	
	Thread.sleep(3000);
	
	OFOSAdminDashboardPage adp = new OFOSAdminDashboardPage(driver);
	adp.adminNavToAllUsersPage(driver);
	
	OFOSAllUsersPage aup = new OFOSAllUsersPage(driver);
	aup.editAUserDetail(driver, username, firstname, lastname, email);
	
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		
		return eu.readMultipleDataFromExcelSheet("ADMIN", 1, 1, 4);
		
	}
	
}
