package Session_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_InteractByName {
	
	public static void main(String[] args) throws InterruptedException 
	{
		String searchKeyword = "Maven";
		
		
        WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
		WebElement searchTextBox = driver.findElement(By.name("q"));
		searchTextBox.sendKeys(searchKeyword);
		
		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();
		
		Thread.sleep(3000);
		
		String expectedTiitle = searchKeyword + "- Google Search";
		
		if(expectedTiitle.equals(driver.getTitle()))
		{
			System.out.println("Search Functionality is working as expected");
		}
		else
		{
			System.out.println("Search Functionality is not working as expected");

		}
		driver.quit();
		
		
	}

}
