package report;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class NewTest {
	private String URL = "https://askone.aroscop.org/";
	 ExtentReports extent = null;
	 @BeforeSuite
	 public void browser() throws InterruptedException {
		 ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");

	   
    //	 WebDriverManager.firefoxdriver().setup();
    //   WebDriver	 driver = new FirefoxDriver();
	//	WebDriverManager.chromedriver().setup();
		//  WebDriver driver = new ChromeDriver();
		// WebDriverManager.iedriver().setup();
		// InternetExplorerDriver driver = new InternetExplorerDriver();
		   //ExtentReports extent = new ExtentReports();
		  // Thread.sleep(3000);
		//   driver.get("https://admin.aroscop.com/");
		    }
	
	@Test
	public void login() {
		
		
		ExtentTest test = extent.createTest("Verify login");
		  test.pass("Login verified");
		  test.fail("Login failed");
		  test.skip("Login skipped");
	  }
	  @Test
	public void email() {
		  ExtentTest test = extent.createTest("verify email");
		  test.pass("Email verified");
	  }
	  @Test
	public void password() {
		  ExtentTest test = extent.createTest("verify password");
		  test.pass("password verified");
	  }
	  @Test
	public void next() {
		  ExtentTest test = extent.createTest("Move to next page");
		  Assert.fail("System move to next page");
	  }
	  @BeforeTest
  public void beforeTest() {
	  ExtentObserver spark = null;
	extent.attachReporter(spark);

  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
