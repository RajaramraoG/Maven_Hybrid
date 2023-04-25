package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBBranchCreation {
WebDriver driver;
//constructor
public PBBranchCreation(WebDriver driver)
{
	this.driver=driver;
}
//repository
@FindBy(xpath = "//input[@id='BtnNewBR']")
WebElement ClickNewBranch;
@FindBy(xpath = "//input[@id='txtbName']")
WebElement EnterBranch;
@FindBy(xpath = "(//input[position()=1])[4]")
WebElement EnterAddress1;
@FindBy(xpath = "(//input[position()=1])[5]")
WebElement EnterAddress2;
@FindBy(xpath = "(//input[position()=1])[6]")
WebElement EnterAddress3;
@FindBy(xpath = "(//input[position()=1])[7]")
WebElement EnterArea;
@FindBy(xpath = "(//input[position()=1])[8]")
WebElement EnterZipcode;
@FindBy(xpath = "//select[@id='lst_counrtyU']")
WebElement SelectCountry;
@FindBy(xpath = "//select[@id='lst_stateI']")
WebElement SelectState;
@FindBy(xpath = "//select[@id='lst_cityI']")
WebElement SelectCity;
@FindBy(xpath = "//input[@id='btn_insert']")
WebElement ClickSubmit;
public boolean verify_Branchcreate(String branchname, String Address1, String Address2, String Address3, String Area, String Zipcode, String Country, String State, String City) throws Throwable
{
	this.ClickNewBranch.click();
	this.EnterBranch.sendKeys(branchname);
	this.EnterAddress1.sendKeys(Address1);
	this.EnterAddress3.sendKeys(Address3);
	this.EnterArea.sendKeys(Area);
	this.EnterZipcode.sendKeys(Zipcode);
	new Select(this.SelectCountry).selectByVisibleText(Country);
	new Select(this.SelectState).selectByVisibleText(State);
	new Select(this.SelectCity).selectByVisibleText(City);
	this.ClickSubmit.click();
	Thread.sleep(5000);
	String ExpectedAlert = driver.switchTo().alert().getText();
	Thread.sleep(5000);
	driver.switchTo().alert().accept();
	String ActualAlert = "New Branch with id";
	if(ExpectedAlert.toLowerCase().contains(ActualAlert.toLowerCase()))
	{
		Reporter.log("New Branch Creation Successfull::"+ExpectedAlert,true);
		return true;
	}
	else
	{
		Reporter.log("Unable to create New Branch::"+ExpectedAlert,true);
		return false;
	}
	
	}
}
