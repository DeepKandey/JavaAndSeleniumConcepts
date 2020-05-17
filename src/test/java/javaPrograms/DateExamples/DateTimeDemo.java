package javaPrograms.DateExamples;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class DateTimeDemo {

	public static void main(String[] args) {

		// Local Date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current Date: " + date1);

		LocalDate date2 = LocalDate.of(1991, 8, 23);
		System.out.println("Birth Date: " + date2);

		LocalDate date3 = LocalDate.of(1991, Month.AUGUST, 23);
		System.out.println("Birth Date: " + date3);

		// Local Time
		LocalTime time1 = LocalTime.now();
		System.out.println("Current Time: " + time1);

		LocalTime time2 = LocalTime.of(14, 35, 45, 12421);
		System.out.println("User Provided Time: " + time2);

		LocalTime time3 = LocalTime.now(ZoneId.of("US/Pacific"));
		System.out.println("Current Time of US/Pacific: " + time3);

		// Instant
		Instant i = Instant.now();
		System.out.println("Instantaneous point on the time line: " + i);
		
		// Local Date time
		LocalDateTime dateTime1= LocalDateTime.now();
		System.out.println("Date Time: "+ dateTime1);

		// Zone ids
		for (String s : ZoneId.getAvailableZoneIds())
			System.out.println(s);
	}
}