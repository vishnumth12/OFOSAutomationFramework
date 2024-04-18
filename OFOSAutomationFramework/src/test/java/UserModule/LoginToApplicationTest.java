package UserModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilitiesPackage.BaseClass;
import GenericUtilitiesPackage.ExcelFileUtility;
import GenericUtilitiesPackage.FileUtility;
import GenericUtilitiesPackage.JavaUtility;
import GenericUtilitiesPackage.WebDriverUtility;
import ObjectRepository.OFOSHomePage;
import ObjectRepository.OFOSLoginPage;
import ObjectRepository.OFOSWelcomePage;

@Listeners(GenericUtilitiesPackage.ListenerImplementationClass.class)
public class LoginToApplicationTest{
	WebDriver driver;
	@Test
	public void loginUsingValidCredentials() throws IOException, InterruptedException {
		
		
		FileUtility fup = new FileUtility();
		ExcelFileUtility eup = new ExcelFileUtility();
		JavaUtility jup = new JavaUtility();
		WebDriverUtility wup = new WebDriverUtility();
		
		String BROWSER = fup.readDataFromPropertiesFile("browser");
		String URL = fup.readDataFromPropertiesFile("url");
		String USERNAME = fup.readDataFromPropertiesFile("username");
		String PASSWORD = fup.readDataFromPropertiesFile("password");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		}

		wup.getUrl(driver, URL);
		wup.maximizeWindow(driver);
		wup.waitForPageToLoad(driver, 20);
		
		OFOSWelcomePage wp = new OFOSWelcomePage(driver);
		wp.navigateToLoginPageAndValidate(driver);
		
		OFOSLoginPage lp = new OFOSLoginPage(driver);
		lp.loginToApplication(driver, USERNAME, PASSWORD);
		
		OFOSHomePage hp = new OFOSHomePage(driver);
		hp.getLogoutTab().click();
		System.out.println("Logged out of application sucessfully : " +lp.getLoginPageHeadingText().getText());
		
		
		driver.close();
		
	}
}
