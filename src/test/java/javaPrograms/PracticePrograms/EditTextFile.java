package javaPrograms.PracticePrograms;

// Java Program to illustrate reading from FileReader
// using BufferedReader
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditTextFile {

  public static void main(String[] args) throws IOException {
    // We need to provide file path as the parameter:
    // double back quote is to avoid compiler interpret words
    // like \test as \t (ie. as a escape sequence)

    File file = new File("C:\\Users\\deepa\\Downloads\\jiraLinks.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String st = "";
    String oldText = "";

    while ((st = br.readLine()) != null) {
      oldText = oldText + st + System.lineSeparator();
      st = br.readLine();
    }
    br.close();

    // Replace a word i a file
    String newText = oldText.replaceAll("workflow", "Deepak");

    FileWriter writer = new FileWriter(file);
    writer.write(newText);
    writer.close();
  }
}
