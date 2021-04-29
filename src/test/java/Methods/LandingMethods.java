package Methods;

import com.relevantcodes.extentreports.LogStatus;

import ElementActions.elementActions;
import Objects.CheckBoxPage;
import Objects.LandingPage;
import Objects.SimpleFormsPage;
import TestBases.BaseC;

public class LandingMethods {
	
	public static boolean openLandingPage(BaseC b)
	{
		boolean res = true;
		if(res) res = elementActions.waitUntilClickable(b, LandingPage.elmXPHomepgaeHeader);
		if(res) res = elementActions.isDisplayed(b, LandingPage.elmXPHomepgaeHeader);
		if(res) b.report("The Home page is displayed.");
		if(!res) b.report("The Home page is NOT displayed.");
		elementActions.highlightElement(b, LandingPage.elmXPHomepgaeHeader);
		b.takeScreenShot();
		return res;
	}
	
	public static boolean clickOnPopUp(BaseC b)
	{
		boolean res = true;
		b.takeScreenShot();
		if(res) res = elementActions.waitUntilClickable(b, LandingPage.elmXPButtonHomepageNo);
		if(res) res = elementActions.click(b, LandingPage.elmXPButtonHomepageNo);
		if(res) b.report("The Home page Popup No Button is clicked.");
		if(!res) b.report("The Home page Popup No Button is NOT clicked.");
		b.takeScreenShot();
		return res;
	}
	
	public static boolean validateAddTwoNumbersForm(BaseC b, String a, String a1)
	{
		boolean res = true;
		double firstnum = 0;double secondnum = 0;double totalnum = 0;String totalsums ="";
		try {
		firstnum = Double.valueOf(a);
		secondnum = Double.valueOf(a1);
		totalnum = firstnum + secondnum;
		}
		catch(Exception e)
		{
			b.report("Error occurred while fetching the number values");
			res = false;
			return res;
		}
		if(res) res = elementActions.scrollToElement(b, LandingPage.elmIDButtonStartExample);
		b.takeScreenShot();
		if(res) res = elementActions.click(b, LandingPage.elmIDButtonStartExample);
		if(res) b.report("The Start Example Button is clicked.");
		if(!res) b.report("The Start Example Button is NOT clicked.");
		if(res) 
		{
			b.takeScreenShot();
			b.report(LogStatus.INFO,"Below are the options available for clicking:");
			try {
			for(String name : elementActions.getTextOfAllSimilarElements(b, LandingPage.elmXPlistBasic))
			{
				if(!name.equals(""))
				{
					b.report(LogStatus.INFO,name);
				}
			}
			}
			catch(Exception e)
			{
				b.report("Error occurred while getting option names.");
				res= false;
			}
		}
		if(res) res = elementActions.click(b, LandingPage.elmXPlistBasicForms);
		if(res) b.report("The Forms Section Option is clicked.");
		if(!res) b.report("The Forms Section Option is NOT clicked.");
		if(res) res = elementActions.waitUntilClickable(b, SimpleFormsPage.elmXPtextFieldsHeader);
		if(res) res = elementActions.isDisplayed(b, SimpleFormsPage.elmXPtextFieldsHeader);
		b.takeScreenShot();
		if(res) b.report("The Forms Section Page is Opened Successfully.");
		if(!res) b.report("The Forms Section Page is NOT Opened Successfully.");
		if(res) res = elementActions.sendKeys(b, SimpleFormsPage.elmXPinputFieldA, a);
		if(res) b.report("In The Forms Section Page "+a+" is given as input in first input field.");
		if(!res) b.report("In The Forms Section Page "+a+" is NOT given as input in first input field.");
		if(res) res = elementActions.sendKeys(b, SimpleFormsPage.elmXPinputFieldB, a1);
		if(res) b.report("In The Forms Section Page "+b+" is given as input in second input field.");
		if(!res) b.report("In The Forms Section Page "+b+" is NOT given as input in second input field.");
		b.takeScreenShot();
		if(res) res = elementActions.click(b, SimpleFormsPage.elmXPButtonGetTotal);
		if(res) b.report("The Get Total button is clicked.");
		if(!res) b.report("The Get Total button is NOT clicked.");
		if(res) res = elementActions.waitUntilClickable(b, SimpleFormsPage.elmXPtextGetTotalResult);
		if(res) totalsums = elementActions.getText(b, SimpleFormsPage.elmXPtextGetTotalResult);
		res = Integer.valueOf(totalsums)==totalnum;
		if(res) b.report("The sum of "+a+" and "+b+" is displayed as "+totalsums+" as expected.");
		if(!res) b.report("The sum of "+a+" and "+b+" is displayed as "+totalsums+" "
				+ "which is not expected. Expected result is "+totalnum+".");
		b.takeScreenShot();
		return res;
	}


