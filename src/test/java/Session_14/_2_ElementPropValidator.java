package Session_14;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _2_ElementPropValidator {
	
	String ExceptedfontSize = "20px";

	WebDriver driver;

	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manali Patil\\eclipse-workspace\\SeleniumWebDrive\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Users\\Manali Patil\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);	
		driver.quit();
	}


	@Test
	public void fbLoginBtnFontValidation() 
	{
		
		WebElement fbLoginBtnEle = driver.findElement(By.xpath("//button[@name='login']"));
		System.out.println("The font size of FB login button is -> " +fbLoginBtnEle.getCssValue("font-size"));
//		String rgbaVal = fbLoginBtnColorValidation.getCssValue("background-color");
//		String hexVal = Color.fromString(rgbaVal).asHex();
//		System.out.println("The colour of the Login button as HEX  id -> " +hexVal);
		Assert.assertEquals("Font size for FB login button is matching", ExceptedfontSize, fbLoginBtnEle.getCssValue("font-size"));
		
	}
}
