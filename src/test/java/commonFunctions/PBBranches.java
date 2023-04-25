package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PBBranches {
@FindBy(xpath = "//a[@href='admin_banker_master.aspx']//img")
WebElement clickbranches;
public void BranchesClick()
{
	clickbranches.click();
}


}
