package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HighlightElements {
	WebDriver driver;
	
	@Test
	public void Highlight(){
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32 latest version 2.36/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://qclocalpreprod.qfund.net/cc/demoIndex.do");
		
		WebElement username=driver.findElement(By.name("loginRequestBean.userId"));
		highlightbyJS(driver, username);
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.name("loginRequestBean.password"));
		highlightbyJS(driver, password);
		password.sendKeys("1234");
		WebElement store=driver.findElement(By.name("loginRequestBean.locNbr"));
		highlightbyJS(driver, store);
		store.sendKeys("521");
		WebElement submit=driver.findElement(By.xpath("//input[@value='Submit']"));
		highlightbyJS(driver, submit);
		submit.click();
	}

	public static void highlightbyJS(WebDriver driver, WebElement element){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border: 2px solid red;');", element);
	}
}
