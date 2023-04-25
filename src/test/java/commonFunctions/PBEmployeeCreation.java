package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBEmployeeCreation {
	WebDriver driver;
	public PBEmployeeCreation(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy(xpath = "//input[@id='BtnNew']")
	WebElement ClickNewEmployee;
	@FindBy(xpath = "//input[@id='txtUname']")
	WebElement EnterEmpName;
	@FindBy(xpath = "//input[@id='txtLpwd']")
	WebElement EnterPass;
	@FindBy(xpath = "//select[@id='lst_Roles']")
	WebElement SelectRole;
	@FindBy(xpath = "//select[@id='lst_Branch']")
	WebElement SelectBranch;
	@FindBy(xpath = "//input[@id='BtnSubmit']")
	WebElement ClickSubmit;
	public boolean verify_EmployeeCreation(String EmpName, String Pass, String Role, String Branch)
	{
		this.ClickNewEmployee.click();
		this.EnterEmpName.sendKeys(EmpName);
		this.EnterPass.sendKeys(Pass);
		new Select(SelectRole).selectByVisibleText(Role);
		new Select(SelectBranch).selectByVisibleText(Branch);
		this.ClickSubmit.click();
		String ActualAlert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String ExpectedAlert = "New Employer";
		if(ActualAlert.toLowerCase().contains(ExpectedAlert.toLowerCase()))
		{
			Reporter.log("Employee Creation Successfull::"+ActualAlert, true);
			return true;
		}
		else
		{
			Reporter.log("Employee Creation Failed::"+ActualAlert, true);
			return false;
		}
	}
}
