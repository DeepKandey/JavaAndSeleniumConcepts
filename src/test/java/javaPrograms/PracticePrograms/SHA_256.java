package javaPrograms.PracticePrograms;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA_256 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next();

    try {

      /*Encode the String using SHA-256 */
      MessageDigest sha_256 = MessageDigest.getInstance("SHA-256");
      byte[] digest = sha_256.digest(input.getBytes());

      /*
      Print the encode value in hexadecimal
       */
      for (byte b : digest) {
        System.out.format("%02x",b);
      }

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }
}
