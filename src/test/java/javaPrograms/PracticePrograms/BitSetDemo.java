package javaPrograms.PracticePrograms;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;

public class BitSetDemo {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner scan = new Scanner(System.in);
    int bitSetLength = scan.nextInt();
    int numberOfOperations = scan.nextInt();

    BitSet bs1 = new BitSet(bitSetLength);
    BitSet bs2 = new BitSet(bitSetLength);

    HashMap<Integer, BitSet> map = new HashMap<>();
    map.put(1, bs1);
    map.put(2, bs2);

    for (int i = 0; i < numberOfOperations; i++) {

      String operation = scan.next();
      int one = scan.nextInt();
      int two = scan.nextInt();

      switch (operation) {
        case "AND":
          map.get(one).and(map.get(two));
          break;
        case "OR":
          map.get(one).or(map.get(two));
          break;
        case "XOR":
          map.get(one).xor(map.get(two));
          break;
        case "FLIP":
          map.get(one).flip(two);
          break;
        case "SET":
          map.get(one).set(two);
          break;
        default:
          break;
      }
      System.out.println(bs1.cardinality() + " " + bs2.cardinality());
    }
  }
}
