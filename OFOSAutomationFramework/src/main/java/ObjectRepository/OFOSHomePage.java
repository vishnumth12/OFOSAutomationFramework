package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OFOSHomePage {

	
	//Declaration
	@FindBy(xpath = "//a[contains(text(),'Restaurants ')]")
	private WebElement restaurantsTab;
	
	@FindBy(name = "My Orders")
	private WebElement myOrdersTab;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutTab;
	
	
	//Initialization
	public OFOSHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getRestaurantsTab() {
		return restaurantsTab;
	}


	public WebElement getMyOrdersTab() {
		return myOrdersTab;
	}


	public WebElement getLogoutTab() {
		return logoutTab;
	}
	
	
	//Business Library
	public void logoutFromApplication(WebDriver driver) {
		
		logoutTab.click();
		
	}
	
	public void navToAllRestaurantsPage(WebDriver driver) {
		
		restaurantsTab.click();
		
		WebElement chooseRestaurantNav = driver.findElement(By.linkText("Choose Restaurant"));
		
		//Validation
		if(chooseRestaurantNav.getText().equals("Choose Restaurant")) {
			System.out.println("Choose restaurant page is displayed");
		}
		else {
			System.out.println("Defect : Choose restaurant page is not displayed");
		
	}
	
	}
	
	
}
