package ElementActions;

import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import TestBases.BaseC;
import io.netty.handler.timeout.TimeoutException;

public class elementActions {
	
	public static boolean waitFor(BaseC b, long timeinmillis)
	{
		boolean res = true;
		try {
			Thread.sleep(timeinmillis);
		}
		catch(IllegalArgumentException e)
		{
			b.report("Invalid argument. Wait time should be in long(milliseconds).");
			res =false;
		}
		catch(InterruptedException e)
		{
			b.report("The wait was interrupted.");
			res =false;
		}
		return res;
	}
	
	public static boolean waitUntilClickable(BaseC b, By locator)
	{
		boolean res = true;
		try {
			b.Wait().until(ExpectedConditions.elementToBeClickable(locator));
		}
		catch(TimeoutException e)
		{
			b.report("The element "+locator+" not clickable.");
			res =false;
		}
		return res;
	}
	
	public static boolean actionOnAlert(BaseC b, String action)
	{
		boolean res = true;
		try {
			Alert alert = b.Wait().until(ExpectedConditions.alertIsPresent());
			//b.takeScreenShot();
			b.report("The alert report text is displayed as "+alert.getText());
			if(action.equalsIgnoreCase("accept"))
			{
				alert.accept();
				b.report("The alert was accepted.");
			}
			else
			{
				alert.dismiss();
				b.report("The alert was dismissed.");
			}
			b.takeScreenShot();
		}
		catch(TimeoutException e)
		{
			b.report("The Alert is not visible.");
			res =false;
		}
		return res;
	}
	
	public static boolean actionOnAlert(BaseC b, String action, String text)
	{
		boolean res = true;
		try {
			Alert alert = b.Wait().until(ExpectedConditions.alertIsPresent());
			//b.takeScreenShot();
			//b.takeScreenShot(LogStatus.INFO, "The alert report test is displayed as "+alert.getText());
			b.report("The alert report text is displayed as "+alert.getText());
			alert.sendKeys(text);
			//b.takeScreenShot(LogStatus.INFO, "The test "+text+" has been given as input to the alert.");
			//b.takeScreenShot();
			b.report("The text "+text+" has been given as input to the alert.");
			if(action.equalsIgnoreCase("accept"))
			{
				alert.accept();
				b.report("The alert was accepted.");
			}
			else
			{
				alert.dismiss();
				b.report("The alert was dismissed.");
			}
			b.takeScreenShot();
		}
		catch(TimeoutException e)
		{
			b.report("The Alert is not visible.");
			res =false;
		}
		return res;
	}
	
	public static boolean waitUntilClickableFluent(BaseC b, By locator)
	{
		boolean res = true;
		try {
			b.FWait().until(ExpectedConditions.elementToBeClickable(locator));
		}
		catch(TimeoutException e)
		{
			b.report("The element "+locator+" not clickable.");
			res =false;
		}
		return res;
	}
	
	public static boolean sendKeys(BaseC b, By locator, String keysToSend)
	{
		boolean res = true;
		try {
			b.driver().findElement(locator).clear();
			b.driver().findElement(locator).sendKeys(keysToSend);
		}
		catch(TimeoutException e)
		{
			b.report("The STring "+keysToSend+" was not given as input in element "+locator);
			res =false;
		}
		return res;
	}
	
	public static boolean click(BaseC b, By locator)
	{
		boolean res = true;
		try {
			b.driver().findElement(locator).click();
			//ResultManager.report("The element "+locator+" is clicked.");
		}
		catch(NoSuchElementException e)
		{
			b.report("The element "+locator+" was not clicked.");
			res =false;
		}
		return res;
	}
	
	public static boolean isDisplayed(BaseC b, By locator)
	{
		boolean res = true;
		try {
			res = b.driver().findElements(locator).size() == 1;
		}
		catch(Exception e)
		{
			b.report("The element "+locator+" was not displayed.");
			res =false;
		}
		return res;
	}
	
	public static boolean areDisplayed(BaseC b, By locator)
	{
		boolean res = true;
		try {
			res = b.driver().findElements(locator).size() > 0;
		}
		catch(Exception e)
		{
			b.report("The element(s) "+locator+" was(were) not displayed.");
			res =false;
		}
		return res;
	}
	
