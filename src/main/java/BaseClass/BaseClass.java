package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	 public static WebDriver driver;
	   public SoftAssert softAssert = new SoftAssert();
	   
	     public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/report.html");
	    public   ExtentReports extent = new ExtentReports(); 
	   	   public  ExtentTest test = extent.createTest("Login Test");
	      
	      
	  @Parameters("BrowserName")
	  @BeforeSuite
	  public void OpenBrowser(String BroswerName) 
	  {
		   if(BroswerName.equals("chrome"))
		   {
		//    System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		   }
		  
	  }
	  
	  @BeforeClass
		public void BeforClass()
		{
			  extent.attachReporter(spark);
		      extent.setSystemInfo("OS", "Windows"); 
		      extent.setSystemInfo("Tester", "QA Engineer"); 
		      extent.setSystemInfo("Browser", "Chrome");
		      spark.config().setDocumentTitle("Automation Report");
		      spark.config().setReportName("Selenium Execution Report");

		}

	  
	  @AfterSuite
	  public void Closebrowser()
	  {
		  driver.quit();
	  }
}
