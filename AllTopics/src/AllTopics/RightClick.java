package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClick {
	
	WebDriver driver;

	@Test
	public void right_click(){
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32 latest version 2.36/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("");
		WebElement element=driver.findElement(By.name(""));
		
		Actions act=new Actions(driver);
		act.contextClick(element).build().perform();
		
		//Sublist which displays after giving right click
		WebElement element2=driver.findElement(By.name(""));
		String text=element2.getText();
		System.out.println(text);
		element2.click();
		
		
		
	}

}
