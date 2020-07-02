package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author scjn
 * @date 2020/6/24 10:26
 */
public class Lam {


    public static <T, E> List<T> map(List<E> oList, Function<E, T> func) {
        ArrayList<T> res = new ArrayList<>();
        for (E e : oList) {
            T t = func.apply(e);
            res.add(t);
        }
        return res;
    }

    public interface IntPredict {
        boolean test(int t);
    }

    public static void main(String[] args) {
//        System.out.println(map(Arrays.asList("12", "aaaaa", ""), String::length));
//        System.out.println(map(Arrays.asList("12", "aaaaa", ""), (String s) -> s+"!!!"));
        IntPredict en = (int i) -> i % 2 == 0;
        System.out.println(en.test(1000));

        Predicate<Integer> on = (i) -> i % 2 == 0;
        System.out.println(on.test(1000));
        int a = 3;
    }
}
