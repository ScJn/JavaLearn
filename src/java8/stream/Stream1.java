package java8.stream;

import java8.Banana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author scjn
 * @date 2020/6/27 10:41
 */
public class Stream1 {

    public static void main(String[] args) {

        Integer[] a = new Integer[]{1, 2, 3,33, 4, 5};
        streamAdd(Arrays.stream(a));
        streamMax(Arrays.stream(a));

        count(Arrays.stream(a));
    }


    public static void flatMap(){
        String[] words = {"hello", "world", "and", "you"};
        List<String> collect = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    public static void streamAdd(Stream<Integer> stream) {
        Integer reduce = stream.reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    public static void streamMax(Stream<Integer> stream) {
        Integer max = stream.reduce(Integer.MIN_VALUE, Integer::max);
//        Integer max = stream.reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println(max);
    }

    public static void count(Stream<Integer> stream){
        Integer count = stream.map(d->1)
                .reduce(0, (a,b) -> a+b);
        System.out.println(count);
    }

    public void combine() {
        List<Banana> bananaList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bananaList.add(new Banana(i, i));
        }
        List<Integer> collect = bananaList.stream()
                .sorted(Comparator.comparing(Banana::getSize).reversed())
                .filter((banana) -> {
                    System.out.println(banana.getSize());
                    return banana.getSize() > 4;

                })
                .map((banana) -> {
                    System.out.println(banana.getSize());
                    return banana.getSize();
                })
                .collect(Collectors.toList());

        System.out.println(collect);
    }


}
