package driverFactory;
//what ever methods and variables in parent(AppUtil) class will extend to child(DriverScript) class

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.PBBranchCreation;
import commonFunctions.PBBranchUpdation;
import commonFunctions.PBBranches;
import commonFunctions.PBEmployee;
import commonFunctions.PBEmployeeCreation;
import commonFunctions.PBEmployeeUpdation;
import commonFunctions.PBLogin;
import commonFunctions.PBLogout;
import commonFunctions.PBRoleCreation;
import commonFunctions.PBRoleUpdation;
import commonFunctions.PBRoles;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil {
	String inputpath = "./FileInput/DataEngine.xlsx";
	String outputpath = "./FileOutput/PBResults.xlsx";
	String tcsheet = "TestCases";
	String tssheet = "TestSteps";
	@Test
	public void startTest() throws Throwable
	{
		boolean res = false;
		//tcres means test case results
		String tcres = "";
		//create reference object for excel file util class
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int TCCount = xl.rowCount(tcsheet);
		int TSCount = xl.rowCount(tssheet);
		Reporter.log("No of rows in TCSheet::"+TCCount+"     "+"No of rows in TSSheet::"+TSCount);
		//iterate all rows in TCSheet
		for(int i=1; i<=TCCount; i++)
		{
			String ExecutionStatus = xl.getCellData(tcsheet, i, 2);
			if(ExecutionStatus.equalsIgnoreCase("Y"))
			{
				//read TCID cell data
				String TCID = xl.getCellData(tcsheet, i, 0);
				//iterate all rows in TSSheet
				for(int j=1;j<=TSCount;j++)
				{
					//read TSID from TSSheet
					String TSID = xl.getCellData(tssheet, j, 0);
					if(TCID.equalsIgnoreCase(TSID))
					{
						String Keyword = xl.getCellData(tssheet, j, 3);
						if(Keyword.equalsIgnoreCase("adminLogin"))
						{
							//call login page class
							PBLogin login = PageFactory.initElements(driver, PBLogin.class);
							String para1 = xl.getCellData(tssheet, j, 5);
							String para2 = xl.getCellData(tssheet, j, 6);
							res = login.verify_Login(para1, para2);
						}
						else if (Keyword.equalsIgnoreCase("branchCreate"))
						{
							//call branch button & branch creation page class
							PBBranches branch = PageFactory.initElements(driver, PBBranches.class);
							PBBranchCreation newbranch = PageFactory.initElements(driver, PBBranchCreation.class);
							String para1 = xl.getCellData(tssheet, j, 5);
							String para2 = xl.getCellData(tssheet, j, 6);
							String para3 = xl.getCellData(tssheet, j, 7);
							String para4 = xl.getCellData(tssheet, j, 8);
							String para5 = xl.getCellData(tssheet, j, 9);
							String para6 = xl.getCellData(tssheet, j, 10);
							String para7 = xl.getCellData(tssheet, j, 11);
							String para8 = xl.getCellData(tssheet, j, 12);
							String para9 = xl.getCellData(tssheet, j, 13);
							branch.BranchesClick();
							res = newbranch.verify_Branchcreate(para1, para2, para3, para4, para5, para6, para7, para8, para9);


						}
						else if(Keyword.equalsIgnoreCase("branchUpdate"))
						{
							PBBranches branch = PageFactory.initElements(driver, PBBranches.class);
							PBBranchUpdation branchupdate = PageFactory.initElements(driver, PBBranchUpdation.class);
							String para1 = xl.getCellData(tssheet, j, 5);
							String para2 = xl.getCellData(tssheet, j, 6);
							String para5 = xl.getCellData(tssheet, j, 9);
							String para6 = xl.getCellData(tssheet, j, 10);
							branch.BranchesClick();
							res = branchupdate.verfy_UpdateBranch(para1, para2, para5, para6);

						}
						else if (Keyword.equalsIgnoreCase("roleCreate")) 
						{
							PBRoles role = PageFactory.initElements(driver, PBRoles.class);
							PBRoleCreation rolecreation = PageFactory.initElements(driver, PBRoleCreation.class);
							String para1 = xl.getCellData(tssheet, j, 5);
							String para2 = xl.getCellData(tssheet, j, 6);
							String para3 = xl.getCellData(tssheet, j, 7);
							role.RolesClick();
							res = rolecreation.verify_RoleCreation(para1, para2, para3);
						}
						else if (Keyword.equalsIgnoreCase("roleUpdate")) 
						{
						PBRoles role = PageFactory.initElements(driver, PBRoles.class);
						PBRoleUpdation roleupdate = PageFactory.initElements(driver, PBRoleUpdation.class);
						String para1 = xl.getCellData(tssheet, j, 5);
						String para2 = xl.getCellData(tssheet, j, 6);
						String para3 = xl.getCellData(tssheet, j, 7);
						role.RolesClick();
						res = roleupdate.verify_RoleUpdation(para1, para2, para3);
						}
						else if (Keyword.equalsIgnoreCase("employeeCreate")) {
							PBEmployee employee = PageFactory.initElements(driver, PBEmployee.class);
							PBEmployeeCreation employeecreate = PageFactory.initElements(driver, PBEmployeeCreation.class);
							String para1 = xl.getCellData(tssheet, j, 5);
							String para2 = xl.getCellData(tssheet, j, 6);
							String para3 = xl.getCellData(tssheet, j, 7);
							String para4 = xl.getCellData(tssheet, j, 8);
							employee.EmployeeClick();
							res = employeecreate.verify_EmployeeCreation(para1, para2, para3, para4);
						}
						else if (Keyword.equalsIgnoreCase("employeeUpdate")) {
							PBEmployee employee = PageFactory.initElements(driver, PBEmployee.class);
							PBEmployeeUpdation employeeupdate = PageFactory.initElements(driver, PBEmployeeUpdation.class);
							String para1 = xl.getCellData(tssheet, j, 5);
							String para2 = xl.getCellData(tssheet, j, 6);
							String para3 = xl.getCellData(tssheet, j, 7);
							String para4 = xl.getCellData(tssheet, j, 8);
							employee.EmployeeClick();
							res = employeeupdate.verify_EmployeeUpdation(para1, para2, para3, para4);
						}
						else if(Keyword.equalsIgnoreCase("adminLogout"))
						{
							PBLogout logout = PageFactory.initElements(driver, PBLogout.class);
							res = logout.verify_Logout();
						}
						String tsres = "";
						if(res)
						{
							//if res is true, write as Pass in status cell in TSSheet
							tsres = "PASS";
							xl.setCellData(tssheet, j, 4, tsres, outputpath);
						}
						else
						{
							//if res is false, write as Pass in status cell in TSSheet
							tsres = "FAIL";
							xl.setCellData(tssheet, j, 4, tsres, outputpath);
						}
						tcres=tsres;

					}
					
				}
				//write as tcres in Test Case sheet
				xl.setCellData(tcsheet, i, 3, tcres, outputpath);

			}
			else
			{
				//write as blocked in TCSheet which flaged to N
				xl.setCellData(tcsheet, i, 3, "Blocked", outputpath);
			}

		}


	}


}
