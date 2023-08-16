package Session_10;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _1_WebTableHandling_1 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	String userFirstName = "Iron123";
	String dessertName = "Ice cream";
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://letcode.in/table");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

	@Ignore
	@Test
	public void webTableHandling_1() throws InterruptedException
	{

		WebElement shopListTableEle = driver.findElement(By.xpath("//table[@id='shopping']"));
		wait.until(ExpectedConditions.visibilityOf(shopListTableEle));
		
		List<WebElement> prodPriceListEle = driver.findElements(By.xpath("//table[@id='shopping']/tbody/tr/td[2]"));
		WebElement prodFinalTotalEle = driver.findElement(By.xpath("//table[@id='shopping']/tfoot/td[2]/b"));

		//wait.until(ExpectedConditions.visibilityOfAllElements(searchResultList));
		int sum = 0;
		for(int i=0; i < prodPriceListEle.size(); i++)
		{
			//sum = sum + Integer.parseInt(prodPriceListEle.get(i).getText());
			sum += Integer.parseInt(prodPriceListEle.get(i).getText());
		}
//		Assert.assertEquals("All Product price total is not maching with final amount", sum,  Integer.parseInt(prodFinalTotalEle.getText()));
//		System.out.println("Test case for price validation is passed");
		
		if(sum == Integer.parseInt(prodFinalTotalEle.getText()))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}

	}
	@Ignore
	@Test
	public void webTableHandling_2() throws InterruptedException
	{
		 try
		 {
				WebElement userChkBoxEle = driver.findElement(By.xpath("//td[text()='"+userFirstName+"']//parent::tr//td/input"));
				userChkBoxEle.click();
				Assert.assertTrue(userChkBoxEle.isSelected());
				System.out.println("For user with first name as -> " +userFirstName+ " is clicked ");
		 }
		 catch(Exception e)
		 {
				System.out.println("For user with first name as -> " +userFirstName+ " is unavailable over the page ");
				e.printStackTrace();
				Assert.assertTrue(false);

		 }

	}
	
	@Test
	public void webTableHandling_3() throws InterruptedException
	{
		List<WebElement> dessertNutriValListEle = driver.findElements(By.xpath("//td[text()='"+dessertName+"']//following-sibling::td"));
		System.out.println("The Nutritional value for dessert name as -> " + dessertName);
		
		for(int i = 0; i < dessertNutriValListEle.size(); i++ )
		{
			System.out.println((i+1) + " . "+ dessertNutriValListEle.get(i).getText());
		}
	}


}
