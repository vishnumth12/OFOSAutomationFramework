package GenericUtilitiesPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelFileUtility {

	/**
	 * @author Dudes co
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * this method performs the function of reading the data in a single cell of excel workbook sheet
	 */
	public String readSingleDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell c = rw.getCell(cellNum);
		String data = c.getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * @author Dudes co
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * this method performs the function of writing a single data into excel file sheet
	 */
	public void writeSingleDataIntoExcelFile(String sheetName, int rowNum, int cellNum, String value) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNum);
		Cell c = rw.createCell(cellNum);
		c.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IPathConstant.excelPath);
	
		wb.close();
	}
	
	
	/**
	 * @author Dudes co
	 * @param sheetName
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * this method performs the function of reading multiple data at a time from excel sheet
	 */
	public HashMap<String, String> readMultipleDataFromExcelFile(String sheetName, int rowCount, int firtCellNo, int firstRowNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		
		HashMap <String, String> map = new HashMap<String, String>();
		
		for(int i =0; i <= rowCount; i++) {
			
			String key = sh.getRow(firstRowNum+i).getCell(firtCellNo).getStringCellValue();
			String value = sh.getRow(firstRowNum+i).getCell(firtCellNo+1).getStringCellValue();
			
			map.put(key, value);
		}
		return map;
			
	}
	
	/**
	 * this method will return multiple data at a time as a set to the calling method or dataprovider
	 * @param sheetName
	 * @param totalRows
	 * @param firstRowNum
	 * @param lastCellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcelSheet(String sheetName, int sets, int firstRowNum, int lastRowNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		
		Object [][] data = new Object[sets][(lastRowNum-firstRowNum)+1];
		
		for(int cell = 0; cell < sets; cell++) {
			for(int row = 0; row <= lastRowNum-firstRowNum; row++) {
		
				data[cell][row] = sh.getRow(row+firstRowNum).getCell(cell+1).getStringCellValue();
				
			}
		}
		return data;
	}
	
	/**
	 * @author Dudes co
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * this method will return the total number of rows in a table in an excel sheet
	 */
	public int getTotalRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		int lastRowNum = sh.getLastRowNum();
		wb.close();
		return lastRowNum;
		
	}
	
	/**
	 * @author Dudes co
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * this method will return the total number of columns in a table in an excel sheet
	 */
	public int getTotalCellCount(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		int lastCellNum = sh.getRow(0).getLastCellNum();
		wb.close();
		return lastCellNum;
		
	}
}
