package TestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methods.AlertHandleMethods;
import TestBases.BaseC;

public class TestSuite_005_HandlingAlerts {

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
		base.startSession("https://www.selenium.dev/documentation/en/webdriver/js_alerts_prompts_and_confirmations/");
	}

	@AfterMethod
	public void getResult(ITestResult result){
		base.endSession(result);
	}

	@Test
	public void testMethod_5()
	{
		String keyword = "kw_alerts";//This will be unique for each test case @Test
		//=====Mandatory in every @Test============
		base.setKeyWord(keyword);
		base.startextent();//This line initializes the extent report for this particular test method
		//=========================================
		base.Assert(AlertHandleMethods.validateAlert(base, base.get("AlertAction")));
		//=====Mandatory at the end of all tests===
		base.AssertAll();
		//=========================================
	}

	@Test
	public void testMethod_6()
	{

		String keyword = "kw_confirm";//This will be unique for each test case @Test
		//=====Mandatory in every @Test============
		base.setKeyWord(keyword);
		base.startextent();//This line initializes the extent report for this particular test method
		//=========================================
		base.Assert(AlertHandleMethods.validateConfirmation(base, base.get("AlertAction")));
		//=====Mandatory at the end of all tests===
		base.AssertAll();
		//=========================================
	}

	@Test
	public void testMethod_7()
	{
		String keyword = "kw_prompt";//This will be unique for each test case @Test
		//=====Mandatory in every @Test============
		base.setKeyWord(keyword);
		base.startextent();//This line initializes the extent report for this particular test method
		//=========================================
		base.Assert(AlertHandleMethods.validatePrompt(base, base.get("AlertAction"), base.get("FirstOption")));
		//=====Mandatory at the end of all tests===
		base.AssertAll();
		//=========================================
	}

}
