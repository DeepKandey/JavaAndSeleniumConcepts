package javaPrograms;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerAPIExamples {

    public static void main(String[] args) {

        // create an object of Faker class with default locale i.e ENG
        // Faker faker = new Faker();

        // create an object of Faker class with India locale
        Faker faker = new Faker(new Locale("en-IND"));

        // Generate valid random first name
        System.out.println("First name is: " + faker.name().firstName());
        // Generate valid random last name
        System.out.println("Last name is: " + faker.name().lastName());
        // Generate valid random city name
        System.out.println("City name is: " + faker.address().cityName());
        // Generate valid random state name
        System.out.println("State name is: " + faker.address().state());
        // Generate valid random country name
        System.out.println("Country name is: " + faker.address().country());
        // Generate valid random cell name
        System.out.println("Cell number is: " + faker.phoneNumber().cellPhone());
        // Generate valid random animal name
        System.out.println("Animal name is: " + faker.animal().name());

        // Generate random digit between 0-9 both inclusive
        System.out.println(faker.number().digit());
        System.out.println(faker.number().randomDigit());

        // Generate random digit between 1-9 both inclusive
        System.out.println(faker.number().randomDigitNotZero());

        // Generate digit of specific length
        System.out.println(faker.number().digits(3));
        System.out.println(faker.number().digits(5));

    }
}