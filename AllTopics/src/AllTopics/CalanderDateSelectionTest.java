package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


	public class CalanderDateSelectionTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
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
		WebElement login_btn=driver.findElement(By.xpath("//input[@value='Login']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", login_btn);
		System.out.println("Home page title is ===> " + driver.getTitle());
		
		String date = "22-December-2019";
		String dateArr[]=date.split("-");
		String day = dateArr[0];
		String month=dateArr[1];
		String year = dateArr[2];
		
		driver.switchTo().frame("mainpanel");
		Select monthh = new Select(driver.findElement(By.name("slctMonth")));
		monthh.selectByVisibleText(month);
		Thread.sleep(3000);
		Select yearr = new Select(driver.findElement(By.name("slctYear")));
		yearr.selectByVisibleText(year);
		Thread.sleep(3000);
		
		String xpath1 = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String xpath2 = "]/td[";
		String xpath3 = "]";
		
		final int totalweekdays = 7;
		boolean flag=false;
		String dateval;
		for(int rownum=2;rownum<=7;rownum++){
			for(int colnum=1;colnum<=totalweekdays;colnum++){
				
				try {
					dateval = driver.findElement(By.xpath(xpath1+rownum+xpath2+colnum+xpath3)).getText();
				} catch (NoSuchElementException e) {
					System.out.println("Please enter a valid date");
					flag=false;
					break;
				}
				//System.out.println(dateval);
				if(dateval.equals(day)){
					driver.findElement(By.xpath(xpath1+rownum+xpath2+colnum+xpath3)).click();
					flag=true;
					break;
				}
		}
			if(flag){
				break;
			}
		}
		

		
	}

}
