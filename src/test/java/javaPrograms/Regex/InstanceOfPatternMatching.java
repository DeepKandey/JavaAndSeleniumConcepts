package javaPrograms.Regex;

public class InstanceOfPatternMatching {
  /*
  Pattern matching for instanceOf performing casts after type comparison
   */

  public static void main(String[] args) {
    Object o = "I am a string as an object";
    if(o instanceof String str){
      System.out.println(str.toUpperCase());
    }

    if(o instanceof String str && !str.isEmpty()){
      System.out.println(str.toUpperCase());
    }

    Object obj= 123;
    if(!(obj instanceof String str)){
      throw  new RuntimeException("Please provide string!");
    }
  }
}
