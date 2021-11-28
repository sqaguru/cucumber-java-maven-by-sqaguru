package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
	@SuppressWarnings("resource")
	public Object[] getTestData(String fileName, String sheetName) {
		Object[] object = null;

		try {

			FileInputStream file = new FileInputStream(Utils.getProjectPath() + Constants.PATH_TESTDATA + fileName);

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet worksheet = workbook.getSheet(sheetName);
			int totalRows = worksheet.getPhysicalNumberOfRows();
			System.out.println("total number of rows in excel worksheet: " + totalRows);

			object = new Object[totalRows - 1];

			int totalColumns = worksheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("total number of columns in excel worksheet: " + totalColumns);

			for (int rowCounter = 1; rowCounter < totalRows; rowCounter++) {
				HashMap<String, String> hashMap = new HashMap<String, String>();

				HSSFRow rowHeader = worksheet.getRow(0);
				HSSFRow rowData = worksheet.getRow(rowCounter);
				for (int columnCounter = 0; columnCounter < totalColumns; columnCounter++) {
					HSSFCell cellHeader = rowHeader.getCell(columnCounter);
					HSSFCell cellData = rowData.getCell(columnCounter);
					String key = cellHeader.getStringCellValue();
					String value = cellData.getStringCellValue();
					System.out.println("data: " + key + ": " + value);
					hashMap.put(key, value);
				}

				object[rowCounter - 1] = hashMap;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;
	}

	public static void main(String[] args) {
		HashMap<String, String> countryAndCapital = new HashMap<String, String>();

		countryAndCapital.put("India", "New Delhi");

		countryAndCapital.put("Japan", "Tokyo");

		System.out.println(countryAndCapital.get("Japan"));

		countryAndCapital.put("Canada", "Toronto");

	}

}
