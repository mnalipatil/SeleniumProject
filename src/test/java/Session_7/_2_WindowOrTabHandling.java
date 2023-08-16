package Session_7;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
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

public class _2_WindowOrTabHandling {

WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/browser-windows");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void tabHandling() throws InterruptedException
	{
		System.out.println("Title of Origional Page -> " + driver.getTitle());
		
		WebElement newTabButtonEle = driver.findElement(By.xpath("//button[@id='tabButton']"));
		newTabButtonEle.click();
		Thread.sleep(2000);
		
		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
		//Iterator<String> it = handles.iterator();	
		
		String parentWindowId = handles.get(0);
		String childWindowId = handles.get(1);
		
		System.out.println("Session ID for Parent -> " + parentWindowId);
		System.out.println("Session ID for Child -> " + childWindowId);
		
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);
		
		WebElement contentOnNewTabEle = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("The TExt over new tab page is -> " + contentOnNewTabEle.getText());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		Thread.sleep(2000);
		System.out.println("Title of the page -> " + driver.getTitle());

		
	}

}
