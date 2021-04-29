package TestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methods.DatePickerMethods;
import Methods.LandingMethods;
import TestBases.BaseC;

public class TestSuite_006_DatePicking {

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
	public void testMethod_8()
	{
		String keyword = "kw_bootStrapDate";//This will be unique for each test case @Test
		//=====Mandatory in every @Test============
		base.setKeyWord(keyword);
		base.startextent();//This line initializes the extent report for this particular test method
		//=========================================
		base.Assert(LandingMethods.openLandingPage(base));
		LandingMethods.clickOnPopUp(base);
		base.Assert(LandingMethods.pickOption(base, base.get("FirstOption"), base.get("SecondOption")));
		base.Assert(DatePickerMethods.pickDateBootStrapSingle(base, base.get("Date")));
		//=====Mandatory at the end of all tests===
		base.AssertAll();
		//=========================================
	}

}
