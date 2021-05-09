package java8;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

/**
 * @author scjn
 * @date 2020/6/27 09:26
 */
public class CombineFunctionalInterface {


    public static Integer cal(Function<Integer, Integer> func, int a, int b) {
        Integer fa = func.apply(a);
        Integer fb = func.apply(b);
        return (fa + fb) * Math.abs(b - a) / 2;
    }

    public static void main(String[] args) {


        Function<Integer,Integer> function = (x) -> 2 * x;
        System.out.println(cal(function, 0, 2));

    }
}
