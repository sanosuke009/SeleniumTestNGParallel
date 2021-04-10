package TestManagers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager{
	
	//=====================Variables=================
	
	public  Properties config = new Properties();
	
	//===============================================
	
	public ConfigManager()
	{
		InputStream inp = null;
		try {
			inp = new FileInputStream(System.getProperty("user.dir")+"/Configurations/config.properties");
			this.config.load(inp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String configGet(String key)
	{
		String res = "";
		try
		{
			res = this.config.getProperty(key).toString().trim();
		}
		catch(Exception e)
		{
			System.out.println("Error while extracting the value of "+key+" from config file");
		}
		return res;
	}
	

}
