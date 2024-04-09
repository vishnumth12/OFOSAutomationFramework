package UserModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilitiesPackage.BaseClass;
import GenericUtilitiesPackage.ExcelFileUtility;
import GenericUtilitiesPackage.FileUtility;
import GenericUtilitiesPackage.JavaUtility;
import GenericUtilitiesPackage.WebDriverUtility;
import ObjectRepository.OFOSHomePage;
import ObjectRepository.OFOSLoginPage;
import ObjectRepository.OFOSWelcomePage;

public class LoginToApplicationTest extends BaseClass{
	
	WebDriver driver;
	
	@Test
	public void loginUsingValidCredentials() throws IOException, InterruptedException {
		
		
		FileUtility fup = new FileUtility();
		ExcelFileUtility eup = new ExcelFileUtility();
		JavaUtility jup = new JavaUtility();
		WebDriverUtility wup = new WebDriverUtility();
		
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonDataOFOS.properties");
//		Properties p = new Properties();
//		p.load(fis);
		
//		String BROWSER = p.getProperty("browser");
//		String URL = p.getProperty("url");
//		String USERNAME = p.getProperty("username");
//		String PASSWORD = p.getProperty("password");
		
		String BROWSER = fup.readDataFromPropertiesFile("browser");
		String URL = fup.readDataFromPropertiesFile("url");
		String USERNAME = fup.readDataFromPropertiesFile("username");
		String PASSWORD = fup.readDataFromPropertiesFile("password");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		}
	
//		driver.get(URL);
		wup.getUrl(driver, URL);
		wup.maximizeWindow(driver);
		wup.waitForPageToLoad(driver, 20);
		
//		WebElement loginTab = driver.findElement(By.linkText("Login"));
//		loginTab.click();
		
//		WebElement loginFormHeaderText = driver.findElement(By.xpath("//h2[.='Login to your account']"));
//		
//		//Validation
//		if(loginFormHeaderText.getText().equals("Login to your account")) {
//			System.out.println("Login to your account Page is Displayed");
//		}
//		else {
//			System.out.println("Defect : Login to your account not displayed");
//		}
		
		OFOSWelcomePage wp = new OFOSWelcomePage(driver);
		wp.navigateToLoginPageAndValidate(driver);
			
//		WebElement usernameTextfield = driver.findElement(By.name("username"));
//		usernameTextfield.sendKeys(USERNAME);
//		
//		WebElement passwordTextfield = driver.findElement(By.name("password"));
//		passwordTextfield.sendKeys(PASSWORD);
//		
//		WebElement loginButton = driver.findElement(By.id("buttn"));
//		loginButton.click();
		
		OFOSLoginPage lp = new OFOSLoginPage(driver);
		lp.loginToApplication(driver, USERNAME, PASSWORD);
		
		
//		Thread.sleep(3000);
//		
//		WebElement myOrdersTab = driver.findElement(By.linkText("My Orders"));
//		
//		//Validation
//		if(myOrdersTab.getText().equals("My Orders")) {
//			System.out.println("User home page is displayed");
//		}
//		else {
//			System.out.println("Defect : User home page is not displayed");
//		}
		
//		WebElement logoutTab = driver.findElement(By.xpath("//a[text()='Logout']"));
//		logoutTab.click();
		
		OFOSHomePage hp = new OFOSHomePage(driver);
		hp.getLogoutTab().click();
		System.out.println("Logged out of application sucessfully : " +lp.getLoginPageHeadingText().getText());
		
		
		driver.close();
		
	}
}
