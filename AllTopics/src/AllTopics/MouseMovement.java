package AllTopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseMovement {
	WebDriver driver;
	
	@Test
	public void mousehovering() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32 latest version 2.36/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		WebElement element=driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='SME Traveller']")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	}

}
