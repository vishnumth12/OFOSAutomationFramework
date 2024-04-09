package AdminModule;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericUtilitiesPackage.ExcelFileUtility;
import GenericUtilitiesPackage.FileUtility;
import GenericUtilitiesPackage.JavaUtility;
import GenericUtilitiesPackage.WebDriverUtility;
import ObjectRepository.AddRestaurantCategoryPage;
import ObjectRepository.OFOSAdminDashboardPage;
import ObjectRepository.OFOSAdminLoginPanelPage;

public class AddNewRestaurantCategoryTest {
	
	@Test
	public void addRestaurantCategory() throws IOException, InterruptedException {
		
	FileUtility fup = new FileUtility();
	ExcelFileUtility eup = new ExcelFileUtility();
	JavaUtility jup = new JavaUtility();
	WebDriverUtility wup = new WebDriverUtility();
	

	String BROWSER = fup.readDataFromPropertiesFile("browser");
	String URL = fup.readDataFromPropertiesFile("url2");
	String USERNAME = fup.readDataFromPropertiesFile("adminusername");
	String PASSWORD = fup.readDataFromPropertiesFile("adminpassword");
	
	WebDriver driver = wup.launchBrowserAndLoadURL(BROWSER, URL);
	wup.maximizeWindow(driver);
	
	wup.waitForPageToLoad(driver, 20);
	
	OFOSAdminLoginPanelPage alpp = new OFOSAdminLoginPanelPage(driver);
	alpp.adminLoginToApplication(driver, USERNAME, PASSWORD);
	
	OFOSAdminDashboardPage adp = new OFOSAdminDashboardPage(driver);
	adp.adminNavToAddRestaurantCategoryPage(driver);
	
	AddRestaurantCategoryPage rcp = new AddRestaurantCategoryPage(driver);
	
	rcp.addNewRestaurantCategory(driver, eup.readSingleDataFromExcelFile("ADMIN", 6, 1)+new Random().nextInt());
	
	wup.quitBrowser(driver);
}
}
