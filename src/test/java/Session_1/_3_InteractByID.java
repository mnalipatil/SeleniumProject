package Session_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_InteractByID {
	
	public static void main(String[] args) throws InterruptedException {
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://demo.automationtesting.in/Index.html");
		
		System.out.println("Leading page title is -> " + driver.getTitle());
		
		//Thread.sleep(3000);
//		
		WebElement userNameField = driver.findElement(By.id("email"));
		userNameField .sendKeys("test@something.com");
	//	driver.findElement(By.id("email")).sendKeys("test@something.com");
		
		WebElement proceedButton = driver.findElement(By.id("enterimg"));
		proceedButton.click();
		
		String exceptedNextPageTitle = "Register";
		 if (exceptedNextPageTitle.equals(driver.getTitle()))
		 {
			 System.out.println("User is navigated to the next page for resistration");
		 }
		 else
		 {
			 System.out.println("User is not navigated to the next page for resistration");

		 }
		//Thread.sleep(3000);
		 
		 
		driver.quit();
	}

}
