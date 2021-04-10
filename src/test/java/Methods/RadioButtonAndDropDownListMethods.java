package Methods;

import ElementActions.elementActions;
import Objects.DropDownListPage;
import TestBases.BaseC;

public class RadioButtonAndDropDownListMethods {
	
	public static boolean validateSingleDropDownList(BaseC b, String text, String text2)
	{
		boolean res = true;
		if(res) res = elementActions.isDisplayed(b, DropDownListPage.elmIDSingleDropDownList);
		if(res) res = elementActions.scrollToElement(b, DropDownListPage.elmIDSingleDropDownList);
		if(res) b.report("The Drop Down List Page is Displayed.");
		else b.report("The Drop Down List Page is NOT Displayed.");
		elementActions.highlightElement(b, DropDownListPage.elmIDSingleDropDownList);
		elementActions.takeScreenShot(b, DropDownListPage.elmIDSingleDropDownList);
		b.takeScreenShot();
		if(res) res = elementActions.selectDropDownList(b, DropDownListPage.elmIDSingleDropDownList, text);
		if(res) b.report("The option "+text+" has been successfully selected from the drop down list.");
		else b.report("The option "+text+" has NOT been selected from the drop down list.");
		b.takeScreenShot();
		elementActions.highlightElement(b, DropDownListPage.elmIDMultipleDropDownList);
		if(res) res = elementActions.selectDropDownListMultiple(b, DropDownListPage.elmIDMultipleDropDownList, text2);
		if(res) b.report("The options "+text2+" have been successfully selected from the drop down list.");
		else b.report("The options "+text2+" have NOT been selected from the drop down list.");
		elementActions.takeScreenShot(b, DropDownListPage.elmIDMultipleDropDownList);
		b.takeScreenShot();
		return res;
	}

}
