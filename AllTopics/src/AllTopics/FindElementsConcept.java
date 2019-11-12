package AllTopics;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com/");
		List<WebElement> list = driver.findElements(By.tagName("a"));
//		List<WebElement> list2 = driver.findElements(By.xpath("//a"));
		int count = list.size();
		System.out.println("The number of links are "+count);
		
		// One way to click on particular element:
		for(int i=0;i<count;i++){
			String linkName = list.get(i).getText();
			System.out.println(linkName);
			if(linkName.equals("register")){
				driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
			}
		}
		
		// Another way to click on particular element:
		for(int i=0;i<count;i++){
			if(list.get(i).getText().contains("register")){
				list.get(i).click();
			}
		}
		
		
		// To click on nth link directly without iterating all the links:
		list.get(50).click();
		
		
	
	}

}
