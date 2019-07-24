package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePickerByJS {
	WebDriver driver;
	
	@Test
	public void datepicker(){
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32 latest version 2.36/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		WebElement date=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_txt_Fromdate']"));
		String dateval="22-12-2019";
		datepick(driver, date, dateval);
	}
	
	public static void datepick(WebDriver driver, WebElement element, String dateval){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');", element);
	}

}
