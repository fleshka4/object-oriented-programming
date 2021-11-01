import java.util.*;
import java.util.stream.Collectors;

public class Utility {
    public static Double getAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(n -> n)
                .average().orElse(0);
    }

    public static List<String> toUpperCaseAndAddSpecialPrefix(List<String> list) {
        return list.stream().map(String::toUpperCase).map(str -> "_new_" + str).collect(Collectors.toList());
    }

    public static List<Integer> getSquares(List<Integer> list) {
        return list.stream()
                .filter(number -> Collections.frequency(list, number) == 1)
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    public static Collection<String> getSortedStrings(Collection<String> list, char c) {
        return list.stream()
                .filter(n -> n.startsWith(String.valueOf(c)))
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .skip((collection.size() > 0) ? (collection.size() - 1) : 0)
                .findAny()
                .orElseThrow();
    }

    public static Integer getSumOfEvenNumbers(int[] array) {
        return Arrays.stream(array)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static Map<Character, String> getMapFromListOfStrings(List<String> list) {
        return list.stream()
                .filter(s -> s.length() > 1)
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s.substring(1)));
    }
}
