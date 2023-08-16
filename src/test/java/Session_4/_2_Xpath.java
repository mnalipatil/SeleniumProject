package Session_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_Xpath {
	
WebDriver driver;
String searchText1 = "Pepe Jeans sweater"; // Pepe Jeans Boy//Pepe Jeans Tshirts
String searchText2 = "Pepe Jeans Accesseries0";
	@Before
	public void setup()
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.myntra.com/");
		
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	@Ignore
	@Test
	public void prodSearch_1() throws InterruptedException
	{
		
		WebElement searchBoxElement = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		searchBoxElement.sendKeys("Pepe Jeans");
		
		Thread.sleep(3000);
		
		WebElement searchResultElement = driver.findElement(By.xpath("//li[text()='"+searchText1+"']"));
		searchResultElement.click();
		
		WebElement actualSearchResult = driver.findElement(By.xpath("//h1[@class='title-title']"));
		
		Assert.assertEquals("Product search for "+searchText1+" failed", searchText1, actualSearchResult.getText());
	
		//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']

     }
	
	@Test
	public void prodSearch_2() throws InterruptedException
	{
		
		WebElement searchBoxElement = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		searchBoxElement.sendKeys("Pepe Jeans");
		
		Thread.sleep(3000);
		
		List<WebElement>searchResultElements =  driver.findElements(By.xpath("//li[@class='desktop-suggestion null']"));
		
		for(int i = 0; i < searchResultElements.size(); i++)
			//System.out.println(searchResultElement.get(i).getText());
			if(searchResultElements.get(i).getText().equals("searchText2"))
		{
				searchResultElements.get(i).click();
				break;
		}
		WebElement actualSearchResult = driver.findElement(By.xpath("//h1[@class='title-title']"));
		
		Assert.assertEquals("Product search for "+searchText2+" failed", searchText2, actualSearchResult.getText());
	
		//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']

     }


}
