package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class stream_api {


    public static class Main {
        public static void main(String[] args) {
            List<String> names = Arrays.asList("John", "Alice", "Bob", "Carol", "David", "Alex");

            Optional<String> result = names.stream()
                    // Filtering names starting with 'A'
                    .filter(name -> name.startsWith("A"))
                    // Mapping to uppercase
                    .map(String::toUpperCase)
                    // Sorting in reverse order
                    .sorted((name1, name2) -> name2.compareTo(name1))
                    // Finding the first element (if present)
                    .findFirst();

            result.ifPresentOrElse(
                    // If present, print the result
                    System.out::println,
                    // If not present, print a message
                    () -> System.out.println("No name starting with 'A' found.")
            );

            // Counting names starting with 'D'
            long countOfNamesStartingWithD = names.stream()
                    .filter(name -> name.startsWith("D"))
                    .count();
            System.out.println("Count of names starting with 'D': " + countOfNamesStartingWithD);

            // Concatenating all names into a single string
            String concatenatedNames = names.stream()
                    .collect(Collectors.joining(", "));
            System.out.println("Concatenated names: " + concatenatedNames);

            // Calculating the average length of names
            double averageNameLength = names.stream()
                    .mapToInt(String::length)
                    .average()
                    .orElse(0);
            System.out.println("Average length of names: " + averageNameLength);
        }
    }

}
