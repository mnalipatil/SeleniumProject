package Session_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_NevigationCommands {
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in/");
		System.out.println("Page title of google after just launching browser is -> " + driver.getTitle());
			
		Thread.sleep(2000);	

		driver.navigate().to("https://www.facebook.com/");	
		System.out.println("Page title of facebook after movingout from google page is -> " + driver.getTitle());
		
		Thread.sleep(2000);	


		driver.navigate().back();
		System.out.println("Page title of google after coming back from facebook page is -> " + driver.getTitle());

		driver.navigate().forward();
		System.out.println("Page title of google after moving out second time from facebook page is -> " + driver.getTitle());

		Thread.sleep(2000);	
		
		
		
		driver.quit();
	}

}
