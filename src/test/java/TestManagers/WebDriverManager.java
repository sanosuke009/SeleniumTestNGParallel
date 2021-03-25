package TestManagers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
	
	public  WebDriver driver;
	public  WebDriverWait wait;
	public  ConfigManager cm;
	
	public WebDriverManager(ConfigManager cm)
	{
		this.cm = cm;
	}
	
		@SuppressWarnings("deprecation")
		public boolean initiateBrowser()
		{
			boolean res = false;
			try {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+cm.configGet("chromedriverpath"));
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
				wait = new WebDriverWait(driver, 10);
				res = true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				res = false;
			}
				return res;
		}
		
		public boolean launchBrowser()
		{
			boolean res = false;
			try {
				initiateBrowser();
				driver.get(cm.configGet("url"));
				driver.manage().window().maximize();
				res = true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				res = false;
			}
				return res;
		}
		
		public boolean launchBrowser(String url)
		{
			boolean res = false;
			try {
				initiateBrowser();
				driver.get(url);
				driver.manage().window().maximize();
				res = true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				res = false;
			}
				return res;
		}
		
		public void closeBrowserTab()
		{
			driver.close();
		}
		
		public void quitBrowser()
		{
			driver.quit();
		}
}
