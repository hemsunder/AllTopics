package AllTopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingFrames {
	
	WebDriver driver;
	
	@Test
	public void HandleFrame(){
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32 latest version 2.36/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://qclocalpreprod.qfund.net/cc/demoIndex.do");
		
		driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
		driver.findElement(By.name("loginRequestBean.password")).sendKeys("1234");
		driver.findElement(By.name("loginRequestBean.locNbr")).sendKeys("521");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		driver.switchTo().frame("topFrame");
		driver.findElement(By.linkText("Borrower")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.linkText("Registration")).click();
		
		driver.close();
		
	}

}
