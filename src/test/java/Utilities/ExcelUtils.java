package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	
	public static InputStream fis;
	public static HSSFWorkbook wb;
	public static HSSFSheet sheet;
	public static String row;
	public static HSSFCell cell;
	public static Map<String, String> map=new HashMap<String, String>();
	
	
	public String getCellData(String keyword, String colname)
	{
		String value=null;String TestKey=null;
		int columns, i, j, rows;
		try {
		fis = getClass().getResourceAsStream("");
			wb = new HSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);
			rows = sheet.getPhysicalNumberOfRows();
			columns = sheet.getRow(0).getPhysicalNumberOfCells();
			outerloop: for(i=0;i<rows;i++)
			{
				TestKey = sheet.getRow(i).getCell(2).getStringCellValue();
				if(TestKey.equalsIgnoreCase(keyword))
				{
					for(j=0;j<columns;j++)
					{
						if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase(colname))
						{
							value = sheet.getRow(i).getCell(j).getStringCellValue();
							break outerloop;
						}
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		
	}

}
