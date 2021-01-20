package javaPrograms.FilloExamples;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.qa.constants.CommonConstants;

public class DeleteDemo {

  public static void main(String[] args) throws FilloException {
    Fillo fillo = new Fillo();
    Connection connection = fillo.getConnection(CommonConstants.TESTDOCUMENT_FILEPATH);

    String insertQuery = "DELETE from Sheet1 where String='Harsh'";

    connection.executeUpdate(insertQuery);
    connection.close();
  } // End of method main
} // End of class DeleteDemo
