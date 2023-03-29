package driversetup;

import org.testng.annotations.Test;

import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
import com.testing.framework.EmailUtils;

import io.github.bonigarcia.wdm.WebDriverManager;



public class multipledrivers<EmailAttachment, PasswordAuthentification> {
	private static final int TC_01 = 0;
	private static final int TC_02 = 0;
	private static final String Emailutil = null;
	WebDriver driver = null;
	ExtentReports extent;
	ExtentSparkReporter spark;
	@BeforeSuite
	public void report() {
		 extent = new ExtentReports();
		 spark = new ExtentSparkReporter("KritterReport.html");
		extent.attachReporter(spark);
	}
	@Parameters("BrowserName")
	@BeforeMethod
	public void setup(@Optional String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			 ChromeOptions chromeOptions = new ChromeOptions();
			 chromeOptions.addArguments("--remote-allow-origins=*");
	     WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver(chromeOptions);
	     driver.get("http://admin.aroscop.com/login");
	     driver.manage().window().maximize();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
	     WebDriverManager.firefoxdriver().setup();
	     driver = new FirefoxDriver();
	     driver.get("http://admin.aroscop.com/login");
	     driver.manage().window().maximize();
	 
		}
		else if (browserName.equalsIgnoreCase("IE")) {
	 WebDriverManager.iedriver().setup();
	 driver = new InternetExplorerDriver();
	 driver.get("http://admin.aroscop.com/login");
	 driver.manage().window().maximize();
		}
	}
    @Test
	public void loginwebsite() throws IOException, InterruptedException {
		ExtentTest test = extent.createTest("kritter login page");
		driver.get("http://admin.aroscop.com/login");
		test.log(Status.INFO, "Landing loginpage");
		test.pass("Successfully landed login page");
		driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/form/fieldset/div[1]/div/input")).sendKeys("ScieraAdmin");
		driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/form/fieldset/div[2]/div/input")).sendKeys("SciPi123@");
		driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/form/fieldset/div[3]/button")).click();
	//	String currentWindowHandle=driver.getWindowHandle(); 
		//driver.switchTo().window(currentWindowHandle);

		test.pass("login successfully");
		test.pass("Landing dashboard page succeefully",MediaEntityBuilder.createScreenCaptureFromPath("KritterReport/screenshot.png").build());
		Thread.sleep(5000);
		test.addScreenCaptureFromPath(capturescreenshot(driver));
    }
	@AfterMethod
	public void closebrowser() throws Exception    {
		
		driver.close();
		
	}
       
	@AfterSuite
	public void teardown() throws Exception{
		extent.flush();
	}
		@Test
		public String capturescreenshot(WebDriver driver) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("Screenshot.png");
		String filepath = destination.getAbsolutePath();
		FileUtils.copyFile(source, destination);
		System.out.println("------file path----" +filepath);
		return filepath;
		
		
	}

}
