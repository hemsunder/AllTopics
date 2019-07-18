package RetryLogic;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(RetryLogic.MyTransformer.class)
public class Tests {
	
	@Test(retryAnalyzer=RetryLogic.RetryAnalyzer.class)
	public void test1(){
		Assert.assertEquals(true, false);
	}
	
	@Test(retryAnalyzer=RetryLogic.RetryAnalyzer.class)
	public void test2(){
		Assert.assertEquals(true, false);
	}

}
