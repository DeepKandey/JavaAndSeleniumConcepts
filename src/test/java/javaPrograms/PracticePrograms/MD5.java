package javaPrograms.PracticePrograms;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next();

    try {

      // Static getInstance method is called with hashing MD5
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      // digest() method is called to calculate message digest
      //  of an input digest() return array of byte
      byte[] digest = md5.digest(input.getBytes());
      System.out.println("byte array: " + digest);

      // Convert byte array into signum representation
      BigInteger bigInteger = new BigInteger(1, digest);
      System.out.println("Big integer sign-magnitude representation: " + bigInteger);

      // Convert message digest into hex value
      String hashText = bigInteger.toString(16);
      System.out.println("hashText: " + hashText);
      while (hashText.length() < 32) {
        hashText = "0" + hashText;
        System.out.println(hashText);
      }
      System.out.println("MD5 representation: " + hashText);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }
}
