package practiceStream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCodingProblems {
    public static void main(String[] args) {
          double d = findAvg();
//        processLists();
    }

    private static double findAvg() {
//        int[] arr = {1,2,3,4,5,6};
        OptionalDouble avg = Arrays.asList(1,2,3,4,5,6).stream()
                .mapToInt(Integer::intValue)
                .average();

        OptionalDouble average = Arrays.asList(10, 20, 30, 40, 50).stream()
                .mapToInt(Integer::intValue) // 1. Convert Stream<Integer> to IntStream
                .average();
        return average.getAsDouble();
    }

    private static void processFrequencies(){
        List<String> words = Arrays.asList("apple", "banana", "fruit", "pomo", "apple", "banana", "grape", "pomo","apple");
        Map<String, Long> map = words.stream().
                collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Optional<Map.Entry<String, Long>> res =  map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst();
        res.ifPresent(System.out::println);
    }

    private static void processLists() {
        // List of lists of names
        List<List<List<String>>> listOfLists = Arrays.asList(
                Arrays.asList(
                        Arrays.asList("Reflection", "Collection", "Stream"),
                        Arrays.asList("Ref", "Coll", "Stre")),
                Arrays.asList(
                        Arrays.asList("Structure", "State", "Flow"),
                        Arrays.asList("Str", "Sta", "Flo")),
                Arrays.asList(
                        Arrays.asList("Sorting", "Mapping", "Reduction", "Stream"),
                        Arrays.asList("Sort", "Map", "Red"))
        );

        // Create a set to hold intermediate results
        Set<String> intermediateResults = new HashSet<>();

        // Stream pipeline demonstrating various intermediate operations
        List<String> result = listOfLists.stream()
                .flatMap(List<List<String>>::stream)
                .flatMap(List::stream)
                .filter(s -> s.startsWith("R"))
                .map(String::toUpperCase)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .peek(s -> intermediateResults.add(s))
                .collect(Collectors.toList());

        // Print the intermediate results
        System.out.println("Intermediate Results:");
        intermediateResults.forEach(System.out::println);

        // Print the final result
        System.out.println("Final Result:");
        result.forEach(System.out::println);
    }
}
