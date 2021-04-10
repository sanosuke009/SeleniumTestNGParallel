package TestManagers;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.io.TemporaryFilesystem;

import Utilities.FileUtil;

public class TempFileManager{
	
	public ConfigManager con;
	
	public TempFileManager(ConfigManager con)
	{
		this.con = con;
	}
	
	public void initTemp()
	{
		try {
			File file = new File(FileUtil.getAbsPath(con.configGet("tempdir")));
			if(!file.isDirectory())
			{
			    FileUtils.forceMkdir(file);
			}
			TemporaryFilesystem.setTemporaryDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error occurred during temp file init.");
		}
	}
	
	public void deleteTemp()
	{
		try {
			File file = new File(FileUtil.getAbsPath(con.configGet("tempdir")));
			FileUtils.deleteDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error occurred during temp file delete.");
		}
	}
	
	

}
