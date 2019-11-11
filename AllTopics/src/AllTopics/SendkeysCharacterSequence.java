package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SendkeysCharacterSequence {

	
WebDriver driver;
	
	@Test
	public void LaunchChrome(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://qclocalpreprod.qfund.net/cc/demoIndex.do");
		String Title=driver.getTitle();
		System.out.println("Title of the page is "+Title);
		
		WebElement username_tb = driver.findElement(By.name("loginRequestBean.userId"));
		//1. String
		username_tb.sendKeys("admin");
		
		//2. StringBuilder
		StringBuilder usernamedata = new StringBuilder()
				.append("admin")
				.append(" ")
				.append("and")
				.append(" ")
				.append("password");
		username_tb.sendKeys(usernamedata);
		
		//3. StringBuffer
		StringBuffer usernamedata2 = new StringBuffer()
				.append("password")
				.append(" ")
				.append("and")
				.append(" ")
				.append("username");
		username_tb.sendKeys(usernamedata2);
		//4. Combination
		String space = " ";
		username_tb.sendKeys(usernamedata, space, usernamedata2, Keys.TAB);
		
		// All ways of sendkeys is done
		
	}
}
