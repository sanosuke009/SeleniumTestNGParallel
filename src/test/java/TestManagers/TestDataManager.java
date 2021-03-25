package TestManagers;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestBases.BaseC;

public class TestDataManager {
	
	public ConfigManager con;
	public ResultManager rm;
	public Map<String,Map<String, String>> testData = new HashMap<String, Map<String,String>>();
	
	public TestDataManager(ConfigManager con, ResultManager rm)
	{
		this.con = con;
		this.rm = rm;
		loadTestData();
	}

	public void loadTestData()
	{
		try {

			String testdatapath = con.configGet("testdatapath");
			String testdatasheet = con.configGet("testdatasheet");
			String keywordcolumnnum = con.configGet("keywordcolumnnum");
			File myFile = new File(testdatapath); 
			FileInputStream fis = new FileInputStream(myFile); 
			// Finds the workbook instance for XLSX file 
			XSSFWorkbook myWorkBook = new XSSFWorkbook (fis); 
			// Return first sheet from the XLSX workbook 
			XSSFSheet mySheet = myWorkBook.getSheet(testdatasheet); 
			// Traversing over each row of XLSX file 
			int numberOfRows = mySheet.getPhysicalNumberOfRows();
			for (int rowcount=1;rowcount<numberOfRows;rowcount++) 
			{ 
				Row row = mySheet.getRow(rowcount);
			// For each row, iterate through each columns 
				String tmpkeyword = row.getCell(Integer.valueOf(keywordcolumnnum)).toString();
				//System.out.println("tmpkeyword "+tmpkeyword);
				Map<String, String> map=new HashMap<String, String>();
			int numberOfCols = row.getPhysicalNumberOfCells();
			for(int colcount=0;colcount<numberOfCols;colcount++) 
			{ 
				Cell firstrowcell = mySheet.getRow(0).getCell(colcount); 
				Cell cell = row.getCell(colcount); 
				String val = "";
				String col = firstrowcell.getStringCellValue();
				switch (cell.getCellType()) 
				{ 
				case STRING: val=cell.getStringCellValue(); break; 
				case NUMERIC: val=String.valueOf(cell.getNumericCellValue()); break; 
				case BOOLEAN: val=String.valueOf(cell.getBooleanCellValue()); break; 
				default : 
				} 
				map.put(col, val);
				//System.out.println(col +"="+ val);
			} 
			testData.put(tmpkeyword, map);
			}
			myWorkBook.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String get(String keyword, String columnname)
	{
		String res = "";
		try {
		res = testData.get(keyword).get(columnname).toString().trim();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println("Error occurred while fetching value of keyword "+keyword+" and column "+columnname);
			res = "NONE";
		}
		return res;
	}
	
}
