package ParameterFromtestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterPassing {
	
	
	@Test
	@Parameters({"url", "username", "password", "storeid"})
	public void parameterpass(String url, String username, String password, String storeid){
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get(url);
		System.out.println("Login page title is ===> " + driver.getTitle());
		
		driver.findElement(By.name("loginRequestBean.userId")).sendKeys(username);
		driver.findElement(By.name("loginRequestBean.password")).sendKeys(password);
		driver.findElement(By.name("loginRequestBean.locNbr")).sendKeys(storeid);
		driver.findElement(By.name("login")).click();
		
		System.out.println("Home page title is ===> " + driver.getTitle());
		
		
		
		
		
	}

}
