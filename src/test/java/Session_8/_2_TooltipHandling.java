package Session_8;

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


public class _2_TooltipHandling {

	WebDriver driver;
		
		@Before
		public void setUp()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://demoqa.com/tool-tips/");
		}
		
		@After
		public void tearDown()
		{
			driver.quit();
		}


		@Test
		public void TooltipHandling() throws InterruptedException
		{
			WebElement hoverMeToSeeBtnEle = driver.findElement(By.id("toolTipButton"));
			
			Actions act = new Actions(driver);
			act.moveToElement(hoverMeToSeeBtnEle).release().build().perform();
			
			Thread.sleep(2000);
			
			WebElement btntoolTipTxtEle = driver.findElement(By.id("//div[text()='You hovered over the Button']"));
			System.out.println("After hovering over the button the text is displayed as -> " + btntoolTipTxtEle.getText());
			
			Assert.assertEquals("You hovered over the Button", btntoolTipTxtEle.getText());
			
			WebElement hoverTextBoxEle = driver.findElement(By.id("toolTipTextField"));                                                                      
			act.moveToElement(hoverTextBoxEle).release().build().perform();

			Thread.sleep(2000);
			
            WebElement TextBoxToolTipTxtEle = driver.findElement(By.id("//div[text()='You hovered over the text field']"));                                
			System.out.println("After hovering over the textbox is displayed as -> " + TextBoxToolTipTxtEle.getText());
			
			Assert.assertEquals("You hovered over the text field", TextBoxToolTipTxtEle.getText());
			
			Thread.sleep(2000);

		}
}
