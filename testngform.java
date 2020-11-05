package packng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testngform 
{
	
	WebDriver driver;
	        
    //Opening the browser
	        @BeforeTest 
	        public void openBrowser()
	        {
	        	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver2_win32\\chromedriver.exe");
	            driver=new ChromeDriver();
	            driver.get("file:///C:/Users/Abc/Downloads/WorkingWithForms%20(1).html");
	            String title=driver.getTitle();
	            System.out.println(title);
	            Assert.assertEquals(title,"Email Registration Form");
	            System.out.println("Title Verified");
	        }
	        
	// 1. For positive testing        
	        @Test(priority=0)
	        public void testRunone() throws InterruptedException{
	        	//Username
	            driver.findElement(By.id("txtUserName")).sendKeys("Tabrez");
	            
	            //Password
	            driver.findElement(By.id("txtPassword")).sendKeys("Kasu");
	            driver.findElement(By.id("txtConfPassword")).sendKeys("Kasu");
	            //Assert.assertSame(driver.findElement(By.id("txtPassword")), driver.findElement(By.id("txtConfPassword")));
	            String pass=driver.findElement(By.id("txtPassword")).getText();
	            System.out.println(String.valueOf(pass));
	            String confirmpass = driver.findElement(By.id("txtConfPassword")).getText();
	            System.out.println(confirmpass.intern());
	            Assert.assertEquals(pass, confirmpass);
	            System.out.println("Password verified");
	            
	            //First & Last Name
	            driver.findElement(By.id("txtFirstName")).sendKeys("Tabrez");
	            driver.findElement(By.id("txtLastName")).sendKeys("Kasu");
	            
	            //Gender
	            driver.findElement(By.name("gender")).click();
	            
	            //Date
	            WebElement date=driver.findElement(By.id("DOB"));
	            date.sendKeys("11091997");
	            
	            //Email
	            driver.findElement(By.xpath("//*[@id=\"txtEmail\"]")).sendKeys("kasu.tabrez97@gmail.com");
	            
	            //Address
	            driver.findElement(By.id("txtAddress")).sendKeys("Mumbai-400037");
	            
	            //City
	            Select City= new Select((driver.findElement(By.name("City"))));
	            City.selectByIndex(0);
	            
	            //Phone
	            driver.findElement(By.id("txtPhone")).sendKeys("9167825321");
	            
	            //Hobbies
	            List<WebElement> AllCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	            System.out.println("Number of Check boxes : "+ Integer.toString(AllCheckBoxes.size()));
	                
	    	      for(WebElement cb:AllCheckBoxes)
	    	        {
	    	            cb.click();
	    	        }
	            
	    	      //Submit
	    	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[13]/td/input")).click();
	    	      
	    	      //Alert
	    	      Alert alert=driver.switchTo().alert();
			      System.out.println(alert.getText());
			      Thread.sleep(3000);
			      alert.accept();
	        }

    //2. Incorrect Password Check      
	        @Test(priority=1)
	        public void testRunTwo() throws InterruptedException {
	        	//Password
	            driver.findElement(By.id("txtPassword")).sendKeys("Kasu");
	            driver.findElement(By.id("txtConfPassword")).sendKeys("Kasu98");
	            //Assert.assertSame(driver.findElement(By.id("txtPassword")), driver.findElement(By.id("txtConfPassword")));
	            String pass=driver.findElement(By.id("txtPassword")).getAttribute("Kasu");
	            String confirmpass = driver.findElement(By.id("txtConfPassword")).getAttribute("Kasu98");
	           // Assert.assertEquals(pass, confirmpass);
	           // System.out.println("hey ankita");
	            
	            driver.findElement(By.id("txtFirstName")).click();
	            Alert alert=driver.switchTo().alert();
			      System.out.println(alert.getText());
			      Thread.sleep(2000);
			      alert.accept();
			      
			    //Submit
	    	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[13]/td/input")).click();
	    	      
	    	      //Alert
	    	      Alert alert1=driver.switchTo().alert();
			      System.out.println(alert.getText());
			      Thread.sleep(3000);
			      alert1.accept();
		
	        }
	        
    //3. Incorrect email check    
	        @Test(priority=2)
	        public void testRunThree() throws InterruptedException {
	
	        	driver.findElement(By.xpath("//*[@id=\"txtEmail\"]")).sendKeys("kasu.tabrez97");
	        	
	        	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[13]/td/input")).click();
	        	
	        	 
	        }
	        
    //4. Reset check    
	        @Test(priority=3)
	        public void testRunFour() throws InterruptedException {
	        	
	        	
	            driver.findElement(By.id("txtUserName")).sendKeys("Tabrez");
	            
	            driver.findElement(By.id("txtPassword")).sendKeys("Kasu");
	            driver.findElement(By.id("txtConfPassword")).sendKeys("Kasu");
	           
	            driver.findElement(By.id("txtFirstName")).sendKeys("Tabrez");
	            driver.findElement(By.id("txtLastName")).sendKeys("Kasu");
	          
	            driver.findElement(By.name("gender")).click();
	      
	            WebElement date=driver.findElement(By.id("DOB"));
	            date.sendKeys("11091997");
	        
	            driver.findElement(By.xpath("//*[@id=\"txtEmail\"]")).sendKeys("kasu.tabrez97@gmail.com");
	        
	            driver.findElement(By.id("txtAddress")).sendKeys("Mumbai-400037");
	     
	            Select City= new Select((driver.findElement(By.name("City"))));
	            City.selectByIndex(0);
	      
	            driver.findElement(By.id("txtPhone")).sendKeys("9167825321");
	         
	            List<WebElement> AllCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	            System.out.println("Number of Check boxes : "+ Integer.toString(AllCheckBoxes.size()));
	                
	    	      for(WebElement cb:AllCheckBoxes)
	    	        {
	    	            cb.click();
	    	           
	    	        }
	    	      
	    	     Thread.sleep(3000);
	    	      
	    	   //Reset
    	       driver.findElement(By.xpath("//*[@id=\"myStyle\"]")).click();
    	       Thread.sleep(3000);
	        }
	        
	        
   //Closing the browser
	        @AfterTest
			public  void closeBrowser() { 
	        	
	        	 driver.quit(); 
	        	 
	        	}
}
	 

