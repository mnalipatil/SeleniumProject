package Session_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _0_Xpath {
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		///html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input
		
		WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBoxElement.sendKeys("iphone");
		
		WebElement searchButtonElement = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButtonElement.click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
		
	}

}
