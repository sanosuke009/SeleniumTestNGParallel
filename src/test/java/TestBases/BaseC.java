package TestBases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

import TestManagers.CleanUpManager;
import TestManagers.ConfigManager;
import TestManagers.ResultManager;
import TestManagers.ScreenShotManager;
import TestManagers.TempFileManager;
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
	public TempFileManager tmp;
	public CleanUpManager cln;
	private boolean isTempManagementRequired = false;
	public boolean highlight = false;
	private boolean cleanup = false;
	//===============================================================================
	
	//=========================Constructors==========================================
	
	/*This constructor calls 8 methods in a particular sequence: 
	 *  1. setConfig();
	    2. setExtent();
		3. setTestData();
		4. setTempRequirement();
		5. setTempFile();
		6. setHighlightRequirement();
		7. setCleanUpRequirement();
		8. setCleanUpmanager();
	 * 
	 */
	public BaseC()
	{
		setConfig();
		setExtent();
		setTestData();
		setTempRequirement();
		setTempFile();
		setHighlightRequirement();
		setCleanUpRequirement();
		setCleanUpmanager();
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
	public void setTempRequirement()
	{
		isTempManagementRequired = con.configGet("isTempManagementRequired").equalsIgnoreCase("true")?true:false;
	}
	public void setTempFile()
	{
		if(isTempManagementRequired) this.tmp = new TempFileManager(con);
	}
	public void setHighlightRequirement()
	{
		highlight = con.configGet("highlight").equalsIgnoreCase("true")?true:false;
	}
	public void setCleanUpRequirement()
	{
		cleanup = con.configGet("cleanup").equalsIgnoreCase("true")?true:false;
	}
	public void setCleanUpmanager()
	{
		if(cleanup) this.cln = new CleanUpManager(con);
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

		public void startextent(String keyword)
		{
			this.rm.startextent(this.get(keyword,"TestName"), this.get(keyword,"TestDescription"));
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
			if(isTempManagementRequired) {this.initTemp();}
			this.setWebDriver();
			this.launchBrowser();
			this.setScreenShot();
		}
		public void endSession(ITestResult result)
		{
			this.endextent(result);
			this.quitBrowser();
			if(isTempManagementRequired) {this.deleteTemp();}
		}
		//=============================================================================
		
		//=======================Temp File manging Methods=============================
		public void initTemp()
		{
			this.tmp.initTemp();
		}
		
		public void deleteTemp()
		{
			this.tmp.deleteTemp();
		}
		
		public void cleanup()
		{
			this.cln.cleanupdrivers();
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
		//=======================Deconstructors===========================================
		public void destruct()
		{
			//this.terminateExtentReport();
			if(this.cleanup) {this.cleanup();}
		}
	

}
