package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait {
	
	WebDriver driver;
	
	@Test
	public void explicitwait(){
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.proxysite.com/");
		WebElement element=driver.findElement(By.xpath("//button[text()='Go']"));
		element.click();
		
		driver.quit();
	}

	public static void Clickon(WebDriver driver, WebElement element, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	
}
