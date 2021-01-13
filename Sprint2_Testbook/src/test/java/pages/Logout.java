package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Testbook_Base;

public class Logout extends Testbook_Base {
	static @FindBy (xpath="//ul[@class='post-header__action-nav d-none d-xl-block']/li[5]/span/img") WebElement profilepic;
	static @FindBy (xpath="//ul[@class='post-header__action-nav d-none d-xl-block']/li[5]/ul/li[5]") WebElement logoutlink;
	
		public Logout() {
			PageFactory.initElements(driver, this);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void click_logout() throws Exception {
			Thread.sleep(2000);
			profilepic.click();
			logoutlink.click();
		}
		
		public void logout_validation() {
			if(driver.getTitle().contains("Exam Preparation Site")) {
				System.out.println("User is logged out.");
				testlog = ext.createTest("Logout functionality");
				testlog.log(Status.PASS, "User was successfully logged out.");
				takescreenshot("AfterLogout_page.png");
			}
			else {
				System.out.println("User is not logged out.");
				testlog = ext.createTest("Logout functionality");
				testlog.log(Status.FAIL, "User was successfully not logged out.");
				takescreenshot("Afterlogout_page.png");
			}
		}
}
