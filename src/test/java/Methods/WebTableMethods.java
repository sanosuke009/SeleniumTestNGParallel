package Methods;

import ElementActions.elementActions;
import Objects.TablePage;
import TestBases.BaseC;
import Utilities.FileUtil;

public class WebTableMethods {
	
	public static boolean downloadTableData(BaseC b, String option, String filenames)
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
}
