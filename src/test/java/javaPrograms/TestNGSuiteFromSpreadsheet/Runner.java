package javaPrograms.TestNGSuiteFromSpreadsheet;

import com.qa.constants.CommonConstants;

public class Runner {

	public static void main(String[] args) {

		XLSReaderForXML suite= new XLSReaderForXML(CommonConstants.TESTDOCUMENT_FILEPATH);
		suite.getTests("select * from TestNGxml where module='Order'");
	
	} // End of method main
} // End of class Runner