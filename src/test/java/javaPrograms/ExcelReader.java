package javaPrograms;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;

	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExcelReader xcelReader = new ExcelReader("C:\\Users\\deepa\\Downloads\\TestDocument.xlsx");
		System.out.println("Total Row count-->" + xcelReader.getRowCount("Sheet1"));

		// Printing data from excel
		String[][] excelData = getExcelData("C:/Users/deepa/Downloads/TestDocument.xlsx", "Sheet1");
		for (int i = 0; i < excelData.length; i++) {
			for (int j = 0; j < excelData[i].length; j++) {
				System.out.println("Values at arr[" + i + "][" + j + "] is " + excelData[i][j]);
			}
		}
	}

	// 1.return data from the excel
	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayData = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);

			int totalNoRows = sheet.getLastRowNum();
			int totalNoCols = sheet.getRow(0).getLastCellNum();
			arrayData = new String[totalNoRows][totalNoCols];

			for (int i = 0; i < totalNoRows; i++) {
				for (int j = 0; j < totalNoCols; j++) {
					arrayData[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayData;
	}

	// 2.return total row count in a sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}
}
