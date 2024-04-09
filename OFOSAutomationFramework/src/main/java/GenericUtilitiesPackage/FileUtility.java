package GenericUtilitiesPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileUtility {

	/**
	 * @author Dudes co
	 * @param key
	 * @return
	 * @throws IOException
	 * this method performs the function of reading the common data from properties file
	 */
	public String readDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.filePath);
		Properties p = new Properties();
		p.load(fis);
		fis.close();
		return p.getProperty(key);
	}

	/**
	 * @author Dudes co
	 * @param key
	 * @param value
	 * @throws IOException
	 * this method performs the function of writing the data into excel file
	 * 
	 */
	public void writeDataIntoPropertiesFile(String key, String value) throws IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.filePath);
		Properties p = new Properties();
		p.setProperty(key, value);
		FileOutputStream fos = new FileOutputStream(IPathConstant.filePath);
		p.store(fos, value);
		fis.close();
	}
	
}