package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OFOSUserRegistrationPage {

	@FindBy(name = "username")
	private WebElement usernameTextField;
	
	@FindBy(name = "firstname")
	private WebElement firstnameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastnameTextField;
	
	@FindBy(name = "email")
	private WebElement emailTextField;
	
	@FindBy(name = "phone")
	private WebElement phoneTextField;
	
	@FindBy(name = "password")
	private WebElement paswordTextField;
	
	@FindBy(name = "cpassword")
	private WebElement confirmPasswordTextField;
	
	@FindBy(name = "address")
	private WebElement addressTextArea;
	
	@FindBy(name = "submit")
	private WebElement registerButton;
	
	
	//initialization
	public OFOSUserRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}


	public WebElement getFirstnameTextField() {
		return firstnameTextField;
	}


	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}


	public WebElement getEmailTextField() {
		return emailTextField;
	}


	public WebElement getPhoneTextField() {
		return phoneTextField;
	}


	public WebElement getPaswordTextField() {
		return paswordTextField;
	}


	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}


	public WebElement getAddressTextArea() {
		return addressTextArea;
	}
	
	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	
	//Busines library
	public void registerNewUser(String username, String firstname, String lastname, String emailAddress, String phoneNumber, String password, String confirmPaassword, String address) {
		
		getUsernameTextField().sendKeys(username);
		getFirstnameTextField().sendKeys(firstname);
		getLastnameTextField().sendKeys(lastname);
		getEmailTextField().sendKeys(emailAddress);
		getPhoneTextField().sendKeys(phoneNumber);
		getPaswordTextField().sendKeys(password);
		getConfirmPasswordTextField().sendKeys(confirmPaassword);
		getAddressTextArea().sendKeys(address);
		registerButton.click();
		
		Reporter.log("User is Registered sucesfully", true);
		
	}
	
	
	
}
