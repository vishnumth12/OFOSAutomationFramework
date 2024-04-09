package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRestaurantCategoryPage {

	@FindBy(name = "c_name")
	private WebElement categoryTf;
	
	@FindBy(name = "submit")
	private WebElement saveBtn;
	
	//Initialization
	public AddRestaurantCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	public void addNewRestaurantCategory(WebDriver driver, String newcategory) throws InterruptedException {
		categoryTf.sendKeys(newcategory);
		saveBtn.click();
		Thread.sleep(5000);
		WebElement sucessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']"));
		String msg = sucessMsg.getText();
		System.out.println(msg);
		
		if(sucessMsg.getText().contains("New Category Added Successfully.")) {
			System.out.println("New category was Added sucessfully");
		}else {
			System.out.println("Failed to Add new Restaurant category");}
	}
	
}
