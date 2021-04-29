package TestManagers;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionManager {
	
	public boolean hardAssert = false;
	public SoftAssert ass;
	
	public AssertionManager(TestDataManager tm, String keyword)
	{
		hardAssert = tm.get(keyword, "HardAssert").equalsIgnoreCase("Y")?true:false;
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
