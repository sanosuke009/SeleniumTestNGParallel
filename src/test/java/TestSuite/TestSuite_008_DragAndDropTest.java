package TestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methods.DragAndDropMethods;
import Methods.LandingMethods;
import TestBases.BaseC;

public class TestSuite_008_DragAndDropTest {

	BaseC base;

	@BeforeClass
	public void initReport(){base = new BaseC();}

	@AfterClass
	public void exitReport(){base.terminateExtentReport();}

	@BeforeMethod
	public void setUp(){base.startSession();}

	@AfterMethod
	public void getResult(ITestResult result){base.endSession(result);}

	@Test
	public void testMethod_11()
	{
		String keyword = "kw_draganddrop";//This will be unique for each test case @Test
		//=====Mandatory in every @Test============
		base.setKeyWord(keyword);//This line initializes the keyword and extent report for this particular test method
		//=========================================
		base.Assert(LandingMethods.openLandingPage(base));
		LandingMethods.clickOnPopUp(base);
		base.Assert(LandingMethods.pickOption(base, base.get("FirstOption"), base.get("SecondOption")));
		base.Assert(DragAndDropMethods.dragAndDropElements(base));
		//=====Mandatory at the end of all tests===
		base.AssertAll();
		//=========================================
	}

}
