/**
 * @author Deepak Rai
 */
package javaPrograms.LambdaAndStreamAPI;

@FunctionalInterface
interface OddCheck {
	boolean check(int num);
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

		// OddCheck c = a -> (a % 2 != 0);

		OddCheck c = FunctionalInterfaceConcept.isOdd();

		System.out.println(FunctionalInterfaceConcept.checker(c, 6));
	}

	private static OddCheck isOdd() {
		return a -> (a % 2 != 0);
	}

	private static boolean checker(OddCheck p, int num) {
		return p.check(num);
	}
}
