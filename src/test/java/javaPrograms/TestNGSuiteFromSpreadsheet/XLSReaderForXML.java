package javaPrograms.TestNGSuiteFromSpreadsheet;

import java.io.File;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XLSReaderForXML {

	private final Fillo fillo;
	private final String filePath;

	private Connection connection;

	public XLSReaderForXML(String filePath) {
		fillo = new Fillo();
		this.filePath = filePath;
	}

	public void getTests(String query) {
		try {
			connection = fillo.getConnection(this.filePath);
			Recordset recordset = connection.executeQuery(query);
			this.createSuite(recordset);
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	} // End of method getTests

	private void createSuite(Recordset recordset) {
		XmlMapper xmlMapper = new XmlMapper();
		Suite suite = new Suite("TestAutomationGuru");

		try {
			while (recordset.next()) {
				String testName = recordset.getField("TestCaseDescription");
				String className = recordset.getField("ClassName");
				String param = "Data";
				String paramValue = recordset.getField("Data");

				suite.addTest(testName, param, paramValue, className);
			}
			xmlMapper.writeValue(new File("c://Deepak Contents//testng-suite.xml"), suite);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			recordset.close();
		}
	} // End of method createSuite
} // End of class XLSReader