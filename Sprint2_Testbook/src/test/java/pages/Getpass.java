package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base.Testbook_Base;

public class Getpass extends Testbook_Base {
	static @FindBy (linkText= "Get Pass") WebElement getpassbtn;
	static @FindBy (xpath= "//div[@class='passes-container']/div[1]") WebElement weeklypass;
	static @FindBy (xpath= "//div[@class='passes-container']/div[2]") WebElement monthlypass;
	static @FindBy (xpath= "//div[@class='passes-container']/div[3]") WebElement yearlypass;
	static @FindBy (xpath= "//iframe[@class='razorpay-checkout-frame']") WebElement payment_frame;
	static @FindBy(xpath="//div[@id='modal-close']") WebElement frame_close;
	String amount;
	
	public Getpass() {
		PageFactory.initElements(driver, this);
	}
	
	public void click_getpass() throws Exception {
		Thread.sleep(3000);
		getpassbtn.click();
		System.out.println("Get pass clicked");
	}
	
	public void select_type_of_pass() throws Exception {
		Thread.sleep(3000);
		
		FileInputStream passinput = new FileInputStream("C:\\Data driven\\passtype.xlsx");
		XSSFWorkbook wb1 = new XSSFWorkbook(passinput);
		XSSFSheet ws1 = wb1.getSheet("Sheet1");
		System.out.println("excel load");
		
		
		Row row= ws1.getRow(0);
		System.out.println("Row selected");
		String type = row.getCell(0).getStringCellValue();
		System.out.println(type);
		if(type.equals("Weekly"))
		{
			weeklypass.click();
			amount = "99";
			System.out.println("Weekly selected");
			
		}
		else if(type.equals("Monthly"))
		{
			monthlypass.click();
			amount = "149";
			System.out.println("Monthly selected");
	
		}
		else
		{
			yearlypass.click();
			amount = "299";
			System.out.println("Yearly selected");
		}
		wb1.close();
		passinput.close();		
	}
	
	public void payment_options() {
		driver.switchTo().frame(payment_frame);
		String shownamount = driver.findElement(By.xpath("//div[@id='amount']/span[2]")).getText();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		System.out.println("shownamount = " + shownamount);
		System.out.println(amount);
		if(shownamount.contains(amount)) {
			System.out.print("Correct amount");
			testlog = ext.createTest("Verify Payment amount");
			testlog.log(Status.PASS, "User is charged with the correct amount");
			takescreenshot("payment.png");
		}
		else{
			System.out.println("Incorrect amount");
			testlog = ext.createTest("Verify Payment amount");
			testlog.log(Status.FAIL, "User is charged with the correct amount");
			takescreenshot("payment.png");
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		frame_close.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		System.out.println("Switched to parent");
	}

}
 