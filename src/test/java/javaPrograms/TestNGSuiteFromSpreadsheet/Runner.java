package javaPrograms.TestNGSuiteFromSpreadsheet;

public class Runner {

	public static void main(String[] args) {

		XLSReaderForXML suite= new XLSReaderForXML("C:\\Users\\deepa\\Downloads\\Deepak.xlsx");
		suite.getTests("select * from TestNGxml where module='Order'");
	} // End of method main
} // End of class Runner
