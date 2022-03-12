package javaPrograms.Collections;

import java.util.HashMap;

public class MergeMethod {

  public static void main(String[] args) {
    // create an HashMap
    HashMap<String, Integer> prices = new HashMap<>();

    // insert entries to the HashMap
    prices.put("Shoes", 200);
    prices.put("Bag", 300);
    prices.put("Pant", 150);
    System.out.println("HashMap: " + prices);

    int returnedValue_price =
        prices.merge("Shirt", 100, (oldValue, newValue) -> oldValue + newValue);
    System.out.println("Price of Shirt: " + returnedValue_price);

    // print updated HashMap
    System.out.println("Updated HashMap: " + prices);
    // ****************************************

    // create an HashMap
    HashMap<String, String> countries = new HashMap<>();

    // insert entries to the HashMap
    countries.put("Washington", "America");
    countries.put("Canberra", "Australia");
    countries.put("Madrid", "Spain");
    System.out.println("HashMap: " + countries);

    // merge mapping for key Washington
    String returnedValue_countries =
        countries.merge("Washington", "USA", (oldValue, newValue) -> oldValue + "/" + newValue);
    System.out.println("Washington: " + returnedValue_countries);

    // print updated HashMap
    System.out.println("Updated HashMap: " + countries);
    // ****************************************

    // create an HashMap
    HashMap<String, Integer> prices1 = new HashMap<>();

    // insert entries to the HashMap
    prices1.put("Pant", 230);
    prices1.put("Shoes", 320);
    System.out.println("HashMap 1: " + prices1);

    // create another HashMap
    HashMap<String, Integer> prices2 = new HashMap<>();

    // insert entries to the HashMap
    prices2.put("Shirt", 150);
    prices2.put("Shoes", 320);
    System.out.println("HashMap 2: " + prices2);

    // forEach() access each entry of prices2
    // merge() inserts each entry from prices2 to price1
    prices2.forEach(
        (key, value) ->
            prices1.merge(
                key,
                value,
                (oldValue, newValue) -> {
                  // return the smaller value
                  if (oldValue < newValue) {
                    return oldValue;
                  } else {
                    return newValue;
                  }
                }));

    System.out.println("Merged HashMap: " + prices1);
  }
}
