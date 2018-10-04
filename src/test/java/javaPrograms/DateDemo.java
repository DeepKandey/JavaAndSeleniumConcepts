package javaPrograms;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateFormatHrs = new SimpleDateFormat("dd-MM-yyyy  hh:mm:ss");

		System.out.println("Default Date Format: " + date.toString());
		System.out.println("Default Calendar Format: " + cal.getTime());
		System.out.println(dateFormat.format(date));
		System.out.println(dateFormatHrs.format(date));
	}
}
