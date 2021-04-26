package TestManagers;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionManager {
	
	private boolean hardAssert = false;
	public SoftAssert ass;
	
	public AssertionManager(ConfigManager con)
	{
		hardAssert = con.configGet("hardassert").equalsIgnoreCase("Y")?true:false;
		if(!hardAssert)
		{
			ass = new SoftAssert();
		}
	}
	
	public void Assert(boolean res)
	{
		if(hardAssert)
		{
			Assert.assertTrue(res);
		}
		else
		{
			ass.assertTrue(res);
		}
	}
	
	public void AssertAll()
	{
		ass.assertAll();
	}

}
