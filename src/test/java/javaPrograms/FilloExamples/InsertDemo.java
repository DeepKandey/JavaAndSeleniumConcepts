package javaPrograms.FilloExamples;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.qa.constants.CommonConstants;

public class InsertDemo {

	public static void main(String[] args) throws FilloException {

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(CommonConstants.TESTDOCUMENT_FILEPATH);

		String insertQuery = "INSERT INTO Sheet1(String,BooleanValue,Number,DecimalNumber,`Email ID`, Link, Character,Date) "
				+ "VALUES('Harsh','FALSE',1,12.23,'Harsh@gmailcom','https://harsh.com','d','08/09/2020')";

		connection.executeUpdate(insertQuery);
		connection.close();

	} // End of method main
} // End of class InsertDemo