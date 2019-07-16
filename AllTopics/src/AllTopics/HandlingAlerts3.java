package AllTopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingAlerts3 {
	
WebDriver driver;
	
	@Test
	public void HandleAlert() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32 latest version 2.36/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		Alert alt=driver.switchTo().alert();
		Thread.sleep(3000);
		String text=alt.getText();
		if (text.equals("Please enter a valid user name")){
			System.out.println("Correct alert message");
		}
		else {
			System.out.println("Alert message is wrong");
		}
		
		alt.accept();
		Thread.sleep(3000);
		driver.close();
	}


}
