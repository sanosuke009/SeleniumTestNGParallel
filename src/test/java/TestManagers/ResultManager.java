package TestManagers;

import java.io.File;

import org.testng.ITestResult;
import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.TimeStampUtils;

public class ResultManager {
	
	//===================================Variable========================================
	
	public  ExtentReports extent;
	public  ExtentTest logger;
	public  ConfigManager con;
	
	//===================================================================================
	
	public ResultManager(ConfigManager con)
	{
		this.con = con;
		setExtentReport();
	}

	public void setExtentReport()
	{
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		
		extent = new ExtentReports (System.getProperty("user.dir") 
				+con.configGet("extentreportdirectoryname")+
				TimeStampUtils.getISTReportDay()+"/"+con.configGet("extentreportname"), false);
		//extent.addSystemInfo("Environment","Environment Name")
		extent
		.addSystemInfo("Host Name", con.configGet("hostname"))
		.addSystemInfo("Environment", con.configGet("environment"))
		.addSystemInfo("User Name", con.configGet("extentusername"));
		//loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		//You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\"+con.configGet("extentconfigname")));

	}
	
	public void terminateExtentReport()
	{
		// writing everything to document
				//flush() - to write or update test information to your report. 
						extent.flush();
		                //Call close() at the very end of your session to clear all resources. 
		                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
		                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
		                //Once this method is called, calling any Extent method will throw an error.
		                //close() - To close all the operation
						extent.close();

	}

	public void startextent(String testname, String testdesc)
	{
		logger = extent.startTest(testname, testdesc);
	}
	public void endextent(ITestResult result)
	{
		if(result.getStatus() == ITestResult.SUCCESS){
			report(LogStatus.PASS, "Test Case Passed is "+result.getName());
		}else if(result.getStatus() == ITestResult.SKIP){
			report(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		else //if(result.getStatus() == ITestResult.FAILURE)
			{
			report(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			report(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}

	public boolean report(String s)
	{
		boolean res =false;
		LogStatus logstatus;
		try {
			if(s.contains("which is expected")) { logstatus = LogStatus.PASS;}
			else if(s.contains(" NOT ")||s.contains(" not ")) { logstatus = LogStatus.FAIL;}
			else if(s.contains("Error")){logstatus = LogStatus.ERROR;}
			else {logstatus = LogStatus.PASS;}
			Reporter.log(s);
			System.out.println(s);
			logger.log(logstatus, s);
		}
		catch(Exception e)
		{
			System.out.println("Error Logging Report for "+s);
		}
		return res;
	}
	
	public boolean report(LogStatus logstatus, String s)
	{
		boolean res =false;
		try {
			Reporter.log(s);
			System.out.println(s);
			logger.log(logstatus, s);
		}
		catch(Exception e)
		{
			System.out.println("Error Logging Report for "+s);
		}
		return res;
	}
}
