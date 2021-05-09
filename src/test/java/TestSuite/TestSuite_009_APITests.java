package TestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import APIUtilities.APIMethods;
import TestBases.BaseC;

public class TestSuite_009_APITests {

	BaseC base;

	@BeforeClass
	public void initReport(){base = new BaseC();}

	@AfterClass
	public void exitReport(){base.terminateExtentReport();}

	@BeforeMethod
	public void setUp(){base.startSessionAPI();}

	@AfterMethod
	public void getResult(ITestResult result){base.endSessionAPI(result);}

	@Test
	public void testMethod_12()
	{
		String keyword = "kw_apiget";//This will be unique for each test case @Test
		//=====Mandatory in every @Test============
		base.setKeyWord(keyword);//This line initializes the keyword and extent report for this particular test method
		//=========================================
		base.Assert(APIMethods.validateGet(base));
		//=====Mandatory at the end of all tests===
		base.AssertAll();
		//=========================================
	}

}
