package Session_5;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class _4_DropDown {
	
WebDriver driver;

	String day = "15";
	String month = "Feb";
	String year = "2023";
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	@Ignore
	@Test
	public void dropdownSelection_1() throws InterruptedException
	{
		WebElement createAccBtnEle = driver.findElement(By.xpath("//a[text()='Create new account']"));
	
	    Actions act = new Actions(driver);
		act.click(createAccBtnEle).build().perform();
		Thread.sleep(3000);
		
		WebElement daySelectEle  = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select daySelectDrpDown = new Select(daySelectEle);
		daySelectDrpDown.selectByVisibleText("10");
		Thread.sleep(3000);

		WebElement monthSelectEle  = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select monthSelectDrpDown = new Select(monthSelectEle);
		monthSelectDrpDown.selectByValue("11");
		Thread.sleep(3000);
		
		WebElement yearSelectEle  = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select yearSelectDrpDown = new Select(daySelectEle);
		yearSelectDrpDown.selectByValue("11");
		Thread.sleep(3000);

	}
	
	@Test
	public void dropdownSelection_2() throws InterruptedException
	{
		WebElement createAccBtnEle = driver.findElement(By.xpath("//a[text()='Create new account']"));
	
	    Actions act = new Actions(driver);
		act.click(createAccBtnEle).build().perform();
		Thread.sleep(3000);
		
		List<WebElement> daySelectEle  = driver.findElements(By.xpath("//select[@id='day']/option"));
		for(int i = 0; i < daySelectEle.size(); i++)
		{
			if(daySelectEle.get(i).getText().equals(day))
			{
			 daySelectEle.get(i).click();
			 break;
			}
		}
		Thread.sleep(3000);

		List<WebElement> monthSelectEle  = driver.findElements(By.xpath("//select[@id='month']/option"));
		for(int i = 0; i < daySelectEle.size(); i++)
		{
			if(monthSelectEle.get(i).getText().equals(month))
			{
				 monthSelectEle.get(i).click();
				 break;
			}
		}
		Thread.sleep(3000);
		
		List<WebElement> yearSelectEle  = driver.findElements(By.xpath("//select[@id='year']/option"));
		for(int i = 0; i < daySelectEle.size(); i++)
		{
			if(yearSelectEle.get(i).getText().equals(year))
			{
				 yearSelectEle.get(i).click();
				 break;
			}
		}
		Thread.sleep(3000);

	}


}
