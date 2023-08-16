package Session_9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sychronisation_2 {

	WebDriver driver;
	WebDriverWait wait;
	//Actions act;
	String searchKeyword = "Tshirt";
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}


	@Test
	public void synchronisatin_1() throws InterruptedException
	{

		WebElement accNListEle = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		//act.moveToElement(accNListEle).release().build().perform();
		accNListEle.sendKeys(searchKeyword);
		
		List<WebElement> searchResultList = driver.findElements(By.xpath("//ul[@class='desktop-group']/li[@class='desktop-suggestion null']"));

		wait.until(ExpectedConditions.visibilityOfAllElements(searchResultList));
		for(int i=0; i < searchResultList.size(); i++)
		{
			System.out.println(searchResultList.get(i).getText());
		}
	}
}
