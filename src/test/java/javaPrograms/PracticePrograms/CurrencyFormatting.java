/**
 * @author Deepak Rai
 */
package javaPrograms.PracticePrograms;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyFormatting {

	/**
	 * {@summary to use Locale class to display currency format of different country
	 * and language.}
	 * 
	 * @param
	 * @return
	 * @author deepak rai
	 */
	public static void main(String[] args) {

		// This is the amount which we want to format
		Double currencyAmount = Double.valueOf(123456789.555);

		// Using France locale
		Locale currentLocale = Locale.FRANCE;

		// Currency Formatter specific to locale
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);

		// Get currency instance from locale; This will have all currency related
		// information
		Currency currentCurrency = Currency.getInstance(currentLocale);

		// Test the output
		System.out.println("Country : " + currentLocale.getDisplayName());
		System.out.println("Currency : " + currentCurrency.getDisplayName());
		System.out.println("Currency format: " + currencyFormatter.format(currencyAmount));

		// Currency formatting for India as India does not have built-in Locale
		System.out.println("Currency format for India "
				+ NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(currencyAmount));

	}
}