package Methods;

import org.openqa.selenium.Keys;

import ElementActions.elementActions;
import Objects.BootStrapDatePickerPage;
import TestBases.BaseC;

public class DatePickerMethods {
	
	public static boolean pickDateBootStrapSingle(BaseC b, String option)
	{
		boolean res = true;
		if(res) res = elementActions.waitUntilClickableFluent(b, BootStrapDatePickerPage.elmXPDatePickerPageHeader);
		if(res) res = elementActions.isDisplayed(b, BootStrapDatePickerPage.elmXPDatePickerPageHeader);
		if(res) b.report("The Bootstrap Date Picker Page has been displayed.");
		else b.report("The Bootstrap Date Picker Page has NOT been displayed.");
		if(res) res = elementActions.highlightElement(b, BootStrapDatePickerPage.elmXPDatePickerPageHeader);
		b.takeScreenShot();
		if(res) res = elementActions.scrollElementToMiddle(b, BootStrapDatePickerPage.elmXPDatePickerSingle);
		if(res) res = elementActions.highlightElement(b, BootStrapDatePickerPage.elmXPDatePickerSingle);
		b.takeScreenShot();
		if(res) res = elementActions.sendKeysUsingClipboard(b, BootStrapDatePickerPage.elmXPDatePickerSingle, option);
		if(res) res = elementActions.sendKeys(b, BootStrapDatePickerPage.elmXPDatePickerSingle, Keys.ENTER);
		if(res) b.report("The date "+option+" is entered in the DatePicker Field.");
		else b.report("The date "+option+" is NOT entered in the DatePicker Field.");
		b.takeScreenShot();
		return res;
	}
}
