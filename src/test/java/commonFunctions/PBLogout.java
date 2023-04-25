package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBLogout {
WebDriver driver;
//constructor
public PBLogout(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath = "(//img)[4]")
WebElement ClickLogout;
@FindBy(xpath = "//input[@id='login']")
WebElement LoginButton;
public boolean verify_Logout() throws Throwable
{
	this.ClickLogout.click();
	Thread.sleep(3000);
	if(this.LoginButton.isDisplayed())
	{
		Reporter.log("Logout Success::", true);
		return true;
	}
	else
	{
		Reporter.log("Logout Failed::",true);
		return false;
	}
}

}
