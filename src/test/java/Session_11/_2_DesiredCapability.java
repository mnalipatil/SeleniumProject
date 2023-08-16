package Session_11;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class _2_DesiredCapability {

	WebDriver driver;
	
	@Before
	public void setUp()
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setAcceptInsecureCerts(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://self-signed.badssl.com");
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