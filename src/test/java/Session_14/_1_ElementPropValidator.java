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
import org.openqa.selenium.support.Color;

public class _1_ElementPropValidator {

	WebDriver driver;
	String ExceptedClrValue = "#1877f2";
	String ExceptedCreateAccBtnCol = "#42b72a";
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
	public void fbLoginBtnColorValidation() 
	{
		//#1877f2
		//rgba(24, 119, 242, 1) -> HexaCodeNumber -> #1877f2
		
		WebElement fbLoginBtnColorValidation = driver.findElement(By.xpath("//button[@name='Login']"));
//		System.out.println("The colour of the Login button as RGBA id -> " +fbLoginBtnColorValidation.getCssValue("background-color"));
//		String rgbaVal = fbLoginBtnColorValidation.getCssValue("background-color");
//		String hexVal = Color.fromString(rgbaVal).asHex();
//		System.out.println("The colour of the Login button as HEX  id -> " +hexVal);
		Assert.assertEquals(ExceptedClrValue, _1_ElementPropValidator.rgbaToHexConversion(fbLoginBtnColorValidation.getCssValue("background-color")));
		
	}
	
	@Test
	public void fbCreateAccColorValidation() 
	{
		
		
		WebElement fbCreateAccButtonEle = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
//		System.out.println("The colour of the create account button as RGBA id -> " +fbCreateAccButtonEle.getCssValue("background-color"));
//		String rgbaVal = fbCreateAccButtonEle.getCssValue("background-color");
//		String hexVal = Color.fromString(rgbaVal).asHex();
//		System.out.println("The colour of the create account button as HEX  id -> " +hexVal);
		Assert.assertEquals(ExceptedCreateAccBtnCol, _1_ElementPropValidator.rgbaToHexConversion(fbCreateAccButtonEle.getCssValue("background-color")));
		
	}
		/**
		 * This method converts the RGBA value to HEX code
		 * @param rgbaVal
		 * @return String Value in HEX form
		 */
	public static String rgbaToHexConversion(String rgbaVal)
		
	{
		String convertedHex = Color.fromString(rgbaVal).asHex();
		return convertedHex;
		
	}
	
}






















