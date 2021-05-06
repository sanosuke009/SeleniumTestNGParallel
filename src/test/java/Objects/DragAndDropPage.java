package Objects;

import org.openqa.selenium.By;

public class DragAndDropPage {

	public static By elmXPDragAndDropPageHeader = By.xpath("//h2[text()='Drag and Drop Demo for Automation']");
	public static By elmXPDraggableObject = By.xpath("//span[@draggable='true']");
	public static By elmXPDraggableObject(int index) { return By.xpath("(//span[@draggable='true'])["+index+"]");}
	public static By elmXPDraggableObject(String name) { return By.xpath("//span[@draggable='true' and text()='"+name+"']");}
	public static By elmXPdropZone = By.xpath("//div[@id='mydropzone']");
	public static By elmXPDroppedList(String name) { return By.xpath("//div[@id='droppedlist']/child::span[text()='"+name+"']");}
	
}
