package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomeXpath {
	
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com/");
		
		//Customized xpath: ----- Recommended
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[contains(@id,'gh-ac')]")).sendKeys("Selenium");
		
		//dynamic id:
		//id=text_123
		//id=text_456
		//id=text_789
		driver.findElement(By.xpath("//input[contains(@id,'text')]")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[sta	rts-with(@id,'text_')]")).sendKeys("Selenium");
		
		//dynamic id:
		//id=123_text_admin
		//id=456_text_admin
		//id=789_text_admin
		driver.findElement(By.xpath("//input[ends-with(@id,'_text_admin')]")).sendKeys("Selenium");
		driver.findElement(By.xpath("//a[contains(text(),' Daily Deals')]")).click();
		
		
		
		//Absolute xpath:  --Not recommended
		driver.findElement(By.xpath("//html/body/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[1]/div[1]/div/input")).click();
		
		
		
		
		
		
		

	}

}
