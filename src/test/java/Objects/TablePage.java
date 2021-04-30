package Objects;

import org.openqa.selenium.By;

public class TablePage {

	public static By elmXPWebTablePageHeader = By.xpath("//h2[text()=' Data Table with Download / Print Demo']");
	public static By elmXPDownloadButton(String type) { return By.xpath("//span[text()='"+type+"']");}
	
	public static String getRowIndex(String name) //Assuming that the names are primary keys.
	{return "count(//td[contains(text(),'"+name+"')]/parent::tr/preceding-sibling::tr)+1";}
	public static String getColumnIndex(String columnname) 
	{return "count(//th[contains(text(),'"+columnname+"')]/preceding-sibling::th)+1";}
	public static By elmXPCellOfANameAndColumn(String name, String columnname)
	{
		return By.xpath("//tr["+getRowIndex(name)+"]/td["+getColumnIndex(columnname)+"]");
	}
}
