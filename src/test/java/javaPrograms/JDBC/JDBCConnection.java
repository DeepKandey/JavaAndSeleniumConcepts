/** @author Deepak Rai */
package javaPrograms.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** @author Deepak Rai */
public class JDBCConnection {

  /**
   * {@summary }
   *
   * @param
   * @return
   * @author deepak rai
   * @throws SQLException
   */
  public static void main(String[] args) throws SQLException {

    // database URL
    final String DB_URL = "jdbc:mysql://localhost:3306/telusko";
    // Database credentials
    final String USER = "root";
    final String PASS = "1234";

    // STEP 1: create connection with database
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        // Create a Statement object for sending SQL statements to the database.SQL
        // statements without parameters are normally executed using Statement objects.
        // If the same SQL statement is executed many times, it may be more efficient to
        // use a PreparedStatement object.
        Statement stmt = conn.createStatement(); ) {

      // STEP 2: Open a connection
      System.out.println("Connecting to database...");

      // STEP 3: Execute a query
      System.out.println("Creating statement...");

      String sql;
      sql = "SELECT * from student";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        String name = rs.getString("name");
        String college = rs.getString("college");
        System.out.println(name + " " + college);
      }

      // Insert first record
      String record = "INSERT INTO student(name, college)  " + "VALUES ('Pankaj','BHU')";
      stmt.executeUpdate(record); // SQL DDL statement

      System.out.println("Records inserted");

      // STEP 4: Clean-up environment
      rs.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
