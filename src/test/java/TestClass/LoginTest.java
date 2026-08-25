package TestClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseClass.BaseClass;
import PageClass.LoginPageClass;

public class LoginTest extends BaseClass
{
		
	
  @Test
  public void LoginTest() 
  {
     
      
      driver.get("file:///C:/Users/avina/Downloads/IT%20vedant/Selenium-20260730T142733Z-1-001/Selenium/Selenium%20Basic%20Automation/OfflineWebsiteForSelenium/OfflineWebsite/pages/examples/login.html");
	  
      test.info("Opened URL");
      
      LoginPageClass lp = new LoginPageClass(driver);
	   lp.login("kiran@gmail.com","123456");
	  
      test.info("Clicked login button");
      
      if(driver.getCurrentUrl().equals("file:///C:/Users/avina/Downloads/IT%20vedant/Selenium-20260730T142733Z-1-001/Selenium/Selenium%20Basic%20Automation/OfflineWebsiteForSelenium/OfflineWebsite/pages/examples/dashboard1.html"))
    		{
    		    test.pass("Login Successful");
    		    
    		}
    		else
    		{
    		    test.fail("Login Failed");
    		    
    		}
      
      
      File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File dest = new File("test-output/screenshots/LoginTest.png");
      try 
      {
		FileUtils.copyFile(src, dest);
	  } catch (IOException e) 
      {
		
	
	  }

      test.addScreenCaptureFromPath(dest.getAbsolutePath());
     
      extent.flush();
  }
  
  
    
  
}
