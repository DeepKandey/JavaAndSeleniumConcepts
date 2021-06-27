package javaPrograms.Regex;

import java.io.IOException;
import java.util.Scanner;

class UsernameValidator {
  /*
   * Write regular expression here for alphanumeric and length 8-30.
   */
  public static final String regularExpression = "^[a-zA-Z]([\\w]){7,29}$";
}

public class FindUsername {
  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(scan.nextLine());
    while (n-- != 0) {
      String userName = scan.nextLine();

      if (userName.matches(UsernameValidator.regularExpression)) {
        System.out.println("Valid");
      } else {
        System.out.println("Invalid");
      }
    }
  }
}
