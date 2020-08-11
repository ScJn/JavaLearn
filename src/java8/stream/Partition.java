package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author scjn
 * @date 2020/7/9 16:13
 */
public class Partition {

    static List<Dish> dishes = new ArrayList<>();

    public static void main(String[] args) {

//        for (int i = 3; i < 100; i++) {
//            if (isPrime(i)) {
//                System.out.println(i);
//            }
//
//        }
    }

    public static void common(){
        Map<Boolean, List<Dish>> collect = dishes.stream().collect(partitioningBy(Dish::isVegetarian));
        // or
        List<Dish> collect1 = dishes.stream().filter(Dish::isVegetarian).collect(toList());
    }

    public static boolean isPrime(int num){
        double sqrt = Math.sqrt(num);
        return IntStream.rangeClosed(2, (int) sqrt)
                .noneMatch(a -> num % a == 0);
    }

    public static void getAllPrime(Integer n){
        List<Integer> collect = IntStream.rangeClosed(2, n)
                .filter(Partition::isPrime)
                .boxed()
                .collect(toList());

//        for (Integer integer : collect) {
//            System.out.println(integer);
//        }
    }
}
