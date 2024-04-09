package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OFOSAllUsersPage {

	@FindBy(xpath = "//td[.='Neena123']/../descendant::i[@class='fa fa-edit']")
	private WebElement editUserIcn;
	
	@FindBy(name = "uname")
	private WebElement unameTf;
	
	@FindBy(name = "fname")
	private WebElement firstNameTf;
	
	@FindBy(name = "lname")
	private WebElement lastNameTf;
	
	@FindBy(name = "email")
	private WebElement emailTf;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public OFOSAllUsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business Libraries
	public void editAUserDetail(WebDriver driver, String username, 
			String firstname, String lastname, String email) {
		driver.findElement(By.xpath("//td[.='Neena123']/../descendant::i[@class='fa fa-edit']")).click();
		WebElement updateUsersText = driver.findElement(By.xpath("//h4[.='Update Users']"));
		
		if(updateUsersText.getText().contentEquals("Update Users")) {
			System.out.println("Update users page is displayed");
		}
		else {
			System.out.println("Failed to load update users page");
		}
		
		unameTf.sendKeys(username);
		firstNameTf.sendKeys(firstname);
		lastNameTf.sendKeys(lastname);
		emailTf.sendKeys(email);
		
		submitBtn.click();
		
		
	}
}
