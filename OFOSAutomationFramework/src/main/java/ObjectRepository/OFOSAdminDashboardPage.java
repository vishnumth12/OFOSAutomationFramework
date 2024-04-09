package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtilitiesPackage.WebDriverUtility;

public class OFOSAdminDashboardPage extends WebDriverUtility{

	//Declaration
	@FindBy(xpath = "//img[@class='profile-pic']")
	private WebElement profilePicIcn;
	
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right animated zoomIn show']//a")
	private WebElement logoutLnkOptn;
	
	@FindBy(xpath = "//span[.='Users']")
	private WebElement userTab;
	
	@FindBy(xpath = "//span[.='Restaurant']")
	private WebElement restaurantTab;
	
	@FindBy(xpath = "//li/a[.='Add Category']")
	private WebElement addCategoryOpn;
	
	//Initialization
	public OFOSAdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getProfilePicIcn() {
		return profilePicIcn;
	}

	public WebElement getLogoutLnkOptn() {
		return logoutLnkOptn;
	}
	//Buiness Logic
	public void adminLogout(WebDriver driver) throws InterruptedException {
		profilePicIcn.click();

		logoutLnkOptn.click();
		Thread.sleep(3000);
		WebElement adminPanelText = driver.findElement(By.xpath("//h1[.='Admin Panel ']"));
		System.out.println("Admin logged out sucessfully and navigated to login : "+adminPanelText.getText());
	}
	
	public void adminNavToAllUsersPage(WebDriver driver) {
		userTab.click();
		WebElement allUsersTextHeader = driver.findElement(By.xpath("//span[.='Users']"));
		
		if(allUsersTextHeader.getText().equalsIgnoreCase("All Users")) {
			System.out.println("All Users page is displayed");
		}
			System.out.println("Failed to load All users page");
	}
	
	public void adminNavToAddRestaurantCategoryPage(WebDriver driver) {
		restaurantTab.click();
		addCategoryOpn.click();
		
		WebElement addRestaurantCategory = driver.findElement(By.xpath("//h4[.='Add Restaurant Category']"));
		if(addRestaurantCategory.getText().equalsIgnoreCase("Add Restaurant Category")) {
			System.out.println("Sucessfully navigated to Add Restaurant category page");
		}
		else {
			System.out.println("Failed to navigate to Add Restaurant category page");
		}
	}
	
}
