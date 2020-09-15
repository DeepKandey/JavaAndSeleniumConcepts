package javaPrograms.ExcelExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.constants.CommonConstants;

public class ReadExcelUsingWorkbookFactory {

	public static void main(String[] args) throws Exception {

		try (Workbook workBook = WorkbookFactory.create(new File(CommonConstants.TESTDOCUMENT_FILEPATH));) {
			
			// kill the excel process if it is already open
			Process p = Runtime.getRuntime().exec("tasklist");
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("EXCEL.EXE")) {
					Runtime.getRuntime().exec("taskkill /f /im EXCEL.EXE");
					break;
				}
			}

			Thread.sleep(1000);

			/*
			 * It creates the appropriate HSSFWorkbook / XSSFWorkbook from the given File,
			 * which must exist and be readable. In this case it will create a XSSFWorkbook
			 */

			// get sheet with the given sheet name
			Sheet sheet = workBook.getSheet("Sheet2");

			// Returns the number of physically defined rows
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Total number of rows in sheet: " + rowCount);

			// Iterating rows
			for (int i = 1; i < rowCount; i++) {
				// Returns the logical row (not physical) 0-based. If you ask for a row that is
				// not defined you get a null.
				Row row = sheet.getRow(i);
				// Gets the number of defined cells (NOT number of cells in the actual
				// row!).That is to say if only columns 0,4,5 have values then there would be 3
				int columnCount = row.getPhysicalNumberOfCells();
				// iterating columns
				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					/*
					 * Get the value of the cell as a string For numeric cells we throw an
					 * exception. For blank cells we return an empty string.For formulaCells that
					 * are not string Formulas, we throw an exception.
					 */
					String data = cell.getStringCellValue();
					System.out.print(data + "\t");
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// End of method main
}// end of class ReadExcelUsingWorkbookFactory