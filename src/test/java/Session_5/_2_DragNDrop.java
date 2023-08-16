package Session_5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _2_DragNDrop {

WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void dragNDrop() throws InterruptedException
	{
		driver.switchTo().frame( driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement element2 = driver.findElement(By.xpath("//div[@id='droppable']"));

		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(element1, element2).build().perform();
		
		WebElement droppedTxtEle = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		
		Assert.assertEquals("The Dropped Text is not visible after drag n drop activity", "Dropped!", droppedTxtEle.getText());
		
		

		
	}


}
