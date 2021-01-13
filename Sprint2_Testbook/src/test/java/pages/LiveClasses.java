package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Testbook_Base;

public class LiveClasses extends Testbook_Base {
	
	static @FindBy(xpath="//div[@class='lp-tabs shows-bar pav-class-videosTabActive pav-class']") WebElement liveclasslink;
	static @FindBy(xpath="//div[@class='videos lp-tab pav-class-videosTabActive pav-class pav-class-videosLoader show']") WebElement allvideos; 
	static @FindBy(xpath="//div[@class='video child-0']") WebElement firstvideo;
	static @FindBy(xpath="//div[@class='video child-0']/div/div[3]") WebElement subject; 
	static @FindBy(linkText="View all Classes") WebElement novideos;
	static @FindBy(xpath="//h1[@class='video-title mt--0 mb-0 ng-binding']") WebElement videotitle;
	
	public String subjectName, shortsubjectname;
	
	public LiveClasses() {
		PageFactory.initElements(driver, this);
	}
	
	public void LiveTab() throws Exception {
		liveclasslink.click();
		System.out.println("Clicks on classes from live tab");
		Thread.sleep(7000);
		
	}
	
	public void expandedView() {
		if(allvideos.isDisplayed()) {
			System.out.println("Live class expanded list");
			testlog = ext.createTest("View all Live Classes");
			testlog.log(Status.PASS, "Expanded list visible");
			takescreenshot("Allvideos.png");
		}
		else {
			System.out.println("Live class expanded list");
			testlog = ext.createTest("View all Live Classes");
			testlog.log(Status.FAIL, "Expanded list not visible");
			takescreenshot("Allvideos.png");
		} 
	}
	
	public void click_Video() throws Exception {
		Thread.sleep(3000);
		
		subjectName = subject.getText();
		System.out.println("Video name: " + subjectName);
		String shortsubjectname = subjectName.substring(0, subjectName.length() - 5);
		System.out.println("Video name short : " + shortsubjectname);
		
		firstvideo.click();
		System.out.println("User clicks on video");
		Thread.sleep(7000);
	}
	
	public void validate_video_page() {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String videopagetitle = driver.getTitle();
		System.out.println("Videopage title= " + videopagetitle);
		String videoname = videotitle.getText();
		System.out.println("Video title= " + videoname);
		
		if(driver.getTitle().contains(shortsubjectname)) {
			System.out.println("User is on correct page");
			testlog = ext.createTest("User redirected to selected video");
			testlog.log(Status.PASS, "User is on correct page");
			takescreenshot("selectedvideo.png");
		}
		else {
			System.out.println("User is on wrong page");
			testlog = ext.createTest("User redirected to selected video");
			testlog.log(Status.FAIL, "User is not on correct page");
			takescreenshot("selectedvideo.png");
		} 
		
	} 
	

}
