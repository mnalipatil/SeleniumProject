package Session_7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _1_FrameHandling
{
	
WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Frames.html");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

	@Ignore
	@Test
	public void FrameHandling_1() throws InterruptedException
	{
		WebElement iframeEle = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(iframeEle);
		
		Thread.sleep(2000);

		WebElement textBoxInFrameEle = driver.findElement(By.xpath("//input[@type='text']"));
		textBoxInFrameEle.sendKeys("test test test");

		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		WebElement switchToDrpDownOptionEle = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(switchToDrpDownOptionEle).build().perform();

		Thread.sleep(2000);
	}
	

	@Test
	public void FrameHandling_2() throws InterruptedException
	{
		WebElement iframeinIFrameBtnEle = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		iframeinIFrameBtnEle.click();
		
		Thread.sleep(2000);

		WebElement firstFrameEle = driver.findElement(By.xpath("//div[@id='Multiple']/iframe"));
		driver.switchTo().frame(firstFrameEle);

		Thread.sleep(2000);
		
		WebElement secondFrameEle  = driver.findElement(By.xpath("//div[@class='iframe-container']/iframe"));
		driver.switchTo().frame(secondFrameEle);

		WebElement textBoxEle = driver.findElement(By.xpath("//input[@type='text']"));
		textBoxEle.sendKeys("test test test");
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
//		driver.switchTo().parentFrame();
//		driver.switchTo().parentFrame();
		
		WebElement switchToDrpDownOptionEle = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(switchToDrpDownOptionEle).build().perform();

		Thread.sleep(2000);
	}
	
}










