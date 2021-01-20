package javaPrograms.PracticePrograms;

import org.apache.commons.codec.binary.Base64;

public class EncodeAndDecodeString {

  public static void main(String[] args) {

    // Sample String variable
    String testString = "test123";
    // Encoding String
    byte[] encodedString = Base64.encodeBase64(testString.getBytes());
    System.out.println("Encoded String: " + new String(encodedString));
    // Decoding String
    byte[] decodedString = Base64.decodeBase64(encodedString);
    System.out.println("Decoded String: " + new String(decodedString));
  } // End of method main
} // End of class EncodeAndDecodeString
