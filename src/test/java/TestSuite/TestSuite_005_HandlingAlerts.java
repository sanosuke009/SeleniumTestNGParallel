package TestSuite;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methods.AlertHandleMethods;
import Methods.LandingMethods;
import Methods.RadioButtonAndDropDownListMethods;
import TestBases.BaseC;

public class TestSuite_005_HandlingAlerts {
	
	BaseC base;
	Assert assertion;
	
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
		//=====Mandatory in every @Test============
		String keyword = "kw_alerts";//This will be unique for each test case @Test
		base.startextent(keyword);//This line initializes the extent report for this particular test method
		//=========================================
		base.Assert(AlertHandleMethods.validateAlert(base, base.get(keyword, "AlertAction")));
		base.AssertAll();
	}
	
	@Test
	public void testMethod_6()
	{
		//=====Mandatory in every @Test============
		String keyword = "kw_confirm";//This will be unique for each test case @Test
		base.startextent(keyword);//This line initializes the extent report for this particular test method
		//=========================================
		base.Assert(AlertHandleMethods.validateConfirmation(base, base.get(keyword, "AlertAction")));
		base.AssertAll();
	}
	
	@Test
	public void testMethod_7()
	{
		//=====Mandatory in every @Test============
		String keyword = "kw_prompt";//This will be unique for each test case @Test
		base.startextent(keyword);//This line initializes the extent report for this particular test method
		//=========================================
		base.Assert(AlertHandleMethods.validatePrompt(base, base.get(keyword, "AlertAction"), base.get(keyword, "FirstOption")));
		base.AssertAll();
	}

}
