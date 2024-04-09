package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilitiesPackage.WebDriverUtility;

public class OFOSAdminLoginPanelPage extends WebDriverUtility{

	//declaration
	@FindBy(name = "username")
	private WebElement usernameTextField;
	
	@FindBy(name = "password")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//h4[.='Admin Dashboard']")
	private WebElement adminDashboardText;
	
	
	//initialization
	public OFOSAdminLoginPanelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	//utilization
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getAdminDashboardTxt() {
		return adminDashboardText;
	}
	
	//Business Logic
	public void adminLoginToApplication(WebDriver driver, String username, String password) throws InterruptedException {
		waitForPageToLoad(driver, 20);
		getUsernameTextField().sendKeys(username);
		getPasswordTextField().sendKeys(password, Keys.ENTER);
		Thread.sleep(3000);
		WebElement adminDashBoard = driver.findElement(By.xpath("//h4[contains(.,'Admin Dashboard')]"));
		
		if(adminDashBoard.getText().contains("Admin Dashboard")){
			System.out.println("Admin logged in sucessfully");
		}
		else {
			System.out.println("Admin logged out sucessfully");
		}

	}
}
