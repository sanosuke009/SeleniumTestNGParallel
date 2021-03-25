package ElementActions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.events.DomMutationEvent;
import org.openqa.selenium.logging.HasLogEvents;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestManagers.ResultManager;
import io.netty.handler.timeout.TimeoutException;

public class eventActions {
	
	public static boolean logEvent(WebDriver driver, By locator)
	{
		boolean res = true;
		try {
			HasLogEvents logger = (HasLogEvents) driver;

			//AtomicReference<DomMutationEvent> seen = new AtomicReference<>();
			CountDownLatch latch = new CountDownLatch(1);
			////logger.onLogEvent(domMutation(mutation -> {
			   // seen.set(mutation);
			   // latch.countDown();
			//}));
		}
		catch(Exception e)
		{
			//ResultManager.report("The element(s) "+locator+" was(were) not displayed.");
			res =false;
		}
		return res;
	}

}
