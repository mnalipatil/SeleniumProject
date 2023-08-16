package Session_11;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class _3_HeadLessBrowser {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		//options.addArguments("--incognito");
		//options.setExperimentalOption("execludeSwitches", new String[]{"enable-automation"});
		//options.addArguments("window-size=800,600");
		//options.addArguments("start-maximised");
		//options.addArguments("--ignore-certificate-errors");
		//options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://self-signed.badssl.com");
		driver.get("https://demo.automationtesting.in/Alerts.html");
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
		Thread.sleep(5000);
	}

}
