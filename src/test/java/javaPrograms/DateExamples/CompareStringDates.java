/** @author Deepak Rai */
package javaPrograms.DateExamples;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/** @author Deepak Rai */
public class CompareStringDates {

  /**
   * {@summary compare String dates }
   *
   * @param
   * @return
   * @author deepak rai
   * @throws ParseException
   */
  public static void main(String[] args) throws ParseException {

    String date1 = "12/23/2021";
    String date2 = "10/30/2020";

    SimpleDateFormat sdfObj = new SimpleDateFormat("mm/dd/yyyy");

    // Compares two Dates for ordering.
    // the value 0 if the argument Date is equal
    // to this Date; a value less than 0 if this Date is before the Date
    // argument;and
    // a value greater than 0 if this Date is after the Date argument.
    System.out.println(sdfObj.parse(date1).compareTo(sdfObj.parse(date2)));
  }
}
