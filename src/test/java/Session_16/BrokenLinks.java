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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinks {
	
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
	    List <WebElement> ListofImgTagsEle = driver.findElements(By.tagName("a"));
		
	    System.out.println("Total no of tags with img on the webpage is-> " + ListofImgTagsEle.size());
		
		for(int i = 0; i< ListofImgTagsEle.size(); i++)
		{
			String SourceLink = ListofImgTagsEle.get(i).getAttribute("href");
			
			try 
			{
				//Create an URL
				URL url = new URL(SourceLink);
				//Creating a connection with URL
				URLConnection urlConnection = url.openConnection();
				// Setting up the connection protocol as either HTTP or HTTPS
				HttpURLConnection httpURLConnection= (HttpURLConnection)urlConnection;
				//setting up connection time out
				httpURLConnection.setConnectTimeout(4000);
				// connect the url
				httpURLConnection.connect();
				
				if(httpURLConnection.getResponseCode()== 200)
				{
					System.out.println("The Source Link " + SourceLink + " -> is " + httpURLConnection.getResponseCode());
				}
				else
				{
					System.err.println("The Source Link " + SourceLink + " -> is " + httpURLConnection.getResponseCode());
				}
				
				// disconnect the url connection
				httpURLConnection.disconnect();
				
			}
			catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
			
	}
	


}
