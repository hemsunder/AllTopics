package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IrritatingModelPopUp {

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
		
		driver.findElement(By.name("username")).sendKeys("hemsunder");
		driver.findElement(By.name("password")).sendKeys("hem@123");
		//Thread.sleep(5000);
		
		//Pop-up is in frame so first we have to switch to frame
		driver.switchTo().frame("CcPC2NR-1573701784898");
		Actions act = new Actions(driver);
		// To mousehover on chat pop-up so that we cross mark will be displayed
		act.moveToElement(driver.findElement(By.id("bubble-image"))).build().perform();
		// To click on cross mark so that irritating chat pop-up will be closed
		driver.findElement(By.id("tawkchat-chat-bubble-close")).click();
		
		
		// Finally to click on login button -- Yes. It worked.
		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

}
