import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        for (Method method : MyClass.class.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(MyAnnotation.class)) {
                continue;
            }
            method.setAccessible(true);
            for (int i = 0; i < method.getAnnotation(MyAnnotation.class).value(); i++) {
                try {
                    method.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
