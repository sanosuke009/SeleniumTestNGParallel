package Utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStampUtils {
	
	public static String getIST()
	{
		String res = "";
		try {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Timestamp(System.currentTimeMillis()));
		res = timeStamp;
		}
		catch(Exception e)
		{
			System.out.println("Error occurred during fetching timestamp");
		}
		return res;
	}
	
	public static String getISTReport()
	{
		String res = "";
		try {
		String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Timestamp(System.currentTimeMillis()));
		res = timeStamp;
		}
		catch(Exception e)
		{
			System.out.println("Error occurred during fetching timestamp");
		}
		return res;
	}
	
	public static String getISTReportDay()
	{
		String res = "";
		try {
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Timestamp(System.currentTimeMillis()));
		res = timeStamp;
		}
		catch(Exception e)
		{
			System.out.println("Error occurred during fetching timestamp");
		}
		return res;
	}

}
