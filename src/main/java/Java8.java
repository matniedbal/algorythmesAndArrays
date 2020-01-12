
import java.util.function.BiFunction;

public class Java8 {
    public static void main(String... args) {
        tryTo((n1, n2) -> n1 + n2);
        tryTo((n1, n2) -> n1 / n2);
        tryTo((n1, n2) -> n1 * n2);
        tryTo((n1, n2) -> (int)Math.sqrt(n1)* n2);
    }
//    public int tryToCount() {
//        try {
//            int a = 5;
//            int b = 7;
//            return a + b;
//        } catch (Exception e) {
//            System.out.println("Nie udana operacja matematyczna");
//        }
//        return 0;
//    }
//    public int tryToMultiply() {
//        try {
//            int a = 5;
//            int b = 7;
//            return a * b;
//        } catch (Exception e) {
//            System.out.println("Nie udana operacja matematyczna");
//        }
//        return 0;
//    }
//    public int tryToDivide() {
//        try {
//            int a = 5;
//            int b = 7;
//            return a / b;
//        } catch (Exception e) {
//            System.out.println("Nie udana operacja matematyczna");
//        }
//        return 0;
//    }
    public static int tryTo(
            BiFunction<Integer, Integer, Integer> function) {
        try {
            int a = 5;
            int b = 7;
            Integer result = function.apply(a, b);
            System.out.println("Result" + result);
            return result;
        } catch (Exception e) {
            System.out.println("Nie udana operacja matematyczna");
        }
        return 0;
    }
}