package UserModule;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilitiesPackage.BaseClass;
import ObjectRepository.OFOSCheckOutPage;
import ObjectRepository.OFOSRestaurantMenuPage;
import ObjectRepository.OFOSRestaurantsPage;

@Listeners(GenericUtilitiesPackage.ListenerImplementationClass.class)
public class CancelOrderTest extends BaseClass{
	
	@Test /*
			 * (retryAnalyzer =
			 * GenericUtilitiesPackage.IRetryAnalyserImplementationClass.class)
			 */
	public void orderAnItemAndCheckoutUsingCashOnDelivery() throws InterruptedException, IOException {
		
		OFOSRestaurantsPage rp = new OFOSRestaurantsPage(driver);
		rp.getRestaurantNameTextLink().click();
		
		String quantity = eUtil.readSingleDataFromExcelFile("OrdersModule", 4, 2);
		
		OFOSRestaurantMenuPage rmp = new OFOSRestaurantMenuPage(driver);
		rmp.selectQuantityAndAddProductToCart(quantity);

		rmp.checkOutItemAndValidate();
		
		OFOSCheckOutPage cop = new OFOSCheckOutPage(driver);
		cop.getOrderNowButton().click();
		
		wUtil.acceptAlertPopup(driver);
		
		wUtil.acceptAlertPopup(driver);
		
		cop.cancelItemAndValidate(driver);
		
	}
}
