package Session_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_InteractByLinkText {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://dzone.com/articles/find-elements-with-link-text-amp-partial-link-text");
		
		WebElement linkForIdLocatorTxt = driver.findElement(By.linkText("ID locator in Selenium"));
		linkForIdLocatorTxt.click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
	}

}
