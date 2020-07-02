package java8.stream;

import javafx.util.Pair;
import jdk.nashorn.internal.ir.CallNode;

import java.awt.image.ImageProducer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author scjn
 * @date 2020/6/30 10:32
 */
public class Quiz52 {

    public static void main(String[] args) {

        Integer[] a = new Integer[]{1, 2, 34, 5, 6};
        int[] b = new int[]{1, 2, 34, 5, 6};
        Arrays.stream(a)
                .map(c -> c * c)
                .forEach(System.out::println);

        Integer[] c = new Integer[]{1, 2};
        Integer[] d = new Integer[]{3, 4, 5};

        List<int[]> collect = Arrays.stream(c)
                .flatMap(integer -> Arrays.stream(d).map(j -> new int[]{integer, j}))
                .filter(j -> (j[0] + j[1]) % 3 == 0)
                .collect(Collectors.toList());

        for (int[] ints : collect) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
