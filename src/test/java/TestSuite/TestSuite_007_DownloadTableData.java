package TestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methods.LandingMethods;
import Methods.WebTableMethods;
import TestBases.BaseC;

public class TestSuite_007_DownloadTableData {

	BaseC base;

	@BeforeClass
	public void initReport()
	{
		base = new BaseC();
	}

	@AfterClass
	public void exitReport()
	{
		base.terminateExtentReport();
	}

	@BeforeMethod
	public void setUp()
	{
		base.startSession();
	}

	@AfterMethod
	public void getResult(ITestResult result){
		base.endSession(result);
	}

	@Test
	public void testMethod_9()
	{
		String keyword = "kw_downloadtabledata";//This will be unique for each test case @Test
		//=====Mandatory in every @Test============
		base.setKeyWord(keyword);
		//=========================================
		base.Assert(LandingMethods.openLandingPage(base));
		LandingMethods.clickOnPopUp(base);
		base.Assert(LandingMethods.pickOption(base, base.get("FirstOption"), base.get("SecondOption")));
		base.Assert(WebTableMethods.downloadTableData(base, base.get("AlertAction"), 
				base.get("FileNames"), base.get("Attribute")));
		//=====Mandatory at the end of all tests===
		base.AssertAll();
		//=========================================
	}
	
	@Test//(enabled = false)
	public void testMethod_10()
	{
		String keyword = "kw_fetchtabledata";//This will be unique for each test case @Test
		//=====Mandatory in every @Test============
		base.setKeyWord(keyword);
		//=========================================
		base.Assert(LandingMethods.openLandingPage(base));
		LandingMethods.clickOnPopUp(base);
		base.Assert(LandingMethods.pickOption(base, base.get("FirstOption"), base.get("SecondOption")));
		base.Assert(WebTableMethods.fetchTableData(base, base.get("AlertAction"), base.get("FileNames")));
		//=====Mandatory at the end of all tests===
		base.AssertAll();
		//=========================================
	}

}
