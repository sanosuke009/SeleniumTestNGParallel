package Objects;

import org.openqa.selenium.By;

public class SimpleFormsPage {

	public static By elmXPtextFieldsHeader = By.xpath("//div[contains(text(),'Two Input Fields')]");
	public static By elmXPinputFieldA = By.xpath("//label[text()='Enter a']/following-sibling::input");
	public static By elmXPinputFieldB = By.xpath("//label[text()='Enter b']/following-sibling::input");
	public static By elmXPButtonGetTotal = By.xpath("//button[text()='Get Total']");
	public static By elmXPtextGetTotalResult = By.xpath("//label[contains(text(),"
			+ "' Total a + b = ')]/following-sibling::span");
	
}
