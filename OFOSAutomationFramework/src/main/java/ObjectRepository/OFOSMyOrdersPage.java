package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OFOSMyOrdersPage {

	//declaration
	@FindBy(xpath = "(//td[text()=' Pink Spaghetti Gamberonichicken pasta319']/../td[@data-column='Action'])[1]")
	private WebElement cancelButton;
	
	//initialization
	public OFOSMyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCancelButton() {
		return cancelButton;
	}

	
}
