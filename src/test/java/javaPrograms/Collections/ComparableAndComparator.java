package javaPrograms.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableAndComparator {

  public static void main(String[] args) {
    ArrayList<Movie> list = new ArrayList<>();
    list.add(new Movie("Force Awakens", 8.3, 2015));
    list.add(new Movie("Star Wars", 8.7, 1977));
    list.add(new Movie("Empire Strikes Back", 8.8, 1980));
    list.add(new Movie("Return of the Jedi", 8.4, 1983));

    // Sort by Rating
    System.out.println("Sorted by rating");
    RatingCompare ratingCompare = new RatingCompare();
    list.sort(ratingCompare);
    for (Movie movie : list)
      System.out.println(movie.getRating() + " " + movie.getName() + " " + movie.getYear());

    System.out.println("\nSorted by name");
    NameCompare nameCompare = new NameCompare();
    list.sort(nameCompare);
    for (Movie movie : list)
      System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());

    System.out.println("\nSorted by year");
    Collections.sort(list);
    for (Movie movie : list)
      System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
  }
}

class Movie implements Comparable<Movie> {

  private double rating;
  private String name;
  private int year;

  // Constructor
  public Movie(String name, double rating, int year) {
    this.rating = rating;
    this.name = name;
    this.year = year;
  }

  // Used to sort movies by year
  public int compareTo(Movie movie) {
    return this.year - movie.year;
  }

  // Getter methods for accessing private data
  public double getRating() {
    return rating;
  }

  public String getName() {
    return name;
  }

  public int getYear() {
    return year;
  }
}

// Class to compare Movies by ratings
class RatingCompare implements Comparator<Movie> {

  @Override
  public int compare(Movie m1, Movie m2) {
    return Double.compare(m1.getRating(), m2.getRating());
  }
}

// Class to compare Movies by name
class NameCompare implements Comparator<Movie> {

  @Override
  public int compare(Movie m1, Movie m2) {
    return m1.getName().compareTo(m2.getName());
  }
}
