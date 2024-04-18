package UserModule;

import org.testng.annotations.Test;

import GenericUtilitiesPackage.BaseClass;

public class OneTest extends BaseClass{

	
	@Test(groups = "smoke")
	public void testCase1() {
		System.err.println("---testCase1---");
	}
	

	@Test(groups = "regression")
	public void testCase2() {
		System.err.println("---testCase2---");
	}
	

	@Test
	public void testCase3() {
		System.err.println("---testCase3---");
	}
}