	public static boolean scrollToElement(BaseC b, By locator)
	{
		boolean res = true;
		try {
			JavascriptExecutor js = (JavascriptExecutor)b.driver();
			WebElement element = b.driver().findElement(locator);
			js.executeScript("arguments[0].scrollIntoView();", element);
		}
		catch(Exception e)
		{
			b.report("The page was not scrolled to element : "+locator+".");
			res =false;
		}
		return res;
	}
	
	public static boolean scrollElementToMiddle(BaseC b, By locator)
	{
		boolean res = true;
		try {
			JavascriptExecutor js = (JavascriptExecutor)b.driver();
			WebElement element = b.driver().findElement(locator);
			js.executeScript("arguments[0].scrollIntoView"
					+ "({behavior: \"smooth\", block: \"center\", inline: \"nearest\"})", element);
		}
		catch(Exception e)
		{
			b.report("The page was not scrolled to element : "+locator+".");
			e.printStackTrace();
			res =false;
		}
		return res;
	}
	
	public static String getText(BaseC b, By locator)
	{
		String name = "";
		try {
			name = b.driver().findElement(locator).getText();
		}
		catch(Exception e)
		{
			b.report("Error occurred during getting the text from element : "+locator+".");
		}
		return name;
	}
	
	public static List<String> getTextOfAllSimilarElements(BaseC b, By locator)
	{
		List<String> names = new ArrayList<String>();
		List<WebElement> elms = new ArrayList<WebElement>();
		try {
			elms = b.driver().findElements(locator);
			for(WebElement elm : elms)
			{
				names.add(elm.getText());
			}
		}
		catch(Exception e)
		{
			b.report("Error occurred during getting the texts from element : "+locator+".");
		}
		return names;
	}
	
	public static boolean selectDropDownList(BaseC b, By locator, String value)
	{
		boolean res = true;
		try {
			WebElement element = b.driver().findElement(locator);
			Select select = new Select(element);
			select.selectByValue(value);
		}
		catch(TimeoutException e)
		{
			b.report("The option "+value+" was not selected from Drop Down List element "+locator);
			res =false;
		}
		return res;
	}
	
	public static boolean selectDropDownListMultiple(BaseC b, By locator, String values)
	{
		boolean res = true;
		try {
			String[] value = values.split("#");
			WebElement element = b.driver().findElement(locator);
			Select select = new Select(element);
			for(String val : value)
				{select.selectByValue(val);}
		}
		catch(TimeoutException e)
		{
			b.report("Error occurred during selection of options from Multi Drop Down List element "+locator);
			res =false;
		}
		return res;
	}
	
	public static boolean highlightElement(BaseC b, By locator)
	{
		boolean res = true;
		try {
			if(b.highlight) {
			JavascriptExecutor js = (JavascriptExecutor)b.driver();
			WebElement element = b.driver().findElement(locator);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			}
		}
		catch(Exception e)
		{
			b.report("Error occurred during high lighting element : "+locator+".");
			res =false;
		}
		return res;
	}
	
	public static boolean lowlightElement(BaseC b, By locator)
	{
		boolean res = true;
		try {
			if(b.highlight) {
			JavascriptExecutor js = (JavascriptExecutor)b.driver();
			WebElement element = b.driver().findElement(locator);
			js.executeScript("arguments[0].style.border=''",element, "");
			}
		}
		catch(Exception e)
		{
			b.report("Error occurred during low lighting element : "+locator+".");
			res =false;
		}
		return res;
	}
	public static boolean takeScreenShot(BaseC b, By locator)
	{
		boolean res = true;String Base64StringofScreenshot="";
		try {
			WebElement element = b.driver().findElement(locator);
			File src = element.getScreenshotAs(OutputType.FILE);
		    byte[] fileContent = FileUtils.readFileToByteArray(src);
		    Base64StringofScreenshot = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);
		    String details = b.rm.logger.addBase64ScreenShot(Base64StringofScreenshot);
		    b.rm.logger.log(LogStatus.INFO, details);
		}
		catch(Exception e)
		{
			b.report("Error occurred during taking screenshot of element : "+locator+".");
			res =false;
		}
		return res;
	}

}
