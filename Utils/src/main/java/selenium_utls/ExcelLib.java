package selenium_utls;

import helper.PropertiesReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import selenium_utls.ReportLog.log;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ExcelLib {

//Fetch XLS file name.
public static String filename = System.getProperty("user.dir")	+ PropertiesReader.readProperty("XLS_file");

//Declare and Initialise.
	public static ReportLog reportLog = new ReportLog("SQL");
	public String fpath;
	public String fileExtn = "";
	public static FileInputStream fis = null;
	public FileOutputStream fos = null;
	private static HSSFWorkbook workbook = null;
	private static HSSFSheet sheet = null;
	private static Row row = null;
	private static Cell cell = null;
	
//Initalise workbook from static block.
	static {
		try {
			fis = new FileInputStream(filename);

			workbook = new HSSFWorkbook(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fetch cell data from sheetname and column name.
	 * @param sheetName
	 * @param col_name
	 * @return Map of Row number and cell data.
	 */
	public static Multimap<Integer,String> getCellData(String sheetName, String col_name) {
//Declare and Initialise.
		Multimap<Integer, String> map_data = ArrayListMultimap.create();
//Get Sheet and rows.
		try {
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				reportLog.LOG(log.ERROR, "Sheet name doesn't match","getCellData");
//Fetching sheet name.	
			sheet = workbook.getSheetAt(index);
			int col_no = 0;
			row = sheet.getRow(1);
			for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
				if (row.getCell(i).toString().trim().equals(col_name)) {
					col_no = i;
					break;
				}
			}
//Read cell data.
			for (int i = 2; i < sheet.getLastRowNum() + 1; i++) {
				row = sheet.getRow(i);
				cell = row.getCell(col_no);

				if (cell == null) {
					reportLog
					.LOG(log.ERROR, "Value Not present", "getCellData");
				}
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
						|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

					String cellText = new DataFormatter().formatCellValue(cell);
					map_data.put(i,cellText);
					

				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
					map_data.put(i,cell.getStringCellValue());
				else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
					reportLog
					.LOG(log.ERROR, "Value Not present", "getCellData");
				else
					map_data.put(i,String.valueOf(cell.getBooleanCellValue()));
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			reportLog.LOG(log.ERROR, "Row or Column does not exist",	"getCellData");
		}
		return map_data;
	}
	
/**
 * Get Cell data based on sheet name , column name and row number.
 * @param sheetName
 * @param colName
 * @param rowNum
 * @return Cell data.
 */
	public static String getCellData(String sheetName, String colName,	int rowNum) {
//Get Sheet and rows.	
		try {
			if (rowNum <= 0)
				return "Row number must be greater than 0";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "Sheet name doesn't match";

			sheet = workbook.getSheetAt(index);	
				row = sheet.getRow(rowNum);
				
				
//Read cell data.
			 for(int i=0; i< sheet.getRow(1).getLastCellNum();i++){
			 if(sheet.getRow(1).getCell(i).getStringCellValue().trim().equals(colName.trim())){
				 col_Num=i; 
				 break ; }
			 }
			 
			 cell = row.getCell(col_Num);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = new DataFormatter().formatCellValue(cell);
				return cellText;

			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {
			e.printStackTrace();
			return "Row " + rowNum + " or Column " + colName
					+ " does not exist";
		}
	}
	
	/**
	 * Get Cell data based on sheet name , column number and row number.
	 * @param sheetName
	 * @param colNum
	 * @param rowNum
	 * @return Cell data.
	 */
	public static String getCellData(String sheetName, int colNum, int rowNum) {
//Get Sheet and rows.
		try {
			if (rowNum < 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				{
				reportLog.LOG(log.ERROR, "Sheet Not present", "getCellData");
				return "";			
				}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum);
			if (row == null)
				{
				reportLog.LOG(log.ERROR, "Value Not present", "getCellData");
				return null;
				}
//Read cell data.
			cell = row.getCell(colNum);
			if (cell == null)
			{reportLog.LOG(log.ERROR, "Value Not present", "getCellData");
			return null;
			}
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = new DataFormatter().formatCellValue(cell);
				return cellText;
			} 
			else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
			{reportLog.LOG(log.ERROR, "Value Not present", "getCellData");
				return null;}
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			reportLog.LOG(log.ERROR, "Value Not present", "getCellData");
			return "row " + rowNum + " or column " + colNum	+ " does not exist  in xls";
		}
	}
}