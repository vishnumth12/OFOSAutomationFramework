package UserModule;

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericUtilitiesPackage.BaseClass;
import ObjectRepository.OFOSHomePage;
import ObjectRepository.OFOSLoginPage;
import ObjectRepository.OFOSUserRegistrationPage;
import ObjectRepository.OFOSWelcomePage;

public class UserRegistrationTest extends BaseClass{
	
	@Test
	public void newUserRegistrationWithValidCredentials() throws IOException, InterruptedException {

		OFOSWelcomePage hp = new OFOSWelcomePage(driver);
		hp.getRegisterTab().click();
		
		OFOSUserRegistrationPage urp = new OFOSUserRegistrationPage(driver);
		
		HashMap<String, String> data = eUtil.readMultipleDataFromExcelFile("OrdersModule", 7, 0, 11);
		urp.registerNewUser(data.get("User_Name") + jUtil.getRandomNumber(), data.get("First_Name") + 
				jUtil.getRandomNumber(), data.get("Last_Name"), data.get("Email_Address") + 
				jUtil.getRandomNumber()+".gmail.com", data.get("Phone_Number"), data.get("Password"), 
				data.get("Confirm_Password"), data.get("Delivery_Address"));
	
	}
}
