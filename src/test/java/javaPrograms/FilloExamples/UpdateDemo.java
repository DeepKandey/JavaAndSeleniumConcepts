package javaPrograms.FilloExamples;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class UpdateDemo {

	public static void main(String[] args) throws FilloException {
		Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection("C:/Users/deepa/Downloads/TestDocument.xlsx");
        
        String insertQuery=
                "UPDATE Sheet1 set Number=12 where String='Harsh'";

        connection.executeUpdate(insertQuery);
        connection.close();

    } // End of method main
} // End of class UpdateDemo