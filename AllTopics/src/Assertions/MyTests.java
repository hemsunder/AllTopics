package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyTests {
	
	SoftAssert softassert = new SoftAssert();
	
	@Test
	public void test1(){
		System.out.println("Browser has opened");
		//Assert.assertEquals(true, false);
		softassert.assertEquals(true, false);
		System.out.println("URL browsed");
		System.out.println("Login page title has verified");
		//Assert.assertEquals(true, false);
		softassert.assertEquals(true, false);
		System.out.println("Logged into application");
		System.out.println("Home page title is verified");	
		
		softassert.assertAll();
	}
	
	@Test
	public void test2(){
		System.out.println("Deal is created");
		//Assert.assertEquals(true, false);
		softassert.assertEquals(true, false);
		System.out.println("Contact is created");
		System.out.println("DS is created");
		
		softassert.assertAll();
	}

}
