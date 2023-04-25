package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBRoleCreation {
	WebDriver driver;
	//constructor
	public PBRoleCreation(WebDriver driver)
	{
		this.driver = driver;
	}
	//repository
	@FindBy(xpath = "//input[@id='btnRoles']")
	WebElement clickNewRole;
	@FindBy(xpath = "//input[@id='txtRname']")
	WebElement RoleName;
	@FindBy(xpath = "//input[@id='txtRDesc']")
	WebElement RoleDesc;
	@FindBy(xpath = "//select[@id='lstRtypeN']")
	WebElement SelectRoleType;
	@FindBy(xpath = "//input[@id='btninsert']")
	WebElement ClickSubmit;
	public boolean verify_RoleCreation(String rolename, String roledesc, String roletype) throws Throwable
	{
		this.clickNewRole.click();
		Thread.sleep(5000);
		this.RoleName.sendKeys(rolename);
		Thread.sleep(5000);
		this.RoleDesc.sendKeys(roledesc);
		Thread.sleep(5000);
		new Select(SelectRoleType).selectByVisibleText(roletype);
		Thread.sleep(5000);
		this.ClickSubmit.click();
		Thread.sleep(5000);
		String expectedalert = driver.switchTo().alert().getText();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		String actualalert = "New Role with id";
		if(expectedalert.toLowerCase().contains(actualalert.toLowerCase()))
				{
					Reporter.log("New Role Creation Successfull::"+expectedalert, true);
					return true;
				}
		else
		{
			Reporter.log("New Role Creation Failed::"+expectedalert, true);
			return false;
		}
		
	}
	
	
	
	

}
