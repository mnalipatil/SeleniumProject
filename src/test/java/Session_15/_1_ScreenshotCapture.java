package Session_15;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class _1_ScreenshotCapture {
	
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
		driver.get("https://www.google.com/");
	}
	
	@After
	public void tearDown() throws InterruptedException
	{
		driver.quit();
	}


	@Test
	public void tc_01() throws InterruptedException 
	{
		WebElement searchBoxEle = driver.findElement(By.name("q"));
		searchBoxEle.sendKeys("Automation testing with selenium");
		
		WebElement searchButtonEle = driver.findElement(By.name("btnK"));
		searchButtonEle.click();
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		scnCapture(driver,"AutomationWithSelenium");
	}
	
	@Test
	public void tc_02() throws InterruptedException 
	{
		WebElement searchBoxEle = driver.findElement(By.name("q"));
		searchBoxEle.sendKeys("Selenium Webdriver");
		
		WebElement searchButtonEle = driver.findElement(By.name("btnK"));
		searchButtonEle.click();
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		scnCapture(driver,"SeleniumWebDriver");

	}
	
	/**
	 * This method captures a screenshot
	 * @param driver
	 * @param screenshotFileName
	 */
	public static void scnCapture(WebDriver driver,String screenshotFileName) 
	{
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\Manali Patil\\eclipse-workspace\\SeleniumWebDrive\\src\\test\\java\\Session_15\\screenshot\\"+screenshotFileName+System.currentTimeMillis()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}










