public class MyClass {
    @MyAnnotation
    private static void first() {
        System.out.println("First");
    }

    @MyAnnotation(2)
    private static void second() {
        System.out.println("Second");
    }

    @MyAnnotation(3)
    private static void third() {
        System.out.println("Third");
    }
}
