package packng;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testng5 {

		WebDriver driver;
		SoftAssert sa=new SoftAssert();
		
		@BeforeTest
		public  void openBrowser()
		{
			driver=new FirefoxDriver();
			driver.get("file:///D:/2018%20Training%20PDFs/M4%20AT/Lesson%205-HTML%20Pages/WorkingWithForms.html");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
			String title=driver.getTitle();
			//Assert.assertEquals(title, "Email Registration Form");
			Assert.assertEquals(title, "Email Reg. Frm");
			//sa.assertEquals(title,"Email Reg. Frm");
		}
		
		@Test
		public  void testCaseOne() throws InterruptedException
		{
			driver.findElement(By.id("txtUserName")).sendKeys("Amit123");
			Thread.sleep(3000);
			driver.findElement(By.name("txtLN")).sendKeys("Pandit");
			Thread.sleep(3000);
			driver.findElement(By.name("submit")).click();
		}

		@AfterTest
		public  void closeBrowser() { driver.quit(); }
	}

