package Session_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _5_InteractByClassName {
	
	public static void main(String[] args) throws InterruptedException 
	{
		
			String landingPageTitle = "Zero - Personal Banking - Loans - Credit Cards";
			String appUsername = "username";
			String appPassword = "password";
			String afterLoginPageTitle = "zero.webappsecurity.com";

			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://zero.webappsecurity.com/");
			
			
			if( landingPageTitle.equals(driver.getTitle()))
			{
				System.out.println("Expected landing page title is matched");
			}
			else
			{
				System.out.println("Expected landing page title is matched");

			}
			
			WebElement signInBtn = driver.findElement(By.className("signin"));
			signInBtn.click();
			
			Thread.sleep(4000);
			
			WebElement userLoginTxtBox = driver.findElement(By.id("user_login"));
			userLoginTxtBox .sendKeys(appUsername);
			
			WebElement userpasswordTxtBox = driver.findElement(By.id("user_password"));
			userLoginTxtBox .sendKeys(appPassword);
			
			
			WebElement signInBtnOnLogin = driver.findElement(By.className("btn-primary"));
			signInBtnOnLogin .click();
			
			Thread.sleep(4000);
			
			if( afterLoginPageTitle.equals(driver.getTitle()))
			{
				System.out.println("Expected after login page title is matched");
			}
			else
			{
				System.out.println("Expected after login page title is not matched");

			}
			driver.quit();
	}

}
