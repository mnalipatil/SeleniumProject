package Session_6;

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

public class _2_AuthPopUpHandle {

private static final Assert Assert = null;
WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://the-internet.herokuapp.com/basic_auth");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void AuthPopUpHandle() throws InterruptedException
	{
		String username = "admin";
		String password = "admin";
		
		String URL = "https://" + username + ";" + password + "@" + "the-internet.herokuapp.com/basic_auth";
		
		driver.get(URL);
		
		WebElement SuccessfulSignInTxtEle = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"));
			
		System.out.println("After Correct Authorisation the welcome text is-> " + SuccessfulSignInTxtEle.getText());
		
		Assert.assertEquals("Successful SignIn is not executed", "Congratulations! You must have the proper credentials.", SuccessfulSignInTxtEle.getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
