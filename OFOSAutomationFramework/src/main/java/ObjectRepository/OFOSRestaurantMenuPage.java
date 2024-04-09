package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OFOSRestaurantMenuPage {

	@FindBy(linkText  = "Pink Spaghetti Gamberonichicken pasta319")
	private WebElement dishNameLink;
	
	@FindBy(name = "quantity")
	private WebElement quantityTextBox;
	
	@FindBy(xpath = "//a[.='Pink Spaghetti Gamberonichicken pasta319']/ancestor::div[@class='row']//div//input[@value='Add To Cart']")
	private WebElement addToCartButton;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutButton;
	
	@FindBy(xpath = "//i[@class='fa fa-trash pull-right']")
	private WebElement deleteItemButton;
	
	@FindBy(xpath = "//h3[@class='value']")
	private WebElement totalText;
	
	
	//initialization
	public OFOSRestaurantMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	public WebElement getDishNameLink() {
		return dishNameLink;
	}


	public WebElement getQuantityTextBox() {
		return quantityTextBox;
	}


	public WebElement getAddToCartButton() {
		return addToCartButton;
	}


	public WebElement getCheckoutButton() {
		return checkoutButton;
	}


	public WebElement getDeleteItemButton() {
		return deleteItemButton;
	}
	
	
	
	//Busines library
	public void selectQuantityAndAddProductToCart(String quantity) {
		
		if(checkoutButton.getText().contains("Checkout")) {
			System.out.println("Restaurant menu page is displayed");
		}
		else {
			System.out.println("Defect : Restaurant menu page is not displayed");
		}
		getDishNameLink().click();
		getQuantityTextBox().clear();
		getQuantityTextBox().sendKeys(quantity);
		getAddToCartButton().click();
		
		if(totalText.getText().equals("$0")) {
			System.out.println("Item is not added to cart");
		}
			System.out.println("Item is added to cart and price is : "+totalText.getText());
	}
	
	public void checkOutItemAndValidate() {
		
		checkoutButton.click();
		
		System.out.println("Check out page is displayed");
	}
	
	public void deleteItemAndValidate() {
		
		deleteItemButton.click();
		
		if(totalText.getText().equals("$0")) {
			System.out.println("Item is removed from cart");
		}else {
			System.out.println("Item is not deleted");
	}
	}
}


