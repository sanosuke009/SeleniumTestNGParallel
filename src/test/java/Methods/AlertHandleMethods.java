package Methods;

import ElementActions.elementActions;
import Objects.AlertPage;
import TestBases.BaseC;

public class AlertHandleMethods {
	
	public static boolean validateAlert(BaseC b, String action)
	{
		boolean res = true;
		if(res) res = elementActions.waitUntilClickableFluent(b, AlertPage.elmXPAlertPageHeader);
		if(res) res = elementActions.isDisplayed(b, AlertPage.elmXPAlertPageHeader);
		if(res) b.report("The Alert Page is of Selenium Official Website is Displayed.");
		else b.report("The Alert Page is of Selenium Official Website is NOT Displayed.");
		if(res) res = elementActions.isDisplayed(b, AlertPage.elmXPSimpleAlertLink);
		if(res) b.report("The Simple Alert Link is Displayed.");
		else b.report("The Simple Alert Link is NOT Displayed.");
		if(res) res = elementActions.scrollElementToMiddle(b, AlertPage.elmXPSimpleAlertLink);
		if(res) res = elementActions.highlightElement(b, AlertPage.elmXPSimpleAlertLink);
		if(res) res = elementActions.takeScreenShot(b, AlertPage.elmXPSimpleAlertLink);
		b.takeScreenShot();
		if(res) res = elementActions.click(b, AlertPage.elmXPSimpleAlertLink);
		if(res) b.report("The Simple Alert Link is clicked.");
		else b.report("The Simple Alert Link is NOT clicked.");
		if(res) res = elementActions.actionOnAlert(b, action);
		if(res) b.report("The action "+action+" on Simple Alert Link is carried out.");
		else b.report("The action "+action+" on Simple Alert Link is NOT carried out.");
		return res;
	}
	public static boolean validateConfirmation(BaseC b, String action)
	{
		boolean res = true;
		if(res) res = elementActions.waitUntilClickableFluent(b, AlertPage.elmXPAlertPageHeader);
		if(res) res = elementActions.isDisplayed(b, AlertPage.elmXPAlertPageHeader);
		if(res) b.report("The Alert Page is of Selenium Official Website is Displayed.");
		else b.report("The Alert Page is of Selenium Official Website is NOT Displayed.");
		if(res) res = elementActions.isDisplayed(b, AlertPage.elmXPSimpleConfirmLink);
		if(res) b.report("The Simple Confirmation Link is Displayed.");
		else b.report("The Simple Confirmation Link is NOT Displayed.");
		if(res) res = elementActions.scrollElementToMiddle(b, AlertPage.elmXPSimpleConfirmLink);
		if(res) res = elementActions.highlightElement(b, AlertPage.elmXPSimpleConfirmLink);
		if(res) res = elementActions.takeScreenShot(b, AlertPage.elmXPSimpleConfirmLink);
		b.takeScreenShot();
		if(res) res = elementActions.click(b, AlertPage.elmXPSimpleConfirmLink);
		if(res) b.report("The Simple Confirmation Link is clicked.");
		else b.report("The Simple Confirmation Link is NOT clicked.");
		if(res) res = elementActions.actionOnAlert(b, action);
		if(res) b.report("The action "+action+" on Simple Confirmation Link is carried out.");
		else b.report("The action "+action+" on Simple Confirmation Link is NOT carried out.");
		return res;
	}
	
	public static boolean validatePrompt(BaseC b, String action, String text)
	{
		boolean res = true;
		if(res) res = elementActions.waitUntilClickableFluent(b, AlertPage.elmXPAlertPageHeader);
		if(res) res = elementActions.isDisplayed(b, AlertPage.elmXPAlertPageHeader);
		if(res) b.report("The Alert Page is of Selenium Official Website is Displayed.");
		else b.report("The Alert Page is of Selenium Official Website is NOT Displayed.");
		if(res) res = elementActions.isDisplayed(b, AlertPage.elmXPSimplePromptLink);
		if(res) b.report("The Simple Prompt Link is Displayed.");
		else b.report("The Simple Prompt Link is NOT Displayed.");
		if(res) res = elementActions.scrollElementToMiddle(b, AlertPage.elmXPSimplePromptLink);
		if(res) res = elementActions.highlightElement(b, AlertPage.elmXPSimplePromptLink);
		if(res) res = elementActions.takeScreenShot(b, AlertPage.elmXPSimplePromptLink);
		b.takeScreenShot();
		if(res) res = elementActions.click(b, AlertPage.elmXPSimplePromptLink);
		if(res) b.report("The Simple Prompt Link is clicked.");
		else b.report("The Simple Prompt Link is NOT clicked.");
		if(res) res = elementActions.actionOnAlert(b, action, text);
		if(res) b.report("The action "+action+" on Simple Prompt Link is carried out.");
		else b.report("The action "+action+" on Simple Prompt Link is NOT carried out.");
		return res;
	}

}
