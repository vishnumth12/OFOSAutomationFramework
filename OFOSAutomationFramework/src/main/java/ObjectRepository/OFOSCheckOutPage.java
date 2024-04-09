package ObjectRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilitiesPackage.WebDriverUtility;

public class OFOSCheckOutPage extends WebDriverUtility{
	
	@FindBy(name = "submit")
	private WebElement orderNowButton;
	
	@FindBy(xpath = "(//i[@class='fa fa-trash-o'])[1]")
	private WebElement cancelButton;
	
	//initialization
	public OFOSCheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrderNowButton() {
		return orderNowButton;
	}
	
	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	//Business Library
	public void cancelItemAndValidate(WebDriver driver) throws InterruptedException {
		cancelButton.click();
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		System.out.println("Order has been cancelled");
	}
}
