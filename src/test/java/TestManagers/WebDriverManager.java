package TestManagers;



import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {

	public  WebDriver driver;
	public  WebDriverWait wait;
	public  ConfigManager cm;
	public  Wait<WebDriver> fwait;

	public WebDriverManager(ConfigManager cm)
	{
		this.cm = cm;
	}

	public boolean initiateBrowser()
	{
		boolean res = false;
		try {
			//==============Initiating ChromeOptions==================
			ChromeOptions options = new ChromeOptions();
			//options.setPageLoadStrategy(PageLoadStrategy.NONE); //Only wait till the basic HTML page loading
			//options.setPageLoadStrategy(PageLoadStrategy.EAGER);//Wait till all the basic images, not the stylesheets
			//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			if(cm.configGet("proxyon").contains("Y"))
			{
				Proxy proxy = new Proxy();
				proxy.setHttpProxy(cm.configGet("proxy"));
				options.setCapability("proxy", proxy);
			}
			//options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			Map<String, Object> prefs = new HashMap<String, Object>();
			//prefs.put("profile.default_content_setting_values.notifications", 2);
			//prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.prompt_for_download", "false");
			//prefs.put("download.", "false");
			prefs.put("download.default_directory", System.getProperty("user.dir")+"\\"+cm.configGet("downloadpath"));
			options.setExperimentalOption("prefs", prefs);
			//options.setExperimentalOption("useAutomationExtension", false);//Deprecated
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//options.addArguments("start-maximized");
			//options.addArguments("-headless");
			//========================================================
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+cm.configGet("chromedriverpath"));
			if(cm.configGet("remote").contains("Y"))
			{
				options.setCapability("browserVersion", "90");
				options.setCapability("platformName", "Windows 10");
				driver = new RemoteWebDriver(new URL("http://www.myexamplebrowserstack.com"), options);
			}
			else
			{
				driver = new ChromeDriver(options);
			}
			//driver = ThreadGuard.protect(new ChromeDriver(options));//Thread guard protects the ownership of the webdriver.
			System.out.println("Initiated webdriver.");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(cm.configGet("implicitwait"))));
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.valueOf(cm.configGet("explicitwait"))));
			fwait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Integer.valueOf(cm.configGet("fluentwaitTimeout"))))
					.pollingEvery(Duration.ofSeconds(Integer.valueOf(cm.configGet("fluentwaitPolling"))))
					.ignoring(NoSuchElementException.class)
					.withMessage("Waiting for 10 seconds polling every 2 seconds.");
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
