package Session_11;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_ResizeBrowser {
	
	WebDriver driver;
		
		@Before
		public void setUp()
		{
			Dimension d = new Dimension(500,500);
			driver = new ChromeDriver();
			driver.manage().window().setSize(d);
			//driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.amazon.in/");
		}
		
		@After
		public void tearDown()
		{
			driver.quit();
		}


		@Test
		public void resizingTheBrowser() throws InterruptedException
		{
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
		}

}
