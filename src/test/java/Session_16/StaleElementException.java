package Session_16;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementException {

	WebDriver driver;
	WebDriverWait wait;
	
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
		driver.get("https://demo.automationtesting.in/");
	}
	
	@After
	public void tearDown() throws InterruptedException
	{
		driver.quit();
	}


	@Test
	public void tc_01() throws InterruptedException 
	{
		try {
			WebElement signinBtnEle = driver.findElement(By.id("btn1"));
			System.out.println("The text on the button is -> " +signinBtnEle.getText());
			
			driver.navigate().refresh();
			
		} 
		catch (StaleElementReferenceException e) 
		{
			WebElement signinBtnEle = driver.findElement(By.id("btn1"));

			System.out.println("The text on the button is -> " +signinBtnEle.getText());

		}
		
	}
	
}
