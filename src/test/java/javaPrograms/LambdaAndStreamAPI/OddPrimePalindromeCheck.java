/**
 * @author Deepak Rai
 */
package javaPrograms.LambdaAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@FunctionalInterface
interface PerformOperation {
	boolean check(int a);
}

// MyMath class
class MyMath {

	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	// PerformOperation p= (a) -> (a % 2 == 1);

	// Odd check
	public PerformOperation isOdd() {
		return (a) -> (a % 2 == 1);
	}

	// Prime check
	public PerformOperation isPrime() {
		return (a) -> {
			for (int i = 2; i <= a / 2; i++) {
				if (a % i == 0)
					return false;
			}
			return true;
		};
	}

	// Palindrome check
	public PerformOperation isPalindrome() {
		return (a) -> {
			int rev = 0;
			int r = 0;
			int n = a;
			while (n != 0) {
				r = n % 10;
				rev = rev * 10 + r;
				n /= 10;
			}
			return (rev == a);
		};
	}
}

public class OddPrimePalindromeCheck {

	public static void main(String[] args) throws IOException {

		PerformOperation op;
		MyMath objMyMath = new MyMath();
		boolean ret = false;
		String ans = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (ch == 1) {
				op = objMyMath.isOdd();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = objMyMath.isPrime();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = objMyMath.isPalindrome();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
			}
			System.out.println(ans);
		}
	}
}