	public static boolean validateCheckBoxPage(BaseC b, String text)
	{
		boolean res = true;String eltext = "";
		if(res) res = elementActions.scrollToElement(b, LandingPage.elmIDButtonStartExample);
		elementActions.highlightElement(b, LandingPage.elmIDButtonStartExample);
		b.takeScreenShot();
		if(res) res = elementActions.click(b, LandingPage.elmIDButtonStartExample);
		if(res) b.report("The Start Example Button is clicked.");
		if(!res) b.report("The Start Example Button is NOT clicked.");
		b.takeScreenShot();
		if(res) res = elementActions.click(b, LandingPage.elmXPlistCheckBox);
		if(res) b.report("The Check Box Option is clicked.");
		if(!res) b.report("The Check Box Option is NOT clicked.");
		if(res) res = elementActions.isDisplayed(b, CheckBoxPage.elmIDcheckBoxSimpleAge);
		if(res) b.report("The Simple Age Check Box Option is displayed.");
		if(!res) b.report("The Simple Age Check Box Option is NOT displayed.");
		if(res) res = elementActions.click(b, CheckBoxPage.elmIDcheckBoxSimpleAge);
		if(res) b.report("The Simple Age Check Box Option is clicked.");
		if(!res) b.report("The Simple Age Check Box Option is NOT clicked.");
		b.takeScreenShot();
		if(res) res = elementActions.isDisplayed(b, CheckBoxPage.elmIDtextMessageSimpleAge);
		if(res) b.report("The Simple Age Check Box Message is displayed.");
		if(!res) b.report("The Simple Age Check Box Message is NOT displayed.");
		if(res) eltext = elementActions.getText(b, CheckBoxPage.elmIDtextMessageSimpleAge);
		if(res) res = eltext.contains(text);
		if(res) b.report("The Simple Age Check Box Message is correctly displayed as "+text);
		if(!res) b.report("The Simple Age Check Box Message is NOT Correctly displayed. "
				+ "The expected text was "+text+" and the text fetched from the webpage is "+eltext);
		return res;
	}


	public static boolean clickOnOptionFromList(BaseC b, String text)
	{
		boolean res = true;
		if(res) res = elementActions.scrollToElement(b, LandingPage.elmIDButtonStartExample);
		elementActions.highlightElement(b, LandingPage.elmIDButtonStartExample);
		b.takeScreenShot();
		if(res) res = elementActions.click(b, LandingPage.elmIDButtonStartExample);
		if(res) b.report("The Start Example Button is clicked.");
		if(!res) b.report("The Start Example Button is NOT clicked.");
		elementActions.highlightElement(b, LandingPage.elmXPlistOption(text));
		b.takeScreenShot();
		if(res) res = elementActions.click(b, LandingPage.elmXPlistOption(text));
		if(res) b.report("The "+text+" Option is clicked.");
		if(!res) b.report("The "+text+" Option is NOT clicked.");
		return res;
	}
	

	public static boolean pickOption(BaseC b, String option1, String option)
	{
		boolean res = true;
		if(res) res = elementActions.waitUntilClickableFluent(b, LandingPage.elmXPOptionsDropDown(option1));
		if(res) res = elementActions.isDisplayed(b, LandingPage.elmXPOptionsDropDown(option1));
		if(res) res = elementActions.click(b, LandingPage.elmXPOptionsDropDown(option1));
		if(res) res = elementActions.click(b, LandingPage.elmXPDatePickerDropDownOption(option));
		if(res) b.report("The option "+option+" is selected from the Landing Page "+option1+" Drop Down List.");
		else b.report("The option "+option+" is NOT selected from the Landing Page "+option1+" Drop Down List.");
		b.takeScreenShot();
		return res;
	}

}
