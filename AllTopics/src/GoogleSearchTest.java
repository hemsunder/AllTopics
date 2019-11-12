import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("java");
		// xpath in normal way:
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div//div//"
				+ "div[@class='sbl1']//span[contains(text(),'java')]"));
		
		// xpath using descendant keyword:
		List<WebElement> list2 = driver.findElements(By.xpath("//ul[@role='listbox']//li//div/descendant::div//span"));
		
		int count = list.size();
		for(int i=0;i<count;i++){
			if(list.get(i).getText().contains("java interview questions")){
				list.get(i).click();
			}
		}
		
		
/* we use descendant keyword incase of same divs are existed as children and grand children etc
   whatever the div or something we write after descendant will be treat alll the grand children and children as one unit
   usage: just look at the below code once to get the better idea:
   
		 <ul class="erkvQe" jsname="erkvQe" role="listbox">
		 <li data-view-type="1" class="sbct" role="presentation" jsaction="click:.CLIENT;mouseover:.CLIENT">
		<div class="suggestions-inner-container">
		<div class="sbic sb43"></div>
		<div class="sbtc" role="option">
			<div class="sbl1">
				<span>java
					<b> interview questions pdf</b>
				</span>
			</div>
		</div>
		<div class="sbab" style="display: none;">
			<div class="sbai">Remove</div>
		</div>
	</div>
</li>
		*/
		
		
		
	}

}
