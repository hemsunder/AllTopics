package AllTopics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandling {

	public static void main(String[] args) {

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
		WebElement login_btn=driver.findElement(By.xpath("//input[@value='Login']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", login_btn);
		System.out.println("Home page title is ===> " + driver.getTitle());
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//*[@id="vContactsForm"]/table/tbody/tr[4]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[1]/input
		
		//Method1: By using for loop:
		String beforexpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String afterxpath = "]/td[2]/a";
		
		for(int i=4;i<=6;i++){
			String name = driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			if(name.equals("Marks Twain")){
				driver.findElement(By.xpath("//input[@value='52572713']")).click();
			}
		}
		
		//Method2: By using customize xpath:
		driver.findElement(By.xpath("//a[contains(text(),'Marks Twain')]//parent::td//preceding-sibling::td//input")).click();
		
		

	}

}
