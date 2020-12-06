/**
 * @author Deepak Rai
 */
package javaPrograms.LambdaAndStreamAPI;

import java.util.Optional;

/**
 * @author Deepak Rai
 *
 */
public class OptionalConcept {

	/**
	 * {@summary Optional concept examples}
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */
	public static void main(String[] args) {

		// empty()
		Optional<String> optionalString = Optional.empty();
		System.out.println(optionalString);

		// ofNullable()
		String book = null;
		optionalString = Optional.ofNullable(book);

		// isPresent() and get()
		if (optionalString.isPresent())
			System.out.println(optionalString.get().toUpperCase());
		else
			System.out.println("value not present: " + optionalString);

		// orElse()
		Optional<String> optionalNull = Optional.ofNullable(null);
		System.out.println(optionalNull.orElse("Java 8 Optional orElse() method").toUpperCase());

		Optional<String> optionaIsEmpty = Optional.empty();
		// isEmpty()
		if (optionaIsEmpty.isEmpty())
			System.out.println(optionalString);

	}
}