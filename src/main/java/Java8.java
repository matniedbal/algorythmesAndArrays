
import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8 {
    public static void main(String... args) {
//        tryTo((n1, n2) -> n1 + n2);
//        tryTo((n1, n2) -> n1 / n2);
//        tryTo((n1, n2) -> n1 * n2);
//        tryTo((n1, n2) -> (int) Math.sqrt(n1) * n2);
//        tryTo(new ModuloBiFunction());
//        tryTo((n1, n2) -> n1 * n2 + 10 * n2);
//
//        tryToE((n1, n2) -> {
//            String temp = (String) n1;
//            return n1 + n2.toString();
//
//        }, "dsasd", 2);

        System.out.println(doSomething((str1,str2) -> str1.length() + str2.length(), "reset", "dupa"));

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
            int a = 6;
            int b = 7;
            Integer result = function.apply(a, b);
            System.out.println("Result" + result);
            return result;
        } catch (Exception e) {
            System.out.println("Nie udana operacja matematyczna");
        }
        return 0;
    }

    public static <E, T> String tryToE(
            BiFunction<E, T, String> function, E a, T b) {
        try {
            String result = function.apply(a, b);
            System.out.println("Result" + result);
            return result;
        } catch (Exception e) {
            System.out.println("Nie udana operacja matematyczna");
        }
        return "";
    }

    public static Integer doSomething(
            BiFunction<String, String, Integer> function, String a, String b) {

        try {
            Integer result = function.apply(a , b);
            return result;

        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        return 0;
    }
}



