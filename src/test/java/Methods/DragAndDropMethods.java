package Methods;

import java.util.List;

import ElementActions.elementActions;
import Objects.DragAndDropPage;
import TestBases.BaseC;

public class DragAndDropMethods {
	
	public static boolean dragAndDropElements(BaseC b)
	{
		boolean res = true;
		if(res) res = elementActions.waitUntilClickableFluent(b, DragAndDropPage.elmXPDragAndDropPageHeader);
		if(res) res = elementActions.isDisplayed(b, DragAndDropPage.elmXPDragAndDropPageHeader);
		if(res) b.report("The Drag And Drop Page has been displayed.");
		else b.report("The Drag And Drop Page has NOT been displayed.");
		if(res) res = elementActions.highlightElement(b, DragAndDropPage.elmXPDragAndDropPageHeader);
		b.takeScreenShot();
		if(res)
		{
			List<String> names = elementActions.getTextOfAllSimilarElements(b, DragAndDropPage.elmXPDraggableObject);
			for(String name : names)
			{
				boolean temp = true;
				if(temp) temp = elementActions.scrollElementToMiddle(b, DragAndDropPage.elmXPDraggableObject(name));
				//if(temp) temp = elementActions.highlightElement(b, DragAndDropPage.elmXPDraggableObject(name));
				if(temp) temp = elementActions.dragAndDrop(b, DragAndDropPage.elmXPDraggableObject(name), 
						DragAndDropPage.elmXPdropZone);
				if(temp) temp = elementActions.isDisplayed(b, DragAndDropPage.elmXPDroppedList(name));
				if(temp) b.report("The "+name+" object is dragged to the drop zone.");
				else {b.report("The "+name+" object is NOT dragged to the drop zone."); res = temp;}
				//break;
			}
		}
		b.takeScreenShot();
		return res;
	}
}
