package FailedTestScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TakeScreenshot {

	public static WebDriver driver;

	@Test
	public void takescreenshot() {

		System.setProperty("webdriver.chrome.driver",
				"D:/Automation Softwares/Selenium Drivers/" + "chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
		driver.findElement(By.name("Youtube")).click();
		
	}

	public static void failed(String testmethodname) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("C:/Users/Admin/git/AllTopics/AllTopics/Screenshots/"
						+testmethodname+"_"+ ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}

}
