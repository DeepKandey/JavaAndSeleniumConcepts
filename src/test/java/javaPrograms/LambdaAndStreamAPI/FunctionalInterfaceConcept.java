/** @author Deepak Rai */
package javaPrograms.LambdaAndStreamAPI;

@FunctionalInterface
interface OddCheck {
  boolean check(int num); // only one abstract method. Can have many default methods
}

public class FunctionalInterfaceConcept {

  /**
   * {@summary Understanding lambda expression and Functional Interface}
   *
   * @param
   * @return
   * @author deepak rai
   */
  public static void main(String[] args) {

    // 1. One way to instantiate and define the abstract method of the interface
    // OddCheck c = a -> (a % 2 != 0);

    // 2. Another way to instantiate by define the abstract method of the interface (return type of
    // the method)
    OddCheck c = FunctionalInterfaceConcept.isOdd();

    // Calling user- defined method which internally calls abstract method
    System.out.println(FunctionalInterfaceConcept.checker(c, 6));
  }

  // creating instance of the interface by defining its abstract method
  private static OddCheck isOdd() {
    return a -> (a % 2 != 0);
  }

  // calling abstract method of the Interface which is defined above while
  // instantiating functional interface
  private static boolean checker(OddCheck p, int num) {
    return p.check(num);
  }
}
