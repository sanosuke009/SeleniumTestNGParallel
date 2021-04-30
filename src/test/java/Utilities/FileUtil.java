package Utilities;

import java.io.File;

public class FileUtil {

	public static String getAbsPath(String path)
	{
		String res = "";
		try {
			String userdir = System.getProperty("user.dir");
			res = getTotalPath(userdir, path);
		}
		catch(Exception e)
		{
			System.out.println("Error occurred during fetching absolute path of "+path);
		}
		return res;
	}

	public static String getTotalPath(String path1, String path2)
	{
		String res = "";
		try {
			res = path1.endsWith("/")?path1+path2:path1+"/"+path2;
		}
		catch(Exception e)
		{
			System.out.println("Error occurred during fetching total path of "+path1+" and "+path2);
		}
		return res;
	}

	public static boolean fileExistenceValidation(String path1, String path2)
	{
		boolean res = false;
		try {
			for(int j=0; j<5; j++)
			{
				String dirName=path1;
				File dir = new File(dirName);
				File[] dir_contents = dir.listFiles();
				//String temp = getTotalPath(path1, path2);
				//boolean check = new File(temp).exists();
				//System.out.println("Check" + check); // -->always says false

				for (int i = 0; i < dir_contents.length; i++) {
					if (dir_contents[i].getName().equals(path2))
					{res = true;
					return res;
					}
				} 
				Thread.sleep(10000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error occurred during validation of existance of file "+path2+" inside "+path1);
		}
		return res;
	}

	public static boolean fileDeletion(String path1)
	{
		boolean res = false;
		try {
				String dirName=path1;
				File dir = new File(dirName);
				File[] dir_contents = dir.listFiles();
				//System.out.println("Check" + check); // -->always says false
				for (int i = 0; i < dir_contents.length; i++) {
					dir_contents[i].delete();
				} 
		}
		catch(Exception e)
		{
			System.out.println("Error occurred during deleting all files from "+path1);
		}
		return res;
	}
	
}
