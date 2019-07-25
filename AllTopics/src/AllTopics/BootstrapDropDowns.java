package AllTopics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BootstrapDropDowns {
	
	@Test
	public void Bootstraphandling(){
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation Softwares/Selenium Drivers/"
				+ "chromedriver_win32 latest version 2.36/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/#single-button-dropdowns");
		
		driver.findElement(By.xpath("//div//div//button[@id='dropdownMenuButton']")).click();
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='dropdown-menu' and "
				+ "@aria-labelledby='dropdownMenuButton']//a"));
		
		int count=list.size();
		for (int i=0;i<count;i++){
			
			String title=list.get(i).getText();
			if(title.contains("Action")){
				list.get(i).click();
				break;
			}
		}
		driver.close();
	}

}
