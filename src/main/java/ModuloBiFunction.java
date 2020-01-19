import java.util.function.BiFunction;

public class ModuloBiFunction implements BiFunction<Integer,Integer,Integer> {

    @Override
    public Integer apply(Integer n1, Integer n2) {
        return n1 % n2;
    }
}
