package Session_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_InteractByXpath {
	
	public static void main(String[] args) throws InterruptedException {
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.automationtesting.in/Register.html");
		
		
		WebElement firstNameField = driver.findElement(By.xpath("//input[@type='text' and @placeholder='First Name']"));
		if(firstNameField.isDisplayed())
		{
			firstNameField.sendKeys("Tom");
		}
		else
		{
			System.out.println("First WebElement is not displayed on the page");
		}
		
		WebElement LastNameField = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		if(LastNameField.isDisplayed())
		{
			LastNameField.sendKeys("Peter");
		}
		else
		{
			System.out.println("First WebElement is not displayed on the page");
		}
		
		WebElement hobbyOneChkBox = driver.findElement(By.xpath("//input[@id='checkbox1']"));
		if(hobbyOneChkBox.isEnabled())
		{
			hobbyOneChkBox.click();
			if(hobbyOneChkBox.isSelected())
			{
				System.out.println("hobby one checkbox  WebElement is selected");
			}
			else
			{
				System.out.println("Even after the hobby one checkbox  WebElement enabled and clicked is not selected");

			}
		}
		else
		{
			System.out.println("hobby one checkbox  WebElement is not enabled on the page");

		}
		

		WebElement password = driver.findElement(By.xpath("//input[@id='firstpassword' and @type='password']"));
		if(password.isDisplayed())
		{
			password.sendKeys("***");
		}
		else
		{
			System.out.println("First WebElement is not displayed on the page");
		}
		

//		WebElement address = driver.findElement(By.xpath("//input[@class='form-control ng-valid ng-dirty ng-valid-parse ng-touched' and @ng-model='Adress']"));
//		if(address.isDisplayed())
//		{
//			address.sendKeys("kolhapur");
//		}
//		else
//		{
//			System.out.println("Address WebElement is not displayed on the page");
//		}
		
		
		WebElement phone = driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required ng-valid-pattern' and @ng-model='Phone']"));
		if(phone.isDisplayed())
		{
			phone.sendKeys("98765432669");
		}
		else
		{
			System.out.println("Phone WebElement is not displayed on the page");
		}
		
		
		
		
		
		
		
		
		

		Thread.sleep(5000);
		
		driver.quit();
	}

}
