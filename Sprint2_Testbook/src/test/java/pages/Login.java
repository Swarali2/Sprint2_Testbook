package pages;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import base.Testbook_Base;

public class Login extends Testbook_Base{
	static @FindBy(linkText = "Login") WebElement login_button;
	static @FindBy(id = "loginUsername") WebElement email_field;
	static @FindBy(xpath = "//button[@ng-click='proceedToLogin(user)']") WebElement next_button;
	static @FindBy(name = "pswd") WebElement password_field;
	static @FindBy(xpath = "//button[text()='Login']") WebElement user_login_button;
	static @FindBy(id = "onBoardingIframe") WebElement login_frame;
	//static @FindBy(name = "notification-frame-173045c57") WebElement notification_frame;
    //static @FindBy(xpath = "//div[@data-error ='Please enter a valid email or mobile']") WebElement
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	public void openurl() throws Exception {
		driver.get(prop.getProperty("url"));
		
		if(driver.getTitle().contains("Testbook.com")) {
			System.out.println("User directed to testbook website.");
			testlog = ext.createTest("Verify URL");
			testlog.log(Status.PASS, "User is on the website.");
			takescreenshot("Testbook_website.png");
		}
		else{
			System.out.println("User not directed to testbook website.");
			testlog = ext.createTest("Verify URL");
			testlog.log(Status.FAIL, "User is not on the testbook website.");
			takescreenshot("Testbook_website.png");
		}
		
		Thread.sleep(5000);
	}
	
	public void click_login() throws Exception {
		Thread.sleep(20000);
		//WebDriverWait wait = new WebDriverWait(driver , 60);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("notification-frame-~558675c8")));
		new Actions(driver).click().perform();
		System.out.println("Pop up Disabled");
		
		new Actions(driver).moveToElement(login_button).moveByOffset(30, 30).click().perform();
		login_button.click();
		System.out.println("User is on login page.");
		WebDriverWait wait = new WebDriverWait(driver , 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onBoardingIframe")));
		//Thread.sleep(3000);
		//new Actions(driver).click().perform();
		if (login_frame.isDisplayed()) {
			driver.switchTo().frame(login_frame);
		}
		else {}
		
	}
	
	public void enter_email(String email) {
		email_field.sendKeys(email);
		next_button.click();
		System.out.println("User enters email credentials.");
		/*testlog = ext.createTest("Email Input");
		testlog.log(Status.PASS, "User successfully enters email.");
		takescreenshot("Enter_email.png");*/
	}
	
	public void enter_password(String password) throws Exception {
		password_field.sendKeys(password);
		user_login_button.click();
		Thread.sleep(2000);
		System.out.println("User enters password credentials.");
		/*testlog = ext.createTest("Password Input");
		testlog.log(Status.PASS, "User successfully enters password.");
		takescreenshot("Enter_password.png");*/
		Thread.sleep(3000);

	}
	
	public void validate_dashboard() throws Exception {
		/*WebDriverWait wait = new WebDriverWait(driver , 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("notification-frame-~558675c8")));
		new Actions(driver).click().perform();*/
		
		String expectedurl = "https://testbook.com/home";
		String actualurl = driver.getCurrentUrl();
		AssertJUnit.assertEquals(expectedurl, actualurl);
		System.out.println("Assert");
		
		if(expectedurl.equalsIgnoreCase(actualurl)) {
			System.out.println("User is on dashboard after login.");
			testlog = ext.createTest("Valid Login Functionality");
			testlog.log(Status.PASS, "User was successfully logged in.");
			takescreenshot("Dashboard_page.png");
		}
		else {
			System.out.println("User is not logged in.");
			testlog = ext.createTest("Valid Login Functionality");
			testlog.log(Status.FAIL, "User was not successfully logged in.");
			takescreenshot("Dashboard_page.png");
		}
		Thread.sleep(3000);

	}
}