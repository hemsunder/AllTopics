package DataDrivenTesting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;

	public class DataProviderTest {
		WebDriver driver;
		
		@BeforeMethod
		public void setup(){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://qclocalpreprod.qfund.net/cc/demoIndex.do");
		}
		
		
		@DataProvider
		public Iterator<Object[]> gettestdata(){
			ArrayList<Object[]> testdata=TestUtil.getdatafromExcel();
			return testdata.iterator();
			
		}
	
		
		@Test(dataProvider="gettestdata")
		public void QfundloginTest(String username, String password, String storeid){
			System.out.println("Title of the page before login ===>> " + driver.getTitle());
			driver.findElement(By.name("loginRequestBean.userId")).sendKeys(username);
			driver.findElement(By.name("loginRequestBean.password")).sendKeys(password);
			driver.findElement(By.name("loginRequestBean.locNbr")).sendKeys(storeid);
			driver.findElement(By.name("login")).click();
			System.out.println("Title of the page after login ===>> " + driver.getTitle());
			
		}
		
		@AfterMethod
		public void teardown(){
			driver.quit();
			
		}
	
	}
