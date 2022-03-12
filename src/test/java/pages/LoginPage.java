package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	
	ExtentTest test = BaseClass.test;
	
	//=====================WebElements==========================
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(className = "rememberMe")
	WebElement RememberMe;
	
	@FindBy(name = "btn_login")
	WebElement LoginButton;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//=====================Functions===========================
	
public void LoginFunction(String UserNameVal, String PasswordVal) {
		
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Login link clicked successfully");
		
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter UserName", "UserName entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password", "Password successfully");
		
		RememberMe.click();
		test.log(LogStatus.PASS, "Click on RememberMe", "RememberMe clicked successfully");
		
		LoginButton.click();
		test.log(LogStatus.PASS, "Click on LoginButton", "LoginButton clicked successfully");
	}

public void UICheck() {
	Assert.assertTrue(UserName.isDisplayed());
}

}
