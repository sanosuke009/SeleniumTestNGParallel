package TestSuite;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Methods.LandingMethods;
import TestBases.BaseC;
import TestManagers.BaseClassManager;
import TestManagers.ConfigManager;
import TestManagers.ResultManager;
import TestManagers.TestDataManager;
import TestManagers.WebDriverManager;

public class TestSuite_001_InputFields {
	
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
	public void testMethod()
	{
		String keyword = "kw_addtwonums";
		base.startextent(base.get(keyword,"TestName"), base.get(keyword,"TestDescription"));
		Assert.assertTrue(LandingMethods.openLandingPage(base));
		LandingMethods.clickOnPopUp(base);
		Assert.assertTrue(LandingMethods.validateAddTwoNumbersForm
				(base, base.get(keyword,"FirstNumber"), base.get(keyword,"SecondNumber")));
	}

}
