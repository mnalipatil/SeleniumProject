package Session_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_InteractByCssSelector {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.co.in/");
		
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("Selenium Webdriver + Keys.Enter");
		
//		WebElement searchBtn = driver.findElement(By.name("btnK"));
//		searchBtn.click();
		
		Thread.sleep(10000);
		
		driver.quit();
	}

	
	
}
