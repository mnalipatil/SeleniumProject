package Session_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_InteractByPartialLinkTxt {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://dzone.com/articles/find-elements-with-link-text-amp-partial-link-text");
		
		WebElement linkForNameLocatorTxt = driver.findElement(By.partialLinkText("Name locator in"));
		linkForNameLocatorTxt.click();
		
		Thread.sleep(10000);
		
		driver.quit();
	}
		
}
