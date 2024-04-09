package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OFOSWelcomePage {

	//Declaration
	@FindBy(linkText = "Login")
	private WebElement loginTab;
	
	@FindBy(linkText = "Register")
	private WebElement registerTab;
	
	//Initialization
	public OFOSWelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLoginTab() {
		return loginTab;
	}

	public WebElement getRegisterTab() {
		return registerTab;
	}
	
	public void navigateToLoginPageAndValidate(WebDriver driver) {
		
		loginTab.click();
		
		WebElement loginFormHeaderText = driver.findElement(By.xpath("//h2[.='Login to your account']"));
		
		//Validation
		if(loginFormHeaderText.getText().equals("Login to your account")) {
			System.out.println("Login to your account Page is Displayed");
		}
		else {
			System.out.println("Defect : Login to your account not displayed");
		}
	}
	
	
}
