package Session_8;

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

public class _1_FileUpload {

WebDriver driver;
String fileUploadConfimTxt = "You've uploaded a file.  Your notes on the file were:";
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}


	@Test
	public void fileupload_1() throws InterruptedException
	{
		WebElement chooseFileBtnEle = driver.findElement(By.xpath("//input[@type='file']"));
		chooseFileBtnEle.sendKeys("C:\\npkey");
		Thread.sleep(2000);
		
		WebElement pressBtnEle = driver.findElement(By.xpath("//input[@type='submit']"));
		pressBtnEle.click();
		
		Thread.sleep(2000);
		
		WebElement confirmationTxtFileUpEle = driver.findElement(By.xpath("//p[text()=\"You've uploaded a file.  Your notes on the file were:\"]"));

		System.out.println("After file upload the text over next screen is->" + confirmationTxtFileUpEle.getText());
		
		//Assert.assertEquals("The File Upload is unsuccessful" , fileUploadConfimTxt, confirmationTxtFileUpEle.getText());
		Thread.sleep(2000);

	}
}
