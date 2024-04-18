package UserModule;

import org.testng.annotations.Test;

import GenericUtilitiesPackage.BaseClass;

public class TwoTest extends BaseClass{

	
	@Test
	public void testScript1() {
		System.out.println("---testScript1---");
	}
	
	@Test(groups = "smoke")
	public void testScript2() {
		System.out.println("---testScript2---");
	}
	
	@Test
	public void testScript3() {
		System.out.println("---testScript3---");
	}
	
	@Test(groups = "smoke")
	public void testScript4() {
		System.out.println("---testScript4---");
	}
	
	@Test(groups = "regression")
	public void testScript5() {
		System.out.println("---testScript5---");
	}
}
