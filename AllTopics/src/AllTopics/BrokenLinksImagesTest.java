package AllTopics;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksImagesTest {

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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Home page title is ===> " + driver.getTitle());
		driver.switchTo().frame("mainpanel");
		
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("The totl number of links are "+linklist.size());
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for(int i=0;i<linklist.size();i++){
			System.out.println(linklist.get(i).getAttribute("href"));
			if(linklist.get(i).getAttribute("href")!=null && (!linklist.get(i).getAttribute("href").contains("javascript"))){
				activelinks.add(linklist.get(i));
			}
			
		}
		
		System.out.println("The number of active links are "+activelinks.size());
		
		for(int j=0;j<activelinks.size();j++){
			
			HttpURLConnection connection = (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+"---->>"+response);
		}

	}

}
