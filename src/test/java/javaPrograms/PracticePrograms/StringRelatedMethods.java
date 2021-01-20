package javaPrograms.PracticePrograms;

public class StringRelatedMethods {

  public static void main(String[] args) {

    String s = "Deepak Rai";
    String j = s.replace(" ", "");
    System.out.println("String after removing spaces: " + j);
    System.out.println(
        "Length of the string using s.lastIndexOf(\"i\")+1): " + (s.lastIndexOf("i") + 1));
    System.out.println(
        "Length of the string using s.toCharArray().length: " + s.toCharArray().length);
    System.out.println("Length of the string using s.split(\"\").length: " + (s.split("").length));

    byte[] imageContent = s.getBytes();

    for (int i = 0; i < imageContent.length; i++) {
      System.out.println(imageContent[i]);
    }
  }
}
