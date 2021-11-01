import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Utility.getAverage(List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)));
        System.out.println(Utility.toUpperCaseAndAddSpecialPrefix(List.of("hello", "bye", "time", "first")));
        System.out.println(Utility.getSquares(List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)));
        System.out.println(Utility.getSortedStrings(List.of("hello", "bye", "time", "first"), 'b'));
        System.out.println(Utility.getLastElement(List.of("hello", "bye", "time", "first")));
        System.out.println(Utility.getSumOfEvenNumbers(new int[] {10, 25, 31, 40, 53, 69, 70, 80, 91, 100}));
        System.out.println(Utility.getMapFromListOfStrings(List.of("hello", "bye", "time", "first")));
    }
}
