package javaPrograms.PracticePrograms;

class Calc {
  public int add(int... n) { // variable arguments
    int sum = 0;

    for (int i : n) {
      sum = sum + i;
    }
    return sum;
  }
}

public class VarArgsDemo {

  public static void main(String[] args) {
    Calc obj = new Calc();
    System.out.println("Sum of the numbers: " + obj.add(4, 8, 9));
  }
}
