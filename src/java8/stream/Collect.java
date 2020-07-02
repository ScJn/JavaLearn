package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Collectors can convert stream to list or a certain number
 * can count the number of stream
 * calculate the max and min of stream
 *
 * @author scjn
 * @date 2020/7/1 11:28
 */
public class Collect {
    static List<Dish> dishes = new ArrayList<>();

    public static void main(String[] args) {
        counting();
    }

    public static void counting(){
        dishes = Common.init();
        Long collect = dishes.stream().collect(Collectors.counting());
        System.out.println(collect);
    }
}
