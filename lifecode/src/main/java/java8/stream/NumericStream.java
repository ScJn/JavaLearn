package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * IntStream
 * @author scjn
 * @date 2020/6/30 15:53
 */
public class NumericStream {
    static List<Dish> dishes = new ArrayList<>();

    public static void main(String[] args) {
        dishes = Common.init();

        Map<Dish.Type, List<Dish>> collect = dishes.stream().collect(Collectors.groupingBy(Dish::getType));

    }

    public static void te(){
        int a =3;
        List<double[]> collect = IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}).filter(t -> t[2] % 1 == 0).collect(Collectors.toList());
        for (double[] doubles : collect) {
            System.out.printf("%.0f,%.0f,%.0f\n", doubles[0], doubles[1], doubles[2]);
        }
    }
    public static void findTriple() {


        IntStream intStream = IntStream.rangeClosed(1, 100);
        Stream<Integer> boxed = intStream.boxed();
        List<double[]> collect = boxed.flatMap(a -> IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}).filter(t -> t[2] % 1 == 0))
                .collect(Collectors.toList());
        for (double[] doubles : collect) {
            System.out.printf("%.0f,%.0f,%.0f\n", doubles[0], doubles[1], doubles[2]);
        }
    }

    public static void getEven() {

        IntStream.rangeClosed(2, 10)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
        IntStream.range(2, 10)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }



    public static void streamSum(Stream<Dish> stream) {
        int sum = stream.mapToInt(Dish::getCalories).sum();
        System.out.println(sum);
    }

}
