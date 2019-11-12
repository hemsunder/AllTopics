package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorsPreference {
	
	WebDriver driver;
	
	@Test
	public void locatorsuse() throws Exception{
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/");
		
		//1. id
		//driver.findElement(By.id("login-username")).sendKeys("hemsunder");
		
		//2. name
		//driver.findElement(By.name("username")).sendKeys("hemsunder");
		
		//3. xpath
		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hemsunder");
		
		//4. classname
		driver.findElement(By.className("phone-no")).sendKeys("hemsunder");
		
		//5. cssselector
		//driver.findElement(By.cssSelector("#login-username")).sendKeys("hemsunder");
		
		//6. linktext
		//driver.findElement(By.linkText("Difficulty signing in?")).click();
		
		//7. partial linktext
		//driver.findElement(By.partialLinkText("Difficulty")).click();
		

}
}
