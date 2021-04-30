package Methods;

import ElementActions.elementActions;
import Objects.TablePage;
import TestBases.BaseC;
import Utilities.FileUtil;

public class WebTableMethods {
	
	public static boolean downloadTableData(BaseC b, String option, String filenames, String color)
	{
		boolean res = true;
		String[] ops = option.split("#");
		String[] fs = filenames.split("#");
		if(res) res = elementActions.waitUntilClickableFluent(b, TablePage.elmXPWebTablePageHeader);
		if(res) res = elementActions.isDisplayed(b, TablePage.elmXPWebTablePageHeader);
		if(res) res = elementActions.highlightElement(b, TablePage.elmXPWebTablePageHeader);
		b.takeScreenShot();
		if(res)
		{
			for(int j=0;j<ops.length; j++)
			{
				boolean result = elementActions.highlightElement(b, TablePage.elmXPDownloadButton(ops[j]));
				if(result) result = elementActions.scrollElementToMiddle(b, TablePage.elmXPDownloadButton(ops[j]));
				if(result) result = elementActions.compareBackgroundColor(b, TablePage.elmXPDownloadButton3D(ops[j]), color);
				if(result) b.report("The color of the "+ops[j]+" button is "+color+" as expected.");
				else b.report("The color of the "+ops[j]+" button is NOT "+color+" as expected. "
						+ "The color is "+elementActions.getBackgroundColor(b, TablePage.elmXPDownloadButton3D(ops[j])));
				if(result) result = elementActions.click(b, TablePage.elmXPDownloadButton(ops[j]));
				if(result) result = FileUtil.fileExistenceValidation(FileUtil.getAbsPath(b.getConfig("downloadpath")), fs[j]);
				if(result) b.report("The "+option+" is downloaded from the table page.");
				else b.report("The "+option+" is NOT downloaded from the table page."); res = result;
			}
		}
		FileUtil.fileDeletion(FileUtil.getAbsPath(b.getConfig("downloadpath")));
		b.takeScreenShot();
		return res;
	}


	public static boolean fetchTableData(BaseC b, String names, String columns)
	{
		boolean res = true;
		String[] name = names.split("#");
		String[] columnname = columns.split("#");
		if(res) res = elementActions.waitUntilClickableFluent(b, TablePage.elmXPWebTablePageHeader);
		if(res) res = elementActions.isDisplayed(b, TablePage.elmXPWebTablePageHeader);
		if(res) res = elementActions.highlightElement(b, TablePage.elmXPWebTablePageHeader);
		b.takeScreenShot();
		if(res)
		{
			for(String nam:name)
			{
				for(String col : columnname)
				{
					String key="";
					boolean result = elementActions.highlightElement(b, TablePage.elmXPCellOfANameAndColumn(nam, col));
					if(result) result = elementActions.scrollElementToMiddle(b, TablePage.elmXPCellOfANameAndColumn(nam, col));
					if(result) key = elementActions.getText(b, TablePage.elmXPCellOfANameAndColumn(nam, col));
					if(result) b.report("The "+col+" of "+nam+" is displayed in the table as "+key);
					else {b.report("The "+col+" of "+nam+" is NOT displayed in the table."); res = result;}
				}
			}
		}
		b.takeScreenShot();
		return res;
	}

}
