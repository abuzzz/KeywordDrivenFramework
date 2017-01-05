package selenium_utls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	static String filePath = System.getProperty("user.dir") + PropertiesReader.readProperty("XLS_file");

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String getData(String sheetName, int rowNum, int cellNum) {

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fileInput);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Sheet sh = wb.getSheet(sheetName);

		String Value = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();

		return Value;

	}

}
