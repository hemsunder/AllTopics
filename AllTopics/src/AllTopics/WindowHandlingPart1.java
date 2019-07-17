package AllTopics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandlingPart1 {
	
	WebDriver driver;
	
	@Test
	public void windowhandle(){
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//b//a[text()='Good PopUp #1']")).click();
		
		Set<String> set=driver.getWindowHandles();
		Iterator<String>it=set.iterator();
		
		String ParentWindowid=it.next();
		System.out.println("Parent window id is "+ParentWindowid);
		
		String ChildWindowid=it.next();
		System.out.println("child window id is "+ChildWindowid);
		
		driver.switchTo().window(ChildWindowid);
		String childwindowtitle=driver.getTitle();
		System.out.println("Child window title is "+childwindowtitle);
		driver.close();
		
		driver.switchTo().window(ParentWindowid);
		String parentwindowtitle=driver.getTitle();
		System.out.println("parent window title is "+parentwindowtitle);
		
		
		driver.close();
	}

}
