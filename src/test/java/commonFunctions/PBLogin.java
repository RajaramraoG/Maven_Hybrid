package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBLogin {
	WebDriver driver;
	//constructor
	public PBLogin(WebDriver driver)
	{
		this.driver = driver;
	}
	//repository
	@FindBy(xpath = "//input[@id='txtuId']")
	WebElement EnterUser;
	@FindBy(xpath = "//input[@id='txtPword']")
	WebElement EnterPass;
	@FindBy(xpath = "//input[@id='login']")
	WebElement ClickLogin;
	public boolean verify_Login(String username, String password)
	{
		EnterUser.sendKeys(username);
		EnterPass.sendKeys(password);
		ClickLogin.click();
		String Expected = "AdminFlow";
		String Actual = driver.getCurrentUrl();
		if(Actual.toLowerCase().contains(Expected.toLowerCase()))
		{
			Reporter.log("Login Success::"+Expected+"    "+Actual,true);
			return true;
		}
		else
		{
			Reporter.log("Login Failed::"+Expected+"    "+Actual,true);
			return false;
		}
	}
	
	
	

}
