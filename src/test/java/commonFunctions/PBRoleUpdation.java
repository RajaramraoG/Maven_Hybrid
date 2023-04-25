package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBRoleUpdation {
	WebDriver driver;
	public PBRoleUpdation(WebDriver driver)
	{
		this.driver = driver;
	}
	//repository
	@FindBy(xpath ="//tbody/tr[2]/td[4]/a[1]/img[1]")
	WebElement ClickEdit;
	@FindBy(xpath ="//input[@id='txtrNameU']")
	WebElement EnterRoleName;
	@FindBy(xpath = "//input[@id='txtrdescU']")
	WebElement EnterRoleDes;
	@FindBy(xpath = "//select[@id='lstRtype']")
	WebElement SelectRoleType;
	@FindBy(xpath = "//input[@id='btnupdate']")
	WebElement ClickUpdate;
	public boolean verify_RoleUpdation(String RoleName, String RoleDes, String RoleType)
	{
		this.ClickEdit.click();
		this.EnterRoleName.clear();
		this.EnterRoleName.sendKeys(RoleName);
		this.EnterRoleDes.clear();
		this.EnterRoleDes.sendKeys(RoleDes);
		new Select(SelectRoleType).selectByVisibleText(RoleType);
		this.ClickUpdate.click();
		String ActualAlert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String ExpectedAlert = "Sucessfully";
		if(ActualAlert.toLowerCase().contains(ExpectedAlert.toLowerCase()))
		{
			Reporter.log("Role Updation Sucessfull::"+ActualAlert, true);
			return true;
		}
		else
		{
			Reporter.log("Role Updation Failed::"+ActualAlert, true);
			return false;
		}
	}
	
	
}
