package UserModule;

import java.io.IOException;
import org.testng.annotations.Test;

import GenericUtilitiesPackage.BaseClass;
import ObjectRepository.OFOSHomePage;
import ObjectRepository.OFOSRestaurantMenuPage;
import ObjectRepository.OFOSRestaurantsPage;

public class AddItemToCartTest extends BaseClass{
	
	@Test
	public void addItemToCart() throws IOException, InterruptedException {

		OFOSHomePage hp = new OFOSHomePage(driver);
		hp.navToAllRestaurantsPage(driver);
	
		OFOSRestaurantsPage rp = new OFOSRestaurantsPage(driver);
		rp.navToRestaurantMenuPage();
		
		String quantity = eUtil.readSingleDataFromExcelFile("OrdersModule", 4, 2);
		
		OFOSRestaurantMenuPage rmp = new OFOSRestaurantMenuPage(driver);
		rmp.selectQuantityAndAddProductToCart(quantity);
	
		Thread.sleep(5000);
	}
}
		
