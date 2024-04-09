package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OFOSLoginPage {

	//Declaration
	@FindBy(name = "username")
	private WebElement usernameTextField;
	
	@FindBy(name = "password")
	private WebElement passwordTextField;
	
	@FindBy(name = "submit")
	private WebElement loginButton;
	
	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement loginPageHeadingText;
	
	
	//Initialization
	public OFOSLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	//utilization
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getLoginPageHeadingText() {
		return loginPageHeadingText;
	}

	
	//Business library
	public void loginToApplication(WebDriver driver, String username, String password) throws InterruptedException {
		getUsernameTextField().sendKeys(username);
		getPasswordTextField().sendKeys(password);
		getLoginButton().click();
		
		Thread.sleep(3000);
		
		WebElement myOrdersTab = driver.findElement(By.linkText("My Orders"));
		
		//Validation
		if(myOrdersTab.getText().equals("My Orders")) {
			System.out.println("User home page is displayed");
		}
		else {
			System.out.println("Defect : User home page is not displayed");
		}
		
		
	}
	
	
}
