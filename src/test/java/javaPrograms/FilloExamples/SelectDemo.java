package javaPrograms.FilloExamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class SelectDemo {

	public static void main(String[] args) throws FilloException {

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("C:/Users/deepa/Downloads/TestDocument.xlsx");

		String selectQuery = "select * from Sheet1";
		Recordset recordset = connection.executeQuery(selectQuery);

		// Adding records to ArrayList and Print first Record
		List<String> dataList = new ArrayList<String>();
		while (recordset.next()) {
			dataList.add("Names: " + recordset.getField("String") + " Date: " + recordset.getField("Date"));
		}
		System.out.println(dataList.get(0));

		// Print specific columns data
		recordset.moveFirst();
		int i = 0;
		while (recordset.next()) {
			if (i == 0) {
				recordset.movePrevious();
				i++;
			}
			System.out.println(recordset.getField("String") + "--" + recordset.getField("Date"));
		}

		// Print total rows
		System.out.println("Total number of rows in sheet: " + recordset.getCount());

		// Print last record
		recordset.moveLast();
		System.out.println("Last Record:--> " + recordset.getField("String") + "--" + recordset.getField("Date"));

		// Print Previous record
		recordset.movePrevious();
		System.out.println("Previous Record:--> " + recordset.getField("String") + "--" + recordset.getField("Date"));

		// Print First record
		recordset.moveFirst();
		System.out.println("First Record--> " + recordset.getField("String") + "--" + recordset.getField("Date"));

		// Print Next record
		recordset.moveNext();
		System.out.println("Next Record--> " + recordset.getField("String") + "--" + recordset.getField("Date"));

		// Print Column Names
		ArrayList<String> fieldNamesList = recordset.getFieldNames();
		Iterator<String> fieldNames = fieldNamesList.iterator();
		while (fieldNames.hasNext()) {
			System.out.print(fieldNames.next() + " ");
		}

		recordset.close();
		connection.close();
	} // End of main method
}// End of class SelectDemo