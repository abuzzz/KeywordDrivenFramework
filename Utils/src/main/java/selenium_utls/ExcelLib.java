package selenium_utls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelLib {

public static String filename = System.getProperty("user.dir")+PropertiesReader.readProperty("XLS_file");
	
	public String fpath;
	public String fileExtn = "";
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private Workbook workbook = null;
	private Sheet sheet = null;
	private Row row = null;
	private Cell cell = null;
	
	public ExcelLib(String fpath, String fName){
		this.fpath = fpath;
		File file = new File(fpath+fName);
		//Getting the extension type of Excel file
		String fileExtension = fName.substring(fName.indexOf("."));
		System.out.println(fileExtension);
		try {
			fis = new FileInputStream(file);
			if(fileExtension.equals(".xlsx")){
				//creating XSSF type instance
				workbook = new XSSFWorkbook(fis);
			} else if (fileExtension.equals(".xls")){
				//creating HSSF type instance
				workbook = new HSSFWorkbook(fis);
			}
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Return the Row count in a sheet
	public int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index == -1)
			return 0;
		else{
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum()+1;
			return number;
		}
	}
	
	//Return data from a Cell
	public String getCellData(String sheetName, String colName, int rowNum){
		try{
			
			if(rowNum<=0)
				return "Row number must be greater than 0";
			
			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "Sheet name doesn't match";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for(int i=0; i< row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
			if(col_Num==-1)
				return "Column name does't match";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row == null)
				return "Row null or wrong";
			cell = row.getCell(col_Num);
			if(cell==null)
				return "";
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA){
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
			
		} catch (Exception e){
			e.printStackTrace();
			return "Row "+rowNum+" or Column "+colName+" does not exist";
		}
		
	}


}
