package extentreport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver = null;
	  ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
	   ExtentReports extent = new ExtentReports();
  @Test
  public void browser() {
	 // WebDriverManager.firefoxdriver().setup();
	//	 driver = new FirefoxDriver();
	ExtentTest test = extent.createTest("Launch browser");
	test.pass("Browser launced successfully");
  }
 
  @Test
  public void login() {
	  ExtentTest test = extent.createTest("Verify login");
	  test.pass("Login verified");
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
	  test.pass("System move to next page");
  }
  @BeforeTest
  public void beforeTest() {
  
 extent.AttachReporter(spark);
  }
  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
