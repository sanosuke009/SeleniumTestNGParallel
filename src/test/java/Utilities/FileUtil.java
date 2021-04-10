package Utilities;

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
	

}
