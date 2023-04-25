package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBEmployeeUpdation {
	WebDriver driver;
	public PBEmployeeUpdation(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy(xpath = "(//img)[10]")
	WebElement ClickEdit;
	@FindBy(xpath = "//input[@id='txtBnameU']")
	WebElement EnterEmpName;
	@FindBy(xpath = "//input[@id='txtPwdU']")
	WebElement EnterPass;
	@FindBy(xpath = "//select[@id='lstrolesU']")
	WebElement SelectRole;
	@FindBy(xpath = "//select[@id='lstBidU']")
	WebElement SelectBranch;
	@FindBy(xpath = "//input[@id='BtnUpdate']")
	WebElement ClickUpdate;
	public boolean verify_EmployeeUpdation(String EmpName, String Pass, String Role, String Branch) throws Throwable
	{
		this.ClickEdit.click();
		this.EnterEmpName.clear();
		Thread.sleep(2000);
		this.EnterEmpName.sendKeys(EmpName);
		Thread.sleep(2000);
		this.EnterPass.clear();
		Thread.sleep(2000);
		this.EnterPass.sendKeys(Pass);
		Thread.sleep(2000);
		new Select(SelectRole).selectByVisibleText(Role);
		Thread.sleep(2000);
		new Select(SelectBranch).selectByVisibleText(Branch);
		Thread.sleep(2000);
		this.ClickUpdate.click();
		Thread.sleep(2000);
		String ActualAlert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String ExpectedAlert = "Successful";
		if(ActualAlert.toLowerCase().contains(ExpectedAlert.toLowerCase()))
		{
			Reporter.log("Employee Updation Successfull::"+ActualAlert, true);
			return true;
		}
		else
		{
			Reporter.log("Employee Updation Failed::"+ActualAlert, true);
			return false;
		}

	}
}
