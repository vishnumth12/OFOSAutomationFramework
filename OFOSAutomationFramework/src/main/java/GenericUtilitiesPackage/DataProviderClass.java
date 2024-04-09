package GenericUtilitiesPackage;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider
	public Object[][] adminLoginDataOFOS() {
		Object [][] data = new Object[2][2];
		
		data[0][0] = "admin";  data[0][1] = "codeastro";
		data[1][0] = "admin";  data[1][1] = "codeastro1";
		
		return data;
	}
}
