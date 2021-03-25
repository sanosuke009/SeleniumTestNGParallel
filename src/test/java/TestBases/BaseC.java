package TestBases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

import TestManagers.ConfigManager;
import TestManagers.ResultManager;
import TestManagers.ScreenShotManager;
import TestManagers.TestDataManager;
import TestManagers.WebDriverManager;

public class BaseC{
	
	//============================Variables==========================================
	public  String testKeyword;
	public  String testName;
	public  ConfigManager con;
	public  ResultManager rm;
	public  ScreenShotManager sm;
	public TestDataManager tm;
	public WebDriverManager wm;
	//===============================================================================
	
	//=========================Constructors==========================================
	
	public BaseC()
	{
		setConfig();
		setExtent();
		setTestData();
	}
	
	//==================Advance Setter Method======================================
	public void setConfig()
	{
		this.con = new ConfigManager();
	}
	public void setWebDriver()
	{
		this.wm = new WebDriverManager(con);
	}
	public void setExtent()
	{
		this.rm = new ResultManager(con);
	}
	public void setScreenShot()
	{
		this.sm = new ScreenShotManager(wm.driver, con, rm);
	}
	public void setTestData()
	{
		this.tm = new TestDataManager(con, rm);
	}
	
	
	//=============================================================================
	
	//==================Advance Getter Method======================================
		public String getConfig(String key)
		{
			return this.con.configGet(key);
		}
		
		public boolean launchBrowser()
		{
			return this.wm.launchBrowser();
		}
		
		public boolean launchBrowser(String url)
		{
			return this.wm.launchBrowser(url);
		}
		
		public void closeBrowserTab()
		{
			this.wm.closeBrowserTab();
		}
		
		public void quitBrowser()
		{
			this.wm.quitBrowser();
		}

		public void terminateExtentReport()
		{
			this.rm.terminateExtentReport();
		}

		public void startextent(String testname, String testdesc)
		{
			this.rm.startextent(testname, testdesc);
		}
		public void endextent(ITestResult result)
		{
			this.rm.endextent(result);
		}

		public boolean report(String s)
		{
			return this.rm.report(s);
		}
		
		public boolean report(LogStatus logstatus, String s)
		{
			return this.rm.report(logstatus, s);
		}
		public boolean takeScreenShot()
		{
			return this.sm.takeScreenShot();
		}
		
		public boolean takeScreenShot(LogStatus status, String TestDescription){
		    return this.sm.report(status, TestDescription);
		}
		public String get(String keyword, String columnname)
		{
			return this.tm.get(keyword, columnname);
		}
		
		
		//=============================================================================
		
		//=============================Start & End Session Methods=============================
		public void startSession()
		{
			this.setWebDriver();
			this.launchBrowser();
			this.setScreenShot();
		}
		public void endSession(ITestResult result)
		{
			this.endextent(result);
			this.quitBrowser();
		}
		//=============================================================================
		
		public WebDriver driver()
		{
			return this.wm.driver;
		}
		public WebDriverWait Wait()
		{
			return this.wm.wait;
		}
	

}
