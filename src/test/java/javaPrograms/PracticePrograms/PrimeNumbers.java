package javaPrograms.PracticePrograms;

public class PrimeNumbers {

	public static void main(String[] args) {
		Boolean primeNumber_flag = isPrimeNumber(54);

		if (primeNumber_flag) {
			System.out.println("This is a prime number");
		} else {
			System.out.println("This is not a prime number");
		}

		getPrimeNumbers(100);
	}

	public static boolean isPrimeNumber(int num) {
//		int num;
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Enter a Number to check if it is a prime number: ");
//		num = scan.nextInt();
//		scan.close();

		if (num == 2) {
			return true;
		}
		
		if (num <= 1 || num % 2 == 0) {
			return false;
		}

		for (int i = 3; i < Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void getPrimeNumbers(int num) {

		System.out.println("****--Prime numbers upto " + num + "--****");
		for (int i = 2; i <= num; i++) {
			if (isPrimeNumber(i))
				System.out.print(i + " ");
		}
	}
}