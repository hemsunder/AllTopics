package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class LaunchingInternetExplorerBrowser2 {

WebDriver driver;
	
	@Test
	public void LaunchIE(){
		
		System.setProperty("webdriver.ie.driver", "D:/Automation Softwares/Selenium Drivers/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		String Title=driver.getTitle();
		System.out.println("Title of the page is "+Title);
		
		driver.close();
	}
}
