package java8;

import java8.lambda.Banana;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author scjn
 * @date 2020/6/25 20:49
 */
public class FunctionInterface {

    public static void main(String[] args) {

        Function<String, Integer> func = String::length;
        Function<String, Integer> func2 = Integer::parseInt;

        BiPredicate<List<String>, String> contains = List::contains;

        Function<Integer, Banana> bnew = Banana::new;
        Supplier<Banana> bnewPure = Banana::new;

    }
}
