package Objects;

import org.openqa.selenium.By;

public class LandingPage {

	public static By elmXPHomepgaeHeader = By.xpath("//a[@title='Home' and text()='Selenium Easy']");
	public static By elmXPButtonHomepageNo = By.xpath("//a[text()='No, thanks!']");
	public static By elmXPtextStartHeader = By.xpath("//h3[contains(text(),'Welcome to Selenium Easy')]");
	public static By elmIDButtonStartExample = By.id("btn_basic_example");
	public static By elmIDButtonRoundHome = By.className("round-tabs one");
	public static By elmIDButtonRoundBasic = By.className("round-tabs two");
	public static By elmIDButtonRoundIntermediate = By.className("round-tabs three");
	public static By elmIDButtonRoundAdvanced = By.className("round-tabs four");
	
	public static By elmXPlistBasic = By.xpath("//a[@class='list-group-item']");
	public static By elmXPlistBasicForms = By.xpath("//a[@class='list-group-item'"
			+ " and contains(text(),'Simple Form Demo')]");
	public static By elmXPlistCheckBox = By.xpath("//a[@class='list-group-item'"
			+ " and contains(text(),'Check Box Demo')]");
	
}
