package AllTopics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumNewFeatureScreenshotPart1 {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		System.out.println("Login page title is ===> " + driver.getTitle());
		
		WebElement username = driver.findElement(By.name("username"));//.sendKeys("hemsunder");
		WebElement password = driver.findElement(By.name("password"));//.sendKeys("hem@123");
		
		/*File srcfile=username.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("./Screenshots/email.png"));*/
		
		/*elementtakescreenshot(username, "usernametextbox");*/
		
		username.sendKeys("hemsunder");
		elementtakescreenshot(username, "usernametextbox");
		

	}
	
	
	
	public static void elementtakescreenshot(WebElement element, String filename) throws IOException{
		File srcfile=element.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcfile, new File("./Screenshots/"+filename+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
