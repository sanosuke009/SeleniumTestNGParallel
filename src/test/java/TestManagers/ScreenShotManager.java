package TestManagers;

import java.io.File;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.TimeStampUtils;

public class ScreenShotManager {
	
	public WebDriver driver;
	public ConfigManager con;
	public ResultManager rm;
	
	public ScreenShotManager(WebDriver driver, ConfigManager con, ResultManager rm)
	{
		this.driver = driver;
		this.con = con;
		this.rm = rm;
	}
	
		public boolean takeScreenShot_Old()
		{
			boolean res =false;
			try {
			String screenshotname = "Screen_"+TimeStampUtils.getIST();
			String screenshotpath = System.getProperty("user.dir")+"/"+con.configGet("screenshotpath");
			File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			res = sc.renameTo(new File(screenshotpath,String.format("%s.png", screenshotname)));
			}
			catch(Exception e)
			{
				rm.report("Error taking screenshot");
			}
			return res;
		}
		
		public boolean takeScreenShot()
		{
			boolean res =false;
			String Base64StringofScreenshot="";
			try {
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    byte[] fileContent = FileUtils.readFileToByteArray(src);
			    Base64StringofScreenshot = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);
			    String details = rm.logger.addBase64ScreenShot(Base64StringofScreenshot);
			    rm.logger.log(LogStatus.INFO, details);
			}
			catch(Exception e)
			{
				rm.report("Error taking screenshot");
			}
			return res;
		}
		
		public boolean report(LogStatus status, String TestDescription){
		    String Base64StringofScreenshot="";
		    boolean res = true;
		    try {
		    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    byte[] fileContent = FileUtils.readFileToByteArray(src);
		    Base64StringofScreenshot = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);
		    rm.logger.addBase64ScreenShot(Base64StringofScreenshot);
		    rm.logger.log(status, TestDescription+"\n"+rm.logger.addBase64ScreenShot(Base64StringofScreenshot));
		    }
		    catch(Exception e) {
		    	rm.report("Error taking screenshot");
		    	res = false;
		    }
		    return res;
		}
		
		public boolean takeScreenShotSureFire()
		{
			boolean res =false;
			try {
				String src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
				String path = "<img src=\"data:image/png;base64, " + src + "\" width=\"300\" height=\"350\" />";
				Reporter.log(path);
			}
			catch(Exception e)
			{
				rm.report("Error taking screenshot");
			}
			return res;
		}
		
		
}
