package dataStructuresAndAlgorithms;

public class FibonacciMemoized {

  private int[] memo = new int[1001];

  public int fib(int n) {
    System.out.println("n= " + n);

    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (memo[n] == 0) {
      memo[n] = fib(n - 1) + fib(n - 2);
    }
    return memo[n];
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    long preTime = System.currentTimeMillis();
    FibonacciMemoized obj = new FibonacciMemoized();
    System.out.println(obj.fib(24));
    long postTime = System.currentTimeMillis();
    System.out.println("Time taken to compute in milliseconds->" + (postTime - preTime));
  }
}
