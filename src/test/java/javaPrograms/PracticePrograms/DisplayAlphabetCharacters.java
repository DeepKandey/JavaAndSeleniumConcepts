/** */
package javaPrograms.PracticePrograms;

/** @author Deepak Rai */
public class DisplayAlphabetCharacters {

  /**
   * {@summary method to display Alphabet Characters}
   *
   * @param args
   * @return
   * @author deepak
   */
  public static void main(String[] args) {

    // For small case alphabets
    for (char c = 'a'; c <= 'z'; c++) {
      System.out.print(c + " ");
    }

    System.out.println("\n----------------");

    // For upper case alphabets
    for (char c = 'A'; c <= 'Z'; c++) {
      System.out.print(c + " ");
    }
  }
}
