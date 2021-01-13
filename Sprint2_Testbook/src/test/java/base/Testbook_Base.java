package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Testbook_Base {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports ext;
	public static ExtentTest testlog;
	
															// cucumber-junit annotation runs before @display_Homepage scenario
	//@BeforeSuite                               
	@Before("@Login")													// testNG annotation
	public void before_scenario()
	{		
		prop = new Properties();
		
		try {
			
			prop.load(new FileInputStream("src/test/resources/config.properties"));
		}catch (Exception e) {}
		
		String browser=prop.getProperty("browser");
		if(browser.matches("firefox"))
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		}
		if(browser.matches("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		}
		
		
		htmlreport = new ExtentHtmlReporter(prop.getProperty("reportloc")+"\\Testbook.html");
		ext = new ExtentReports();
		ext.attachReporter(htmlreport);
		ext.setSystemInfo("Host Name", "HP");
		ext.setSystemInfo("Environment", "Test Env");
		ext.setSystemInfo("User Name", "Swarali");										// username
		   
		htmlreport.config().setDocumentTitle("TestBook Report");										//snapdeal
		htmlreport.config().setReportName("TestBook Functional Testing");
		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);					//top
		htmlreport.config().setTheme(Theme.STANDARD);	
		   
		   
		
		System.out.println(".................before");
	}
	
	public void takescreenshot(String imagename)
	{
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	//takescreenshot of the webpage
		try
		{
		FileUtils.copyFile(f, new File(prop.getProperty("screenshot")+"\\"+imagename));	//save the file in the system
		testlog.addScreenCaptureFromPath(prop.getProperty("screenshot")+"\\"+imagename);	//add image to the report
		}catch(Exception e) {}
		
	}
	
																			// cucumber-junit ....last tag
	@After("@Testbook_4")																								
	//@AfterSuite
	public void after_scenario()
	{
		ext.flush();//save the report
		driver.quit();//close if anyall browsers which are open
		try
		{
		Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");//kill the geckodriver process
		}catch(Exception e) {}
		System.out.println(".................after");
	}

}