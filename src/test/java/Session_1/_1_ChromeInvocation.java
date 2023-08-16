package Session_1;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class _1_ChromeInvocation {
	
	public static void main(String[] args) 
	{
		//C:\Users\manali patil\eclipse-workspace\SeleniumWebDrive
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\manali patil\\eclipse-workspace\\SeleniumWebDrive\\chromedriver.exe");
		//System.setProperty("webdriver.opera.driver", "C:\\Users\\manali patil\\eclipse-workspace\\SeleniumWebDrive\\operadriver.exe");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chromedriver.exe" );
		
	    WebDriver driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
	    driver.get("https://www.google.co.in/");
	    
	    String exceptedTitle = "Google";
	    
	    String actualTitle = driver.getTitle();
	    
	    if(exceptedTitle.equals(actualTitle))
	    {
	    	System.out.println("The title is correct");
	    }
	    else
	    {
	    	System.out.println("This title is incorrect");
	    }
	    
	    
	    driver.quit();
	}

}
