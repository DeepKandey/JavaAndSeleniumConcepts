package javaPrograms.PracticePrograms;

import com.twilio.rest.api.v2010.account.Message;

import java.text.MessageFormat;

public class StringInterpolation {

  public static void main(String[] args) {

    // Using the + operator
    String name = "Geeks for Geeks";
    String field = "coding";
    System.out.println(name + " is the best platform to learn " + field + ".");

    // Using the format() function
    System.out.println(String.format("%s is the best platform to learn %s.", name, field));

    // Using the messageFormat class
    String a = "Democracy";
    String b = "people";
    System.out.println(
        MessageFormat.format("{0} is a government of the {1}, for the {1} and by the {1}.", a, b));

    // Using StringBuilder class
    System.out.println(
        new StringBuilder(name).append(" is the best portal to learn ").append(field).append("."));
  }
}
