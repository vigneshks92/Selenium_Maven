package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void LoginFailureTest() {
		
		test = reports.startTest("LoginFailureTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction("fgfdgfd@fgf.com","Abcd@1234");
		
		WebElement ErrorMessage = driver.findElement(By.id("msg_box"));
		String ActualMsg = ErrorMessage.getText();
		String ExpectedMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpectedMsg);
		
		reports.endTest(test);
		
	}
	
	/*@Test
	public void LoginSuccessTest() {
		
		LoginPage login = new LoginPage();
		login.LoginFunction("ghtr@cvg.com","Abcd@1234");
		
	}
	
	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);		
		
	}*/

	@Test
	public void ExternalDataTest() {
			
			String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
			String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
			
			LoginPage login = new LoginPage();
			login.LoginFunction(UserNameVal,PasswordVal);		
		}


}
