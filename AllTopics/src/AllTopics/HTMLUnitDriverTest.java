package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HTMLUnitDriverTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		
		driver=new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://qclocalpreprod.qfund.net/cc/demoIndex.do");
		System.out.println("Login page title is " + driver.getTitle());
		
		driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
		driver.findElement(By.name("loginRequestBean.password")).sendKeys("1234");
		driver.findElement(By.name("loginRequestBean.locNbr")).sendKeys("521");
		driver.findElement(By.name("login")).click();
		
		System.out.println("Home page title is " + driver.getTitle());
		driver.close();

	}

}
