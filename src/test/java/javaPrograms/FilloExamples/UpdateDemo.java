package javaPrograms.FilloExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.poi.EncryptedDocumentException;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.qa.constants.CommonConstants;

public class UpdateDemo {

	public static void main(String[] args) throws FilloException, InterruptedException {
		
		try {
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
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		Thread.sleep(1000);

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(CommonConstants.TESTDOCUMENT_FILEPATH);

		String insertQuery = "UPDATE Sheet1 set Number=123 where String='Harsh'";

		connection.executeUpdate(insertQuery);
		connection.close();

	} // End of method main
} // End of class UpdateDemo