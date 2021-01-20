package javaPrograms.PracticePrograms;

import java.util.Scanner;

public class PalindromeNumber {

  private static Scanner scan;

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    System.out.println("Please enter any number");
    int number = scan.nextInt();
    System.out.println("Is the given number " + number + " a palidrome? " + isPalindrome(number));
  }

  public static boolean isPalindrome(int originalNumber) {
    boolean flag = false;
    int numberToBeReversed = originalNumber;
    int temp = 0, reversedNumber = 0;

    while (numberToBeReversed > 0) {
      temp = numberToBeReversed % 10;
      numberToBeReversed = numberToBeReversed / 10;
      reversedNumber = reversedNumber * 10 + temp;
    }
    if (reversedNumber == originalNumber) {
      flag = true;
    }
    return flag;
  }
}
