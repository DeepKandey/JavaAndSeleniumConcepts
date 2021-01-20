package javaPrograms.ExcelExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/** @author deepak */
public class ReadExcelDataInMap {

  /**
   * {@summary Reading Excel Data as Map}
   *
   * @param
   * @return
   * @author deepak
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {

    LinkedHashMap<String, String> excelDataAsMap = getExcelDataAsMap("TestDocument", "Sheet3");

    for (String key : excelDataAsMap.keySet()) {
      System.out.println("Value of " + key + " is " + excelDataAsMap.get(key));
    }
  }

  /**
   * {@summary utility to read data as Map}
   *
   * @param excelFileName, sheetName
   * @return linkedHahMap data
   * @author deepak
   * @throws IOException
   */
  public static LinkedHashMap<String, String> getExcelDataAsMap(
      String excelFileName, String sheetName) throws IOException {

    // Create a Workbook
    InputStream fis =
        new FileInputStream("src/test/resources/ExcelFiles/" + excelFileName + ".xlsx");
    Workbook wb = WorkbookFactory.create(fis);

    // Get Sheet with the
    Sheet sheet = wb.getSheet(sheetName);

    // Initialized an empty LinkedHashMap which retain order
    LinkedHashMap<String, String> linkedHashMapData = new LinkedHashMap<String, String>();

    // Get total row count
    int rowsCount = sheet.getPhysicalNumberOfRows();

    // Skipping first count row as it contains headers
    for (int i = 1; i < rowsCount; i++) {

      // Get the row
      Row row = sheet.getRow(i);
      // Since every rows has 2 cells, first is field name and another is value
      String fieldName = row.getCell(0).getStringCellValue();
      String fieldValue = row.getCell(1).getStringCellValue();

      linkedHashMapData.put(fieldName, fieldValue);
    }

    return linkedHashMapData;
  }
}
