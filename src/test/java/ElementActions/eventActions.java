package ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class eventActions {
	
	public static boolean logEvent(WebDriver driver, By locator)
	{
		boolean res = true;
		try {
			//HasLogEvents logger = (HasLogEvents) driver;

			//AtomicReference<DomMutationEvent> seen = new AtomicReference<>();
			//CountDownLatch latch = new CountDownLatch(1);
			//logger.onLogEvent(domMutation(mutation -> {
			    //seen.set(mutation);
			    //latch.countDown();
			//}));
		}
		catch(Exception e)
		{
			//ResultManager.report("The element(s) "+locator+" was(were) not displayed.");
			res =false;
		}
		return res;
	}
	
	public static void main(String[] args)
	{
		System.out.println("ABBC");
	}

}
