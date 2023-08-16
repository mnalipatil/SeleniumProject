package Session_3;

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


public class _1_Xpath {
	
	WebDriver driver;
	
	@Before
	public void setup()
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void prodSearch_1() throws InterruptedException
	{
		
		WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBoxElement.sendKeys("iphone");
		
		WebElement searchButtonElement = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButtonElement.click();
		
		Thread.sleep(3000);
		
		String expectedTitle = "Amazone.in : iphone";
		
//		Assert.assertEquals(expectedTitle,driver.getTitle());
		//Assert.assertEquals("Iphone product searching is failed", expectedTitle, driver.getTitle());
		
		//div[@class='a-section a-spacing-small a-spacing-top-small']/span[contains(text(),'iphone')]
		
		WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[contains(text(),'iphone')]"));
		String iphoneSearchResultTxt = searchResultElement.getText();
		String iphoneSearchRelExpTxt = "\"iphone\""; //"iphone" -> iphone
		System.out.println(iphoneSearchResultTxt);
		
		Assert.assertEquals("Searching for prodct iphone text failed", iphoneSearchRelExpTxt, iphoneSearchResultTxt);
		
	}
//	@Ignore
	@Test
	public void prodSearch_2() throws InterruptedException
	{
		
		///html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input
		
		WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBoxElement.sendKeys("pixel");
		
		WebElement searchButtonElement = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButtonElement.click();
		
		Thread.sleep(3000);
		String expectedTitle = "Amazone.in : pixel";
		
//		Assert.assertEquals(expectedTitle,driver.getTitle());
		//Assert.assertEquals("Pixel product searching is failed",expectedTitle,driver.getTitle());

		WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[contains(text(),'pixel')]"));
		String pixelSearchResultTxt = searchResultElement.getText();
		String pixelSearchRelExpTxt = "\"pixel\""; //"iphone" -> iphone
		System.out.println(pixelSearchResultTxt);
		
		Assert.assertEquals("Searching for prodct iphone text failed", pixelSearchRelExpTxt, pixelSearchResultTxt);
		

	}
	

}
