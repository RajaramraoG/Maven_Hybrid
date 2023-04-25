package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBBranchUpdation {
	WebDriver driver;
	public PBBranchUpdation(WebDriver driver)
	{
		this.driver = driver;
	}
	//repository
	@FindBy(xpath = "//tbody/tr[2]/td[7]/a[1]/img[1]")
	WebElement ClickEdit;
	@FindBy(xpath = "//input[@id='txtbnameU']")
	WebElement EnterBranch;
	@FindBy(xpath = "(//input[@id='txtadd1u'])[1]")
	WebElement EnterAddress;
	@FindBy(xpath = "//input[@id='txtareaU']")
	WebElement EnterArea;
	@FindBy(xpath = "//input[@id='txtzipu']")
	WebElement EnterZip;
	@FindBy(xpath = "//input[@id='btnupdate']")
	WebElement ClickUpdate;
	public boolean verfy_UpdateBranch(String branchname, String address, String area, String zipcode)
	{
		this.ClickEdit.click();
		this.EnterBranch.clear();
		this.EnterBranch.sendKeys(branchname);
		this.EnterAddress.clear();
		this.EnterAddress.sendKeys(address);
		this.EnterArea.clear();
		this.EnterArea.sendKeys(area);
		this.EnterZip.clear();
		this.EnterZip.sendKeys(zipcode);
		this.ClickUpdate.click();
		String Expected = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String Actual = "Branch updated Sucessfully";
		if(Expected.toLowerCase().contains(Actual.toLowerCase()))
		{
			Reporter.log("Branch Updation Success::",true);
			return true;
		}
		else
		{
			Reporter.log("Branch Updation Failes::",true);
			return false;
		}
				
	}
	
	
}
