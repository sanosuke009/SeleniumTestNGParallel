package Objects;

import org.openqa.selenium.By;

public class TablePage {

	public static By elmXPWebTablePageHeader = By.xpath("//h2[text()=' Data Table with Download / Print Demo']");
	public static By elmXPDownloadButton(String type) { return By.xpath("//span[text()='"+type+"']");}
	
	
}
