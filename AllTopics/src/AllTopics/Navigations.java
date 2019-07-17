package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navigations {
	WebDriver driver;
	
	@Test
	public void navigate() throws Exception{
		
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.youtube.com/");
		driver.navigate().to("https://qclocalpreprod.qfund.net/cc/demoIndex.do");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().refresh();
		
		driver.quit();
		
		
	}

}
