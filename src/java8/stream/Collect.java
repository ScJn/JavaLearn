package java8.stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

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

        dishes = Common.init();
        counting();
    }

    public static void groupByType() {
        Map<Dish.Type, List<Dish>> collect = dishes.stream().collect(Collectors.groupingBy(Dish::getType));

    }

    public static void groupByCal() {
        Map<Dish.Health, List<Dish>> collect = dishes.stream().collect(Collectors.groupingBy(dish -> {

            if (dish.getCalories() > 400) return Dish.Health.HEAT;
            else if (dish.getCalories() > 200) return Dish.Health.MIDDLE;
            else return Dish.Health.LOW;
        }));
    }

    public static void multiGroup(){
        Map<Dish.Type, Map<Dish.Health, List<Dish>>> collect = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(
                dish -> {
                    if (dish.getCalories() > 400) return Dish.Health.HEAT;
                    else if (dish.getCalories() > 200) return Dish.Health.MIDDLE;
                    else return Dish.Health.LOW;
                }
        )));
    }
    public static void multiGroup2(){
        Map<Dish.Type, Map<Dish.Health, HashSet<Dish>>> collect = dishes.stream().collect(groupingBy(Dish::getType, groupingBy(
                dish -> {
                    if (dish.getCalories() > 400) return Dish.Health.HEAT;
                    else if (dish.getCalories() > 200) return Dish.Health.MIDDLE;
                    else return Dish.Health.LOW;
                }
                , toCollection(HashSet::new))));
    }
    public static void groupAndCount(){
        Map<Dish.Type, Long> collect = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
    }

    public static void groupAndGetMaxCal(){
        Map<Dish.Type, Optional<Dish>> collect = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(comparing(Dish::getCalories))));
    }

    public static void groupAndGetMaxCalAndGet(){
        Map<Dish.Type, Dish> collect = dishes.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparing(Dish::getCalories)), Optional::get)));

    }

    public static void counting() {

        Long collect = dishes.stream().collect(Collectors.counting());
        System.out.println(collect);
    }
}
