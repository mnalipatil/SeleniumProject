package Session_6;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_AlertHandling{
	
WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Alerts.html");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

	@Ignore
	@Test
	public void AlertHandling_1() throws InterruptedException
	{
		WebElement alertGenButtonEle = driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]"));
		alertGenButtonEle.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("The next on alert box is -> " + alert.getText());
		
		Assert.assertEquals("Alert Text is not matching","I am an alert box!", alert.getText());
		
		alert.accept();

	}
	
	@Ignore
	@Test
	public void AlertHandling_2() throws InterruptedException
	{
		WebElement alertOknCanButtonEle = driver.findElement(By.xpath("//@[text()='Alert with OK & Cancel ']"));
		alertOknCanButtonEle.click();

		WebElement alertGenButtonEle = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
		alertGenButtonEle.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Alert with 2 buttons with text is -> " + alert.getText());
		
		Assert.assertEquals("Alert Text is not matching","Press a Button !", alert.getText());
		
		alert.accept();
		
		WebElement afterAlertAcceptTxtEle = driver.findElement(By.xpath("//p[@id='demo']"));
		
		System.out.println("After clicking on an alert the text over screen is -> " + afterAlertAcceptTxtEle.getText());
		
		Assert.assertEquals("After clicking on an Ok button of Alert thed expeted text is wrong", "You pressed Ok", afterAlertAcceptTxtEle.getText());
	
	}
	@Ignore
	@Test
	public void AlertHandling_3() throws InterruptedException
	{
		WebElement alertOknCanButtonEle = driver.findElement(By.xpath("//@[text()='Alert with OK & Cancel ']"));
		alertOknCanButtonEle.click();

		WebElement alertGenButtonEle = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
		alertGenButtonEle.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Alert with 2 buttons with text is -> " + alert.getText());
		
		Assert.assertEquals("Alert Text is not matching","Press a Button !", alert.getText());
		
		alert.dismiss();
		
		WebElement afterAlertAcceptTxtEle = driver.findElement(By.xpath("//p[@id='demo']"));
		
		System.out.println("After clicking on an alert the text over screen is -> " + afterAlertAcceptTxtEle.getText());
		
		Assert.assertEquals("After clicking on an Ok button of Alert thed expeted text is wrong", "You Pressed Cancel", afterAlertAcceptTxtEle.getText());
	
	}
	
	@Test
	public void AlertHandling_4() throws InterruptedException
	{
		String UserName = "Dave";
		
		WebElement alertWithTxBoxtButEle = driver.findElement(By.xpath("//@[text()='Alert with Textbox ']"));
		alertWithTxBoxtButEle.click();
		
		WebElement alertPromptButEle = driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
		alertPromptButEle.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Dave");
		
		alert.accept();
		
		WebElement actualTextFormEle = driver.findElement(By.xpath("//p[contains(text(),'Hello "+UserName+" How are you today')]"));
		System.out.println("Text after Alert is accepted -> " + actualTextFormEle.getText());
		
		Assert.assertEquals("After Clicking on an Ok button of Alert the expexted text is wrong", "Hello "+UserName+" How are you today", actualTextFormEle.getText());


	}
		
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		