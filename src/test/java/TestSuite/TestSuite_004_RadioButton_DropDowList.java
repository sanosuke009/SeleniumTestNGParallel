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
import Methods.RadioButtonAndDropDownListMethods;
import TestBases.BaseC;
import TestManagers.BaseClassManager;
import TestManagers.ConfigManager;
import TestManagers.ResultManager;
import TestManagers.TestDataManager;
import TestManagers.WebDriverManager;

public class TestSuite_004_RadioButton_DropDowList {
	
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
	public void testMethod_5()
	{
		String keyword = "kw_ddlist";
		base.startextent(keyword);
		Assert.assertTrue(LandingMethods.openLandingPage(base));
		LandingMethods.clickOnPopUp(base);
		Assert.assertTrue(LandingMethods.clickOnOptionFromList
				(base, base.get(keyword,"OptionFromList")));
		Assert.assertTrue(RadioButtonAndDropDownListMethods.validateSingleDropDownList
				(base, base.get(keyword,"FirstOption"), base.get(keyword,"SecondOption")));
	}

}
