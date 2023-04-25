package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PBEmployee {
	@FindBy(xpath ="(//img)[8]")
	WebElement clickEmployee;
	public void EmployeeClick()
	{
		clickEmployee.click();
	}

}